package com.example.pact.consumer;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonArray;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit.PactProviderRule;
import au.com.dius.pact.consumer.junit.PactVerification;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import com.example.pact.provider.model.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;

import java.util.HashMap;

public class PersonConsumerContractTest {

    @Rule
    public PactProviderRule mockProvider = new PactProviderRule("Person", this);

    @Pact(consumer = "PersonConsumer")
    public RequestResponsePact createPact(PactDslWithProvider builder) {
        DslPart body = PactDslJsonArray.arrayEachLike()
                .uuid("id")
                .stringType("name", "Joe Ramone")
                .closeObject();

        return builder
                .given("There is a person")
                .uponReceiving("Retrieve Person")
                .path("/api/v1/person")
                .method("GET")
                .willRespondWith()
                .status(200)
                .headers(new HashMap<String, String>() {{
                    put("Content-Type", "application/json");
                }})
                .body(body)
                .toPact();
    }

    @Test
    @PactVerification
    public void test() throws JsonProcessingException {
        //Arrange
        PersonConsumer personConsumer = new PersonConsumer(mockProvider.getUrl());

        //Act
        Person[] people = personConsumer.getPeople();
        Person person = people[0];

        //Assert
        Assert.assertEquals(person.getName(), "Joe Ramone");
    }
}