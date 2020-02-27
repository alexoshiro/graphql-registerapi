package project.alexoshiro.graphql.registerapi.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import project.alexoshiro.graphql.registerapi.model.SystemUser;

public interface UserRepository extends MongoRepository<SystemUser, String> {
	public List<SystemUser> findByUsername(String username);
}
