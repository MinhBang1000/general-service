package ctu.cit.se.generalinformation.daos.mappers.pages;

import ctu.cit.se.generalinformation.daos.mappers.IMapper;
import ctu.cit.se.generalinformation.dtos.pages.UpdatePageReqDTO;
import ctu.cit.se.generalinformation.entities.Page;
import ctu.cit.se.generalinformation.exceptions.messages.CustomExceptionMessage;
import ctu.cit.se.generalinformation.repositories.IPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.UUID;

@Component
public class UpdatePageMapper implements IMapper<UpdatePageReqDTO, Page> {
    @Autowired
    private IPageRepository pageRepository;
    @Override
    public Page convert(UpdatePageReqDTO source) {
        var page = pageRepository.findById(UUID.fromString(source.getId())).orElseThrow(() -> new IllegalArgumentException(CustomExceptionMessage.PAGE_NOT_FOUND));
        return Page.builder()
                .id(page.getId())
                .name(Objects.isNull(source.getName()) ? page.getName() : source.getName())
                .project(page.getProject())
                .headerTitle(Objects.isNull(source.getHeaderTitle()) ? page.getHeaderTitle() : source.getHeaderTitle())
                .headerBody(Objects.isNull(source.getHeaderBody()) ? page.getHeaderBody() : source.getHeaderBody())
                .build();
    }
}
