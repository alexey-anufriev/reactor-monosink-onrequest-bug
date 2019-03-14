package com.alexeyanufriev.monosinkbug;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@WebFluxTest
public class MonoSinkBugApplicationTests {

	private WebTestClient client;

	@Before
	public void setUp() {
		this.client = WebTestClient.bindToController(new ReactiveController()).build();
	}

	@Test
	public void fluxShouldReturnValue() {
		this.client.get().uri("/flux").accept(MediaType.TEXT_PLAIN).exchange()
				.expectStatus().isOk()
				.expectBodyList(String.class).hasSize(1).contains("flux-result");
	}

	@Test
	public void monoShouldReturnValue() {
		this.client.get().uri("/mono").accept(MediaType.TEXT_PLAIN).exchange()
				.expectStatus().isOk()
				.expectBody(String.class).isEqualTo("mono-result");
	}

}
