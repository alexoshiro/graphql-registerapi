package project.alexoshiro.graphql.registerapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import project.alexoshiro.graphql.registerapi.model.Person;
import project.alexoshiro.graphql.registerapi.repository.PersonRepository;
import project.alexoshiro.graphql.registerapi.service.IPersonService;

@Service
public class PersonService implements IPersonService {

	private final PersonRepository personRepository;

	@Autowired
	PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	@Override
	public List<Person> getPeople() {
		return personRepository.findAll();
	}

}
