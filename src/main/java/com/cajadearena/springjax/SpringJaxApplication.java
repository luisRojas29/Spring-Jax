package com.cajadearena.springjax;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.cajadearena.springjax.daos.DefaultStormTrooperDao;
import com.cajadearena.springjax.daos.StormTrooperDao;

@SpringBootApplication
public class SpringJaxApplication {
	
	@Bean
    protected StormTrooperDao stormtrooperDao() {
        return new DefaultStormTrooperDao();
    }

	public static void main(String[] args) {
		SpringApplication.run(SpringJaxApplication.class, args);
	}
}
