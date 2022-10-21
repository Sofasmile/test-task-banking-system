package com.example.rickandmorty.service;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;
import java.io.IOException;

@Service
public class RickAndMortyApiService {
    public void sendGet(String url) {
        try(CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet request = new HttpGet(url);
            try (CloseableHttpResponse response = httpClient.execute(request);) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    String result = EntityUtils.toString(entity);
                    System.out.println(result); // TODO replace with parsing String to dto
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Something went wrong", e);
        }
    }
}
