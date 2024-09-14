package de.jonashackt.configuration;

import feign.Client;
import feign.httpclient.ApacheHttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.net.ssl.SSLContext;
import java.io.File;
import java.security.KeyStore;

@Configuration
public class FeignClientConfig {

    @Bean
    public Client feignClient() throws Exception {
        try {
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            keyStore.load(new File(getClass().getClassLoader().getResource("examplecert.pfx").toURI()).toURI().toURL().openStream(), "allpassword".toCharArray());
            SSLContext sslContext = SSLContextBuilder.create()
                    .loadKeyMaterial(keyStore, "allpassword".toCharArray())
                    .build();

            CloseableHttpClient httpClient = HttpClients.custom()
                    .setSSLContext(sslContext)
                    .build();

            return new ApacheHttpClient(httpClient);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}