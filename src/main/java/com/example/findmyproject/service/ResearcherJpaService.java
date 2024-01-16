/*
 * You can use the following import statements
 *
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * 
 * import java.util.*;
 *
 */

// Write your code here
package com.example.findmyproject.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;

@Service
public class ResearcherJpaService {

    @Autowired
    private ResearcherRepository researcherRepository;

    public List<Researcher> getAllResearchers() {
        return researcherRepository.findAll();
    }

    public Researcher createResearcher(Researcher researcher) {
        return researcherRepository.save(researcher);
    }

    public Researcher getResearcherById(int researcherId) {
        return researcherRepository.findById(researcherId).orElse(null);
    }

    public Researcher updateResearcher(int researcherId, Researcher updatedResearcher) {
        Researcher existingResearcher = researcherRepository.findById(researcherId).orElse(null);
        if (existingResearcher != null) {
            existingResearcher.setResearcherName(updatedResearcher.getResearcherName());
            existingResearcher.setSpecialization(updatedResearcher.getSpecialization());
            existingResearcher.setProjects(updatedResearcher.getProjects());
            return researcherRepository.save(existingResearcher);
        }
        return null;
    }

    public void deleteResearcher(int researcherId) {
        researcherRepository.deleteById(researcherId);
    }

    public List<Project> getResearcherProjects(int researcherId) {
        Researcher researcher = researcherRepository.findById(researcherId).orElse(null);
        return (researcher != null) ? researcher.getProjects() : null;
    }

    
}
