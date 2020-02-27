package project.alexoshiro.graphql.registerapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import project.alexoshiro.graphql.registerapi.model.Person;

public interface PersonRepository extends MongoRepository<Person, String> {
	
}
