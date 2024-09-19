package de.jonashackt.controller;

import de.jonashackt.ExampleClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;


@RestController
@RequestMapping("/api/v1")
public class ServerController {

   // public static final String RESPONSE = "Hello Rest-User!";


    ExampleClient exampleClient;
    // Return http headers and body in json
    @RequestMapping(path="/json", method=RequestMethod.GET, produces = "application/json")
    public String helloWorld() {
        System.out.println("Rocking REST!");
        HashMap<String, String> response = new HashMap<>();
        response.put("body", "Hello World!");
        response.put("date", "2021-09-01");
        response.put("time", String.valueOf(System.currentTimeMillis()));
        return String.valueOf(response);

    }
    // return http heders and body un xml
    @RequestMapping(path="/xml", method=RequestMethod.GET, produces = "application/xml")
    public String helloWorldPost() {
        return "<xml><body>Hello World!</body></xml>";
    }

}
