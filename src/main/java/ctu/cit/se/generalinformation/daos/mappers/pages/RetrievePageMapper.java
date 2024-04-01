package ctu.cit.se.generalinformation.daos.mappers.pages;

import ctu.cit.se.generalinformation.daos.mappers.IMapper;
import ctu.cit.se.generalinformation.dtos.pages.RetrievePageResDTO;
import ctu.cit.se.generalinformation.entities.Page;
import org.springframework.stereotype.Component;

@Component
public class RetrievePageMapper implements IMapper<Page, RetrievePageResDTO> {
    @Override
    public RetrievePageResDTO convert(Page source) {
        return RetrievePageResDTO.builder()
                .id(source.getId().toString())
                .name(source.getName())
                .headerTitle(source.getHeaderTitle())
                .headerBody(source.getHeaderBody())
                .projectId(source.getProject().getId().toString())
                .build();
    }
}
