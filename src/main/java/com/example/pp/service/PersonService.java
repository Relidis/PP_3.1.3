package com.example.pp.service;

import com.example.pp.model.Person;
import com.example.pp.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    private final PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }




    public Person oneUser(long id){
        return personRepository.findById(id).orElse(null);
    }
    public Iterable<Person> allUsers(){
        return personRepository.findAll();

    }
    public Person save(Person person){
        return personRepository.save(person);

    }
    public void delete(Long id){
        personRepository.deleteById(id);

    }
    public void update(long id, Person updatedPerson){

        Person toBeUpdated = oneUser(id);
        toBeUpdated.setName(updatedPerson.getName());
        toBeUpdated.setLastname(updatedPerson.getLastname());
     }

}

