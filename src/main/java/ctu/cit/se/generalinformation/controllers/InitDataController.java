package ctu.cit.se.generalinformation.controllers;

import ctu.cit.se.generalinformation.applications.IPageApplication;
import ctu.cit.se.generalinformation.daos.IPageDAO;
import ctu.cit.se.generalinformation.daos.IProjectDAO;
import ctu.cit.se.generalinformation.dtos.others.CommandResDTO;
import ctu.cit.se.generalinformation.dtos.pages.CreatePageReqDTO;
import ctu.cit.se.generalinformation.dtos.pages.RetrievePageResDTO;
import ctu.cit.se.generalinformation.dtos.pages.UpdatePageReqDTO;
import ctu.cit.se.generalinformation.dtos.projects.CreateProjectReqDTO;
import ctu.cit.se.generalinformation.migrations.IBaseInitData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/init-data")
public class InitDataController {
    @Autowired
    private IProjectDAO projectDAO;
    @Autowired
    private IPageDAO pageDAO;
    @Autowired
    private IBaseInitData<CreatePageReqDTO> pageInitData;
    @Autowired
    private IBaseInitData<CreateProjectReqDTO> projectInitData;

    @PostMapping()
    public ResponseEntity<Void> createInitData() {
        projectDAO.initData(projectInitData.getInitData());
        pageDAO.initData(pageInitData.getInitData());
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
