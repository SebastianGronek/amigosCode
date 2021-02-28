package com.example.ExerciseWithAmigosCode.DAO;

import com.example.ExerciseWithAmigosCode.Model.Person;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonDAO {
    int insertPerson(UUID uuid, Person person);

    default int insertPerson(Person person) {
        UUID id = UUID.randomUUID();
        return insertPerson(id, person);
    }

    int deletePerson(UUID uuid);

    int updatePersonById(UUID id, Person person);

    Optional<Person> selectPersonById(UUID uuid);

    List<Person> selectAllPeople();
}
