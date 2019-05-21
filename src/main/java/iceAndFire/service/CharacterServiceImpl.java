package iceAndFire.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import iceAndFire.dao.CharacterDAO;
import iceAndFire.model.Character;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Optional;

@Service
public class CharacterServiceImpl implements CharacterService {

    @Value("${url.characters}")
    private String urlCharacters;

    private CharacterDAO characterDAO;

    @Autowired
    public CharacterServiceImpl(CharacterDAO characterDAO) {
        this.characterDAO = characterDAO;
    }

    @PostConstruct
    private void loadCharactersFromApi() {
        try {
            URL url = new URL(urlCharacters);
            HttpsURLConnection con = (HttpsURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");

            int status = con.getResponseCode();
            if (status > 299) {
                throw new Exception();
            }

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer content = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                content.append(inputLine);
            }
            in.close();

            mapResponse(content);
        } catch (Exception e) {
            //Something went bad
            // try to insert data by post method
        }

    }

    @Override
    public String getAllCharacters() {
        return characterDAO.findAll().toString();
    }

    @Override
    public String getCharacterById(Long id) {
        Optional<Character> character = characterDAO.findById(id);
        if (character.isPresent()) {
            return character.get().toString();
        }
        return "";
    }

    public String saveCharacter(Character character) {
        return "Character with id: " + characterDAO.save(character).getId() + " was saved to h2 database.";
    }

    @Override
    public String deleteCharacter(Character character) {
        characterDAO.delete(character);
        return "WHAT DO WE SAY TO THE GOD OF DEATH? TODAY!";
    }

    public void deleteCharacterById(Long id) {
        characterDAO.findById(id).ifPresent(character -> characterDAO.delete(character));
    }

    @Override
    public String updateCharacter(Character character) {
        characterDAO.save(character);
        return "MODIFIED IT'S FAITH.";
    }


    private void mapResponse(StringBuffer content) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            Character[] characterList = objectMapper.readValue(content.toString(), Character[].class);
            for (Character c : characterList) {
                c.setIdFromUrl();
                characterDAO.save(c);
            }
        } catch (IOException e) {
            throw new Exception("Could not map.");
        }
    }
}
