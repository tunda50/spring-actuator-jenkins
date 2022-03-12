package com.example.demo;

import java.net.Socket;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component("account")
public class UrlShortenerServiceHealthIndicator implements HealthIndicator {

	private static final String URL = "https://cleanuri.com/api/v1/shorten";

	@Override
	public Health health() {
		// check if url shortener service url is reachable
		try (Socket socket = new Socket(new java.net.URL(URL).getHost(), 80)) {
		} catch (Exception e) {
			System.out.println("Failed to connect to:" + URL);
			return Health.down().withDetail("error", e.getMessage()).build();
		}
		return Health.up().withDetail("name", "account service").build();
	}

}