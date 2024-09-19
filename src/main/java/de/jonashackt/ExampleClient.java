package de.jonashackt;
import de.jonashackt.configuration.FeignClientConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "exampleClient", url = "https://localhost:8443/api/v1/xml", configuration = FeignClientConfig.class)
public interface ExampleClient {

    @GetMapping("")
    String getEndpoint();
}