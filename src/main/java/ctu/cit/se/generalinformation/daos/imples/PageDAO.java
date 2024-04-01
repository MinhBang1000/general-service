package ctu.cit.se.generalinformation.daos.imples;

import ctu.cit.se.generalinformation.daos.IPageDAO;
import ctu.cit.se.generalinformation.daos.mappers.IMapper;
import ctu.cit.se.generalinformation.dtos.others.CommandResDTO;
import ctu.cit.se.generalinformation.dtos.pages.CreatePageReqDTO;
import ctu.cit.se.generalinformation.dtos.pages.RetrievePageResDTO;
import ctu.cit.se.generalinformation.dtos.pages.UpdatePageReqDTO;
import ctu.cit.se.generalinformation.entities.Page;
import ctu.cit.se.generalinformation.exceptions.messages.CustomExceptionMessage;
import ctu.cit.se.generalinformation.repositories.IPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PageDAO implements IPageDAO {
    @Autowired
    private IPageRepository pageRepository;
    @Autowired
    private IMapper<CreatePageReqDTO, Page> createMapper;
    @Autowired
    private IMapper<UpdatePageReqDTO, Page> updateMapper;
    @Autowired
    private IMapper<Page, RetrievePageResDTO> retrieveMapper;

    @Override
    public CommandResDTO create(CreatePageReqDTO createPageReqDTO) {
        return CommandResDTO.builder()
                .id(
                        pageRepository.save(
                            createMapper.convert(createPageReqDTO)
                        ).getId().toString()
                )
                .build();
    }

    @Override
    public CommandResDTO update(UpdatePageReqDTO updatePageReqDTO) {
        return CommandResDTO.builder()
                .id(
                        pageRepository.save(
                                updateMapper.convert(updatePageReqDTO)
                        ).getId().toString()
                )
                .build();
    }

    @Override
    public List<RetrievePageResDTO> list() {
        return pageRepository.findAll().stream().map(
                page -> retrieveMapper.convert(page)
        ).collect(Collectors.toList());
    }

    @Override
    public RetrievePageResDTO retrieve(UUID pageId) {
        var page = pageRepository.findById(pageId).orElseThrow(()->new IllegalArgumentException(CustomExceptionMessage.PAGE_NOT_FOUND));
        return retrieveMapper.convert(page);
    }

    @Override
    public void delete(UUID pageId) {
        var page = pageRepository.findById(pageId).orElseThrow(()->new IllegalArgumentException(CustomExceptionMessage.PAGE_NOT_FOUND));
        pageRepository.delete(page);
    }
}
