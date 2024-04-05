package ctu.cit.se.generalinformation.daos.mappers.projects;

import ctu.cit.se.generalinformation.daos.mappers.IMapper;
import ctu.cit.se.generalinformation.dtos.pages.UpdatePageReqDTO;
import ctu.cit.se.generalinformation.dtos.projects.UpdateProjectReqDTO;
import ctu.cit.se.generalinformation.entities.Page;
import ctu.cit.se.generalinformation.entities.Project;
import ctu.cit.se.generalinformation.exceptions.messages.CustomExceptionMessage;
import ctu.cit.se.generalinformation.repositories.IPageRepository;
import ctu.cit.se.generalinformation.repositories.IProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class UpdateProjectMapper implements IMapper<UpdateProjectReqDTO, Project> {
    @Autowired
    private IProjectRepository projectRepository;
    @Override
    public Project convert(UpdateProjectReqDTO source) {
        var project = projectRepository.findById(UUID.fromString(source.getId())).orElseThrow(()->new IllegalArgumentException(CustomExceptionMessage.PROJECT_NOT_FOUND));
        return Project.builder()
                .id(project.getId())
                .name(Objects.isNull(source.getName()) ? project.getName() : source.getName())
                .code(Objects.isNull(source.getCode()) ? project.getCode() : source.getCode())
                .footerLeft(Objects.isNull(source.getFooterLeft()) ? project.getFooterLeft() : source.getFooterLeft())
                .footerLeftLink(Objects.isNull(source.getFooterLeftLink()) ? project.getFooterLeftLink() : source.getFooterLeftLink())
                .footerRight(Objects.isNull(source.getFooterRight()) ? project.getFooterRight() : source.getFooterRight())
                .footerRightLink(Objects.isNull(source.getFooterRightLink()) ? project.getFooterRightLink() : source.getFooterRightLink())
                .build();
    }
}
