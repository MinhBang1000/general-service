package ctu.cit.se.generalinformation.daos;


import ctu.cit.se.generalinformation.dtos.others.CommandResDTO;
import ctu.cit.se.generalinformation.dtos.pages.CreatePageReqDTO;
import ctu.cit.se.generalinformation.dtos.pages.RetrievePageResDTO;
import ctu.cit.se.generalinformation.dtos.pages.UpdatePageReqDTO;
import ctu.cit.se.generalinformation.dtos.projects.CreateProjectReqDTO;
import ctu.cit.se.generalinformation.dtos.projects.RetrieveProjectResDTO;
import ctu.cit.se.generalinformation.dtos.projects.UpdateProjectReqDTO;
import ctu.cit.se.generalinformation.entities.Page;

import java.util.List;
import java.util.UUID;

public interface IPageDAO {
    CommandResDTO create(CreatePageReqDTO createPageReqDTO);
    CommandResDTO update(UpdatePageReqDTO updatePageReqDTO);
    List<RetrievePageResDTO> list();
    RetrievePageResDTO retrieve(UUID pageId);
    void delete(UUID pageId);
    void initData(List<CreatePageReqDTO> createPageReqDTOS);
}
