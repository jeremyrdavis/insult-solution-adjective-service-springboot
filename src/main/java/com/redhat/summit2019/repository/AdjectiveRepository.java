package com.redhat.summit2019.repository;

import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

import com.redhat.summit2019.model.Adjective;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Component("adjectiveStore")
public class AdjectiveRepository {

    private List<Adjective> adjectives = new ArrayList<>();

    public AdjectiveRepository(){
        try {
            Resource resource = new ClassPathResource("adjectives.txt");
            InputStream is = resource.getInputStream();
            if (is != null) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                reader.lines()
                        .forEach(adj -> adjectives.add(new Adjective(adj.trim())));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Adjective getRandomAdjective(){
        return adjectives.get(new Random().nextInt(adjectives.size()));
    }


}