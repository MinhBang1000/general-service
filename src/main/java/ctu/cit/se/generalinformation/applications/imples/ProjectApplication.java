package ctu.cit.se.generalinformation.applications.imples;

import ctu.cit.se.generalinformation.applications.IProjectApplication;
import ctu.cit.se.generalinformation.daos.IProjectDAO;
import ctu.cit.se.generalinformation.dtos.others.CommandResDTO;
import ctu.cit.se.generalinformation.dtos.projects.CreateProjectReqDTO;
import ctu.cit.se.generalinformation.dtos.projects.RetrieveProjectResDTO;
import ctu.cit.se.generalinformation.dtos.projects.UpdateProjectReqDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class ProjectApplication implements IProjectApplication {
    @Autowired
    private IProjectDAO projectDAO;
    @Override
    public CommandResDTO create(CreateProjectReqDTO createProjectReqDTO) {
        return projectDAO.create(createProjectReqDTO);
    }

    @Override
    public CommandResDTO update(UpdateProjectReqDTO updateProjectReqDTO) {
        return projectDAO.update(updateProjectReqDTO);
    }

    @Override
    public List<RetrieveProjectResDTO> list() {
        return projectDAO.list();
    }

    @Override
    public RetrieveProjectResDTO retrieve(UUID projectId) {
        return projectDAO.retrieve(projectId);
    }

    @Override
    public void delete(UUID projectId) {
        projectDAO.delete(projectId);
    }
}
