/*
 * You can use the following import statements
 *
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.web.bind.annotation.*;
 * 
 * import java.util.ArrayList;
 * import java.util.List;
 * 
 */

// Write your code here
package com.example.findmyproject.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.ArrayList;

@RestController
@RequestMapping("/researchers")
public class ResearcherController {

    @Autowired
    private ResearcherJpaService researcherJpaService;

    @GetMapping
    public List<Researcher> getAllResearchers() {
        return researcherJpaService.getAllResearchers();
    }

    @PostMapping
    public Researcher createResearcher(@RequestBody Researcher researcher) {
        return researcherJpaService.createResearcher(researcher);
    }

    @GetMapping("/{researcherId}")
    public Researcher getResearcherById(@PathVariable int researcherId) {
        return researcherJpaService.getResearcherById(researcherId);
    }

    @PutMapping("/{researcherId}")
    public Researcher updateResearcher(@PathVariable int researcherId, @RequestBody Researcher researcher) {
        return researcherJpaService.updateResearcher(researcherId, researcher);
    }

    @DeleteMapping("/{researcherId}")
    public void deleteResearcher(@PathVariable int researcherId) {
        researcherJpaService.deleteResearcher(researcherId);
    }

    @GetMapping("/{researcherId}/projects")
    public List<Project> getResearcherProjects(@PathVariable int researcherId) {
        return researcherJpaService.getResearcherProjects(researcherId);
    }

}
