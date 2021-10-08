package com.example.pact.provider;

import au.com.dius.pact.provider.junit.PactRunner;
import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactBroker;
import au.com.dius.pact.provider.junit.loader.PactBrokerAuth;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junit.target.Target;
import au.com.dius.pact.provider.junit.target.TestTarget;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.springframework.boot.SpringApplication;

@RunWith(PactRunner.class)
@Provider("Person")
@PactBroker(host = "localhost", port = "3080")
public class PersonProviderContractTest {

    @TestTarget
    public final Target target = new HttpTarget("localhost", 8080);

    @BeforeClass
    public static void setup() {
        SpringApplication.run(PactContractTestingApplication.class);
    }

    @State("There is a person")
    public void savePerson() { }
}
