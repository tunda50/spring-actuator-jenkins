package com.example.demo;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component("random")
public class RandomHealthIndicator implements HealthIndicator {

    @Override
    public Health health() {
        double chance = ThreadLocalRandom.current().nextDouble();
        Health.Builder status = Health.up();
        if (chance > 0.9) {
            status = Health.down();
        }
        return  status
        	      .withDetail("component", chance)
        	      .withDetail("strategy", "thread-local")
        	      .build();
    }
}