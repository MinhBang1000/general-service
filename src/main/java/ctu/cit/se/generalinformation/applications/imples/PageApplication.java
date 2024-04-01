package ctu.cit.se.generalinformation.applications.imples;

import ctu.cit.se.generalinformation.applications.IPageApplication;
import ctu.cit.se.generalinformation.daos.IPageDAO;
import ctu.cit.se.generalinformation.dtos.others.CommandResDTO;
import ctu.cit.se.generalinformation.dtos.pages.CreatePageReqDTO;
import ctu.cit.se.generalinformation.dtos.pages.RetrievePageResDTO;
import ctu.cit.se.generalinformation.dtos.pages.UpdatePageReqDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class PageApplication implements IPageApplication {
    @Autowired
    private IPageDAO pageDAO;
    @Override
    public CommandResDTO create(CreatePageReqDTO createPageReqDTO) {
        return pageDAO.create(createPageReqDTO);
    }

    @Override
    public CommandResDTO update(UpdatePageReqDTO updatePageReqDTO) {
        return pageDAO.update(updatePageReqDTO);
    }

    @Override
    public List<RetrievePageResDTO> list() {
        return pageDAO.list();
    }

    @Override
    public RetrievePageResDTO retrieve(UUID pageId) {
        return pageDAO.retrieve(pageId);
    }

    @Override
    public void delete(UUID pageId) {
        pageDAO.delete(pageId);
    }
}
