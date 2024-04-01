package ctu.cit.se.generalinformation.daos.imples;

import ctu.cit.se.generalinformation.daos.IPageDAO;
import ctu.cit.se.generalinformation.daos.IProjectDAO;
import ctu.cit.se.generalinformation.daos.mappers.IMapper;
import ctu.cit.se.generalinformation.dtos.others.CommandResDTO;
import ctu.cit.se.generalinformation.dtos.pages.CreatePageReqDTO;
import ctu.cit.se.generalinformation.dtos.pages.RetrievePageResDTO;
import ctu.cit.se.generalinformation.dtos.pages.UpdatePageReqDTO;
import ctu.cit.se.generalinformation.dtos.projects.CreateProjectReqDTO;
import ctu.cit.se.generalinformation.dtos.projects.RetrieveProjectResDTO;
import ctu.cit.se.generalinformation.dtos.projects.UpdateProjectReqDTO;
import ctu.cit.se.generalinformation.entities.Project;
import ctu.cit.se.generalinformation.exceptions.messages.CustomExceptionMessage;
import ctu.cit.se.generalinformation.repositories.IPageRepository;
import ctu.cit.se.generalinformation.repositories.IProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ProjectDAO implements IProjectDAO {
    @Autowired
    private IProjectRepository projectRepository;
    @Autowired
    private IMapper<CreateProjectReqDTO, Project> createMapper;
    @Autowired
    private IMapper<UpdateProjectReqDTO, Project> updateMapper;
    @Autowired
    private IMapper<Project, RetrieveProjectResDTO> retrieveMapper;
    @Override
    public CommandResDTO create(CreateProjectReqDTO createProjectReqDTO) {
        return CommandResDTO.builder()
                .id(projectRepository.save(createMapper.convert(createProjectReqDTO)).getId().toString())
                .build();
    }

    @Override
    public CommandResDTO update(UpdateProjectReqDTO updateProjectReqDTO) {
        return CommandResDTO.builder()
                .id(
                        projectRepository.save(
                                updateMapper.convert(updateProjectReqDTO)
                        ).getId().toString()
                )
                .build();
    }

    @Override
    public List<RetrieveProjectResDTO> list() {
        return projectRepository.findAll().stream().map(
                project -> retrieveMapper.convert(project)
        ).collect(Collectors.toList());
    }

    @Override
    public RetrieveProjectResDTO retrieve(UUID projectId) {
        var project = projectRepository.findById(projectId).orElseThrow(() -> new IllegalArgumentException(CustomExceptionMessage.PROJECT_NOT_FOUND));
        return retrieveMapper.convert(project);
    }

    @Override
    public void delete(UUID projectId) {
        var project = projectRepository.findById(projectId).orElseThrow(()->new IllegalArgumentException(CustomExceptionMessage.PROJECT_NOT_FOUND));
        projectRepository.delete(project);
    }
}
