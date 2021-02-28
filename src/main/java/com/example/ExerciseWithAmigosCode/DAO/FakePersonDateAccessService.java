package com.example.ExerciseWithAmigosCode.DAO;

import com.example.ExerciseWithAmigosCode.Model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonDateAccessService implements PersonDAO {

    private static List<Person> DB = new ArrayList<>();

    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id, person.getName()));
        return 1;
    }

    @Override
    public int deletePerson(UUID id) {
        Optional<Person> optionalPerson = selectPersonById(id);
        if (optionalPerson.isEmpty()) {
            return 0;
        } else {
            DB.remove(optionalPerson.get());
            return 1;
        }
    }

    @Override
    public int updatePersonById(UUID id, Person personToUpdate) {
        return selectPersonById(id).map(person -> {
            int indexOfPersonToUpdate = DB.indexOf(person);
            if (indexOfPersonToUpdate >= 0) {
                DB.set(indexOfPersonToUpdate, new Person(id, personToUpdate.getName()));
                return 1;
            }
            return 0;
        }).orElse(0);
    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
        return DB.stream().filter(person -> person.getId().equals(id)).findFirst();
    }

    @Override
    public List<Person> selectAllPeople() {
        return DB;
    }
}
