package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(DemoApplication.class, args);

		HttpClient client = HttpClient.newHttpClient();

		// GET: obtener todos los productos
		HttpRequest request = HttpRequest.newBuilder()
				.uri(new URI("http://localhost:8080/api/productos"))
				.GET()
				.build();

		HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
		System.out.println("GET Response:");
		System.out.println(response.body());
	}

}
