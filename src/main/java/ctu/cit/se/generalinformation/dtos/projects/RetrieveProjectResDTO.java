package ctu.cit.se.generalinformation.dtos.projects;

import com.fasterxml.jackson.annotation.JsonProperty;
import ctu.cit.se.generalinformation.dtos.pages.RetrievePageResDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RetrieveProjectResDTO {
    @JsonProperty("projectId")
    private String id;
    @JsonProperty("projectName")
    private String name;
    @JsonProperty("projectDescription")
    private String description;
    @JsonProperty("projectFooterLeft")
    private String footerLeft;
    @JsonProperty("projectFooterLeftLink")
    private String footerLeftLink;
    @JsonProperty("projectFooterRight")
    private String footerRight;
    @JsonProperty("projectFooterRightLink")
    private String footerRightLink;
    @JsonProperty("projectPages")
    private List<RetrievePageResDTO> pages;
}
