package ctu.cit.se.generalinformation.daos;


import ctu.cit.se.generalinformation.dtos.others.CommandResDTO;
import ctu.cit.se.generalinformation.dtos.projects.CreateProjectReqDTO;
import ctu.cit.se.generalinformation.dtos.projects.RetrieveProjectResDTO;
import ctu.cit.se.generalinformation.dtos.projects.UpdateProjectReqDTO;

import java.util.List;
import java.util.UUID;

public interface IProjectDAO {
    CommandResDTO create(CreateProjectReqDTO createProjectReqDTO);
    CommandResDTO update(UpdateProjectReqDTO updateProjectReqDTO);
    List<RetrieveProjectResDTO> list();
    RetrieveProjectResDTO retrieve(UUID projectId);
    void delete(UUID projectId);
    void initData(List<CreateProjectReqDTO> createProjectReqDTOS);
}
