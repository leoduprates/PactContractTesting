package com.example.pact.consumer;

import com.example.pact.provider.model.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class PersonConsumer {
    final String url;

    public PersonConsumer(String url) {
        this.url = url;
    }

    public Person[] getPeople() throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Person[]> response = restTemplate.getForEntity(url + "/api/v1/person", Person[].class);
        Person[] people = response.getBody();

        return people;
    }
}
