package project.alexoshiro.graphql.registerapi.data.fetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import project.alexoshiro.graphql.registerapi.model.Person;
import project.alexoshiro.graphql.registerapi.service.IPersonService;

@Component
public class AllPeopleDataFetcher implements DataFetcher<List<Person>> {

	private final IPersonService personService;
	
	@Autowired
	AllPeopleDataFetcher(IPersonService personService){
		this.personService = personService;
	}
	
	@Override
	public List<Person> get(DataFetchingEnvironment env) {
		List<Person> people = personService.getPeople();
		return people;
	}

}
