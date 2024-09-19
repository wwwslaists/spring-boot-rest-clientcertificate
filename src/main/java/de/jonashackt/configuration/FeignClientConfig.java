
        package de.jonashackt.configuration;

import feign.Client;
import feign.httpclient.ApacheHttpClient;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.SSLContextBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.net.ssl.SSLContext;
import java.io.InputStream;
import java.security.KeyStore;

@Configuration
public class FeignClientConfig {

    @Bean
    public Client feignClient() throws Exception {
        try (InputStream keyStoreStream = getClass().getClassLoader().getResourceAsStream("examplecert.pfx")) {
            if (keyStoreStream == null) {
                throw new IllegalArgumentException("Keystore file not found");
            }

            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            keyStore.load(keyStoreStream, "allpassword".toCharArray());

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