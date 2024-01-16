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
public class ProjectJpaService {

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public Project createProject(Project project) {
        return projectRepository.save(project);
    }

    public Project getProjectById(int projectId) {
        return projectRepository.findById(projectId).orElse(null);
    }

    public Project updateProject(int projectId, Project updatedProject) {
        Project existingProject = projectRepository.findById(projectId).orElse(null);
        if (existingProject != null) {
            existingProject.setProjectName(updatedProject.getProjectName());
            existingProject.setBudget(updatedProject.getBudget());
            existingProject.setResearchers(updatedProject.getResearchers());
            return projectRepository.save(existingProject);
        }
        return null;
    }

    public void deleteProject(int projectId) {
        projectRepository.deleteById(projectId);
    }

    public List<Researcher> getProjectResearchers(int projectId) {
        Project project = projectRepository.findById(projectId).orElse(null);
        return (project != null) ? project.getResearchers() : null;
    }


}
