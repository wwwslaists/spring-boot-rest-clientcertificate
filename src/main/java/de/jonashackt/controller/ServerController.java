package de.jonashackt.controller;

import de.jonashackt.ExampleClient;
import org.apache.commons.fileupload.MultipartStream;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1")
public class ServerController {

    public static final String RESPONSE = "Hello Rest-User!";

    ExampleClient   exampleClient;

    @RequestMapping(path="/hello", method=RequestMethod.GET)
    public String helloWorld() {
        System.out.println("Rocking REST!");
    	return exampleClient.getEndpoint();
    }

    @RequestMapping(path="/xml", method=RequestMethod.GET)
    public String helloWorldPost() {

    	return "<xml><message>"+RESPONSE+"</message></xml>";
    }

}
