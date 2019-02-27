package com.example.web;

import com.example.entities.CandidatEntity;
import com.example.entities.CandidatRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/resource")
public class CandidatController implements ErrorController {

    @Autowired
    private CandidatRepository candidatRepository;
    @GetMapping("/candidat")
    public Iterable<CandidatEntity> getAllCandidat(){

        Iterable<CandidatEntity> candidatEntities=candidatRepository.findAll();
        return candidatEntities;
    }

    private static final String PATH = "/error";

    @RequestMapping(value = PATH)
    public String error() {
        return "Error handling";
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
