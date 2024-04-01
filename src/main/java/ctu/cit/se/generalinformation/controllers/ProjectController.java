package ctu.cit.se.generalinformation.controllers;

import ctu.cit.se.generalinformation.applications.IProjectApplication;
import ctu.cit.se.generalinformation.dtos.others.CommandResDTO;
import ctu.cit.se.generalinformation.dtos.projects.CreateProjectReqDTO;
import ctu.cit.se.generalinformation.dtos.projects.RetrieveProjectResDTO;
import ctu.cit.se.generalinformation.dtos.projects.UpdateProjectReqDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/projects")
public class ProjectController {
    @Autowired
    private IProjectApplication projectApplication;
    @GetMapping
    public ResponseEntity<List<RetrieveProjectResDTO>> list() {
        return new ResponseEntity<>(
                projectApplication.list(),
                HttpStatus.OK
        );
    }
    @PostMapping
    public ResponseEntity<CommandResDTO> create(@RequestBody CreateProjectReqDTO createProjectReqDTO) {
        return new ResponseEntity<>(
                projectApplication.create(createProjectReqDTO),
                HttpStatus.CREATED
        );
    }
    @GetMapping("/{projectId}")
    public ResponseEntity<RetrieveProjectResDTO> retrieve(@PathVariable String projectId) {
        return new ResponseEntity<>(
                projectApplication.retrieve(UUID.fromString(projectId)),
                HttpStatus.OK
        );
    }
    @PatchMapping
    public ResponseEntity<CommandResDTO> update(@RequestBody UpdateProjectReqDTO updateProjectReqDTO) {
        return new ResponseEntity<>(
                projectApplication.update(updateProjectReqDTO),
                HttpStatus.ACCEPTED
        );
    }
    @DeleteMapping("/{projectId}")
    public ResponseEntity<Void> delete(@PathVariable String projectId) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
