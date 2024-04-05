package ctu.cit.se.generalinformation.dtos.projects;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateProjectReqDTO {
    @JsonProperty("projectId")
    private String id;
    @JsonProperty("projectName")
    private String name;
    @JsonProperty("projectCode")
    private String code;
    @JsonProperty("projectFooterLeft")
    private String footerLeft;
    @JsonProperty("projectFooterLeftLink")
    private String footerLeftLink;
    @JsonProperty("projectFooterRight")
    private String footerRight;
    @JsonProperty("projectFooterRightLink")
    private String footerRightLink;
}
