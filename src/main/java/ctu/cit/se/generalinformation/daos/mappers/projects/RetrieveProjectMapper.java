package ctu.cit.se.generalinformation.daos.mappers.projects;

import ctu.cit.se.generalinformation.daos.mappers.IMapper;
import ctu.cit.se.generalinformation.dtos.pages.RetrievePageResDTO;
import ctu.cit.se.generalinformation.dtos.projects.RetrieveProjectResDTO;
import ctu.cit.se.generalinformation.entities.Page;
import ctu.cit.se.generalinformation.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class RetrieveProjectMapper implements IMapper<Project, RetrieveProjectResDTO> {
    @Autowired
    private IMapper<Page, RetrievePageResDTO> retrievePageMapper;
    @Override
    public RetrieveProjectResDTO convert(Project source) {
        return RetrieveProjectResDTO.builder()
                .id(source.getId().toString())
                .name(source.getName())
                .description(source.getDescription())
                .footerLeft(source.getFooterLeft())
                .footerLeftLink(source.getFooterLeftLink())
                .footerRight(source.getFooterRight())
                .footerRightLink(source.getFooterRightLink())
                .pages(source.getPages().stream().map(page -> {
                    return retrievePageMapper.convert(page);
                }).collect(Collectors.toList()))
                .build();
    }
}
