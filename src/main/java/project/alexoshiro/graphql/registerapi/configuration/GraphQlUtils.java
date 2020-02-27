package project.alexoshiro.graphql.registerapi.configuration;

import static graphql.GraphQL.newGraphQL;
import static graphql.schema.idl.RuntimeWiring.newRuntimeWiring;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import graphql.GraphQL;
import graphql.schema.GraphQLSchema;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import project.alexoshiro.graphql.registerapi.data.fetcher.AllPeopleDataFetcher;

@Component
public class GraphQlUtils {

	@Value("classpath:schemas.graphqls")
	private Resource schemaRecource;
	private GraphQL graphQL;
	private AllPeopleDataFetcher allPeopleDataFetcher;

	@Autowired
	public GraphQlUtils(AllPeopleDataFetcher allPeopleDataFetcher) {
		this.allPeopleDataFetcher = allPeopleDataFetcher;
	}

	@PostConstruct
	public GraphQL createGraphQlObject() throws IOException {
		File schemas = schemaRecource.getFile();
		TypeDefinitionRegistry typeRegistry = new SchemaParser().parse(schemas);
		RuntimeWiring wiring = buildRuntimeWiring();
		GraphQLSchema schema = new SchemaGenerator().makeExecutableSchema(typeRegistry, wiring);
		return newGraphQL(schema).build();
	}

	public RuntimeWiring buildRuntimeWiring() {
		return newRuntimeWiring()
				.type("Query", typeWiring -> typeWiring
						.dataFetcher("people", allPeopleDataFetcher))
				.build();
	}
}
