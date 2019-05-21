package iceAndFire.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.List;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class Character {
    @Id
    private Long id;

    private String url;
    @Column
    private String name;
    @Column

    private String gender;
    @Column
    private String culture;
    @Column
    private String born;
    @Column
    private String died;
    @Column
    @ElementCollection(targetClass = String.class)
    private List<String> titles;
    @Column
    @ElementCollection(targetClass = String.class)
    private List<String> aliases;
    @Column
    @ElementCollection(targetClass = String.class)
    private List<String> playedBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }


    public String getBorn() {
        return born;
    }

    public void setBorn(String born) {
        this.born = born;
    }

    public String getDied() {
        return died;
    }

    public void setDied(String died) {
        this.died = died;
    }

    public List<String> getTitles() {
        return titles;
    }

    public void setTitles(List<String> titles) {
        this.titles = titles;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public void setAliases(List<String> aliases) {
        this.aliases = aliases;
    }

    public List<String> getPlayedBy() {
        return playedBy;
    }

    public void setPlayedBy(List<String> playedBy) {
        this.playedBy = playedBy;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setIdFromUrl() {
        String id = url.replace("https://anapioficeandfire.com/api/characters/", "");
        this.id = Long.parseLong(id);
    }


    public String getCulture() {
        return culture;
    }

    public void setCulture(String culture) {
        this.culture = culture;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("<br> <div> This character id is ")
                .append(id).append(". The name is: ").append(name)
                .append("and it is a proud ").append(culture)
                .append(". It's gender is ").append(gender)
                .append(". This character was born in ");

        if(born.isEmpty()){
            stringBuilder.append(" ...we don't know really");
        }else {
            stringBuilder.append(born);
        }

        if (died.isEmpty()) {
            stringBuilder.append(" and what do we say to the God of Death?! NOT TODAY");
        } else {
            stringBuilder.append(" and died in ").append(died);
        }
        stringBuilder.append(" <br> Ttles: ").append(titles)
                .append(" <br> Aliases: ").append(aliases)
                .append(" <br> This character was played by : ")
                .append(playedBy).append(" </div> <br><br><br>");

        return stringBuilder.toString();
    }

}
