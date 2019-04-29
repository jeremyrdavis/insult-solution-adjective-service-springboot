package com.redhat.summit2019.service;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import com.redhat.summit2019.model.Adjective;
import com.redhat.summit2019.repository.AdjectiveRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Path("/adjective")
@Component
public class AdjectiveService {

    @Autowired
    private AdjectiveRepository adjectiveStore;
    
    @GET
    @Produces("application/json")
    public Adjective adjective() {
        return adjectiveStore.getRandomAdjective();
    }
}