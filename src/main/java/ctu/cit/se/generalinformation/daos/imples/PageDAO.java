package ctu.cit.se.generalinformation.daos.imples;

import ctu.cit.se.generalinformation.daos.IPageDAO;
import ctu.cit.se.generalinformation.dtos.others.CommandResDTO;
import ctu.cit.se.generalinformation.dtos.pages.CreatePageReqDTO;
import ctu.cit.se.generalinformation.dtos.pages.RetrievePageResDTO;
import ctu.cit.se.generalinformation.dtos.pages.UpdatePageReqDTO;
import ctu.cit.se.generalinformation.repositories.IPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PageDAO implements IPageDAO {
    @Autowired
    private IPageRepository pageRepository;

    @Override
    public CommandResDTO create(CreatePageReqDTO createPageReqDTO) {
        return null;
    }

    @Override
    public CommandResDTO update(UpdatePageReqDTO updatePageReqDTO) {
        return null;
    }

    @Override
    public List<RetrievePageResDTO> list() {
        return null;
    }

    @Override
    public RetrievePageResDTO retrieve(UUID pageId) {
        return null;
    }

    @Override
    public void delete(UUID pageId) {

    }
}
