package ctu.cit.se.generalinformation.dtos.pages;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePageReqDTO {
    @JsonProperty("pageId")
    private String id;
    @JsonProperty("pageName")
    private String name;
    @JsonProperty("pageHeaderTitle")
    private String headerTitle;
    @JsonProperty("pageHeaderBody")
    private String headerBody;
}
