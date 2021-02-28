package com.example.ExerciseWithAmigosCode.DAO;

import com.example.ExerciseWithAmigosCode.Model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("postgres")
public class PersonDataAccessService implements PersonDAO {


    @Override
    public int insertPerson(UUID uuid, Person person) {
        return 0;
    }


    @Override
    public int deletePerson(UUID uuid) {
        return 0;
    }

    @Override
    public int updatePersonById(UUID id, Person person) {
        return 0;
    }

    @Override
    public Optional<Person> selectPersonById(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public List<Person> selectAllPeople() {
        return List.of(new Person(UUID.randomUUID(), "From Postgres DB"));
    }
}
