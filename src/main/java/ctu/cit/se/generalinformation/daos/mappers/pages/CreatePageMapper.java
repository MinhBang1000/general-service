package ctu.cit.se.generalinformation.daos.mappers.pages;

import ctu.cit.se.generalinformation.daos.mappers.IMapper;
import ctu.cit.se.generalinformation.dtos.pages.CreatePageReqDTO;
import ctu.cit.se.generalinformation.entities.Page;
import ctu.cit.se.generalinformation.exceptions.messages.CustomExceptionMessage;
import ctu.cit.se.generalinformation.repositories.IProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreatePageMapper implements IMapper<CreatePageReqDTO, Page> {
    @Autowired
    private IProjectRepository projectRepository;
    @Override
    public Page convert(CreatePageReqDTO source) {
        var project = projectRepository.findById(UUID.fromString(source.getProjectId())).orElseThrow(
                () -> new IllegalArgumentException(CustomExceptionMessage.PROJECT_NOT_FOUND)
        );
        return Page.builder()
                .name(source.getName())
                .headerTitle(source.getHeaderTitle())
                .headerBody(source.getHeaderBody())
                .project(project)
                .build();
    }
}
