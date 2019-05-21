package iceAndFire.dao;

import iceAndFire.model.Character;
import org.springframework.data.repository.CrudRepository;

public interface CharacterDAO extends CrudRepository<Character, Long> {

}
