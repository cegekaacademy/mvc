package iceAndFire.service;

import iceAndFire.model.Character;

public interface CharacterService {

    String getAllCharacters();
    String getCharacterById(Long id);
    String saveCharacter(Character character);
    String deleteCharacter(Character character);
    String updateCharacter(Character character);
    void deleteCharacterById(Long id);
}
