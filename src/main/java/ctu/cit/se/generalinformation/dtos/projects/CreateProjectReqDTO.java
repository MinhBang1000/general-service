package ctu.cit.se.generalinformation.dtos.projects;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateProjectReqDTO {
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
