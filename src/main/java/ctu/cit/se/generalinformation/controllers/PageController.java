package ctu.cit.se.generalinformation.controllers;

import ctu.cit.se.generalinformation.applications.IPageApplication;
import ctu.cit.se.generalinformation.applications.IProjectApplication;
import ctu.cit.se.generalinformation.dtos.others.CommandResDTO;
import ctu.cit.se.generalinformation.dtos.pages.CreatePageReqDTO;
import ctu.cit.se.generalinformation.dtos.pages.RetrievePageResDTO;
import ctu.cit.se.generalinformation.dtos.pages.UpdatePageReqDTO;
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
@RequestMapping("/pages")
public class PageController {
    @Autowired
    private IPageApplication pageApplication;
    @GetMapping
    public ResponseEntity<List<RetrievePageResDTO>> list() {
        return new ResponseEntity<>(
                pageApplication.list(),
                HttpStatus.OK
        );
    }
    @PostMapping
    public ResponseEntity<CommandResDTO> create(@RequestBody CreatePageReqDTO createPageReqDTO) {
        return new ResponseEntity<>(
                pageApplication.create(createPageReqDTO),
                HttpStatus.CREATED
        );
    }
    @GetMapping("/{pageId}")
    public ResponseEntity<RetrievePageResDTO> retrieve(@PathVariable String pageId) {
        return new ResponseEntity<>(
                pageApplication.retrieve(UUID.fromString(pageId)),
                HttpStatus.OK
        );
    }
    @PatchMapping
    public ResponseEntity<CommandResDTO> update(@RequestBody UpdatePageReqDTO updatePageReqDTO) {
        return new ResponseEntity<>(
                pageApplication.update(updatePageReqDTO),
                HttpStatus.ACCEPTED
        );
    }
    @DeleteMapping("/{pageId}")
    public ResponseEntity<Void> delete(@PathVariable String pageId) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
