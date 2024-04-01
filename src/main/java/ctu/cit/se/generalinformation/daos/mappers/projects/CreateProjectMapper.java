package ctu.cit.se.generalinformation.daos.mappers.projects;

import ctu.cit.se.generalinformation.daos.mappers.IMapper;
import ctu.cit.se.generalinformation.dtos.pages.CreatePageReqDTO;
import ctu.cit.se.generalinformation.dtos.projects.CreateProjectReqDTO;
import ctu.cit.se.generalinformation.entities.Page;
import ctu.cit.se.generalinformation.entities.Project;
import ctu.cit.se.generalinformation.exceptions.messages.CustomExceptionMessage;
import ctu.cit.se.generalinformation.repositories.IProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateProjectMapper implements IMapper<CreateProjectReqDTO, Project> {
    @Override
    public Project convert(CreateProjectReqDTO source) {
        return Project.builder()
                .name(source.getName())
                .description(source.getDescription())
                .footerLeft(source.getFooterLeft())
                .footerLeftLink(source.getFooterLeftLink())
                .footerRight(source.getFooterRight())
                .footerRightLink(source.getFooterRightLink())
                .build();
    }
}
