package project.alexoshiro.graphql.registerapi.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import graphql.ExecutionResult;
import graphql.GraphQL;
import project.alexoshiro.graphql.registerapi.configuration.GraphQlUtils;

@RestController
public class MainController {

	private GraphQL graphQL;
	private GraphQlUtils graphQlUtils;

	@Autowired
	MainController(GraphQlUtils graphQlUtils) throws IOException {
		this.graphQlUtils = graphQlUtils;
		graphQL = graphQlUtils.createGraphQlObject();
	}

	@PostMapping(value = "/query")
	public ResponseEntity<?> query(@RequestBody String query) {
		ExecutionResult result = graphQL.execute(query);
		
		return ResponseEntity.ok(result.getData());
	}
}
