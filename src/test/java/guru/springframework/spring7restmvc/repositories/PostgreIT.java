package guru.springframework.spring7restmvc.repositories;

import guru.springframework.spring7restmvc.entities.Beer;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.postgresql.PostgreSQLContainer;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@Testcontainers
@SpringBootTest
@ActiveProfiles("localpostgresql")
public class PostgreIT {

	@Container
	static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer("postgres:latest");

	@Autowired
	BeerRepository beerRepository;

	@Test
	void testListBeers() {
		List<Beer> beers = beerRepository.findAll();

		assertThat(beers.size()).isGreaterThan(0);
	}
}
