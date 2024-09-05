package com.example.onetomany.Service;


import com.example.onetomany.Model.Kommune;
import com.example.onetomany.Repository.KommuneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class ApiServiceGetKommunerImpl implements ApiServiceGetKommuner {

    private final RestTemplate restTemplate;

    @Autowired
    public ApiServiceGetKommunerImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Autowired
    KommuneRepository kommuneRepository;

    String kommuneUrl = "https://api.dataforsyningen.dk/kommuner";

    private void saveKommuner(List<Kommune> kommuner) {
        kommuner.forEach(kommune -> kommuneRepository.save(kommune));
    }

    @Override
    public List<Kommune> getKommuner() {
        List<Kommune> lst = new ArrayList<>();
        ResponseEntity<List<Kommune>> kommuneResponse =
                restTemplate.exchange(kommuneUrl,
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<Kommune>>() {
                        });
        List<Kommune> kommuner = kommuneResponse.getBody();
        saveKommuner(kommuner);
        return kommuner;
    }
}
