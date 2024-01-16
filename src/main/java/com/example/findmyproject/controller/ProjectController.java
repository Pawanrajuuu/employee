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
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    private ProjectJpaService projectJpaService;

    @GetMapping
    public List<Project> getAllProjects() {
        return projectJpaService.getAllProjects();
    }

    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return projectJpaService.createProject(project);
    }

    @GetMapping("/{projectId}")
    public Project getProjectById(@PathVariable int projectId) {
        return projectJpaService.getProjectById(projectId);
    }

    @PutMapping("/{projectId}")
    public Project updateProject(@PathVariable int projectId, @RequestBody Project project) {
        return projectJpaService.updateProject(projectId, project);
    }

    @DeleteMapping("/{projectId}")
    public void deleteProject(@PathVariable int projectId) {
        projectJpaService.deleteProject(projectId);
    }

    @GetMapping("/{projectId}/researchers")
    public List<Researcher> getProjectResearchers(@PathVariable int projectId) {
        return projectJpaService.getProjectResearchers(projectId);
    }

    

}
