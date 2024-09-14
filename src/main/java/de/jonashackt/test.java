package de.jonashackt;


import org.springframework.stereotype.Service;

@Service
public class test implements ExampleClient {

    @Override
    public String getEndpoint() {
        // Implement the logic to get the endpoint
        return "Endpoint response";
    }


    public String getTest() {
        // Implement the logic to get the endpoint
        return "Endpoint response test";
    }
}