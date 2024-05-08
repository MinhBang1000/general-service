package ctu.cit.se.generalinformation.migrations.imples;

import ctu.cit.se.generalinformation.dtos.projects.CreateProjectReqDTO;
import ctu.cit.se.generalinformation.migrations.IBaseInitData;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class ProjectInitData implements IBaseInitData<CreateProjectReqDTO> {
    private String defaultCode = "U2FsdGVkX1/CWjVqRRnlyitZ9vISoCgx/rEeZbKMiLQ=_dms_project";

    @Override
    public List<CreateProjectReqDTO> getInitData() {
        return List.of(
                CreateProjectReqDTO.builder()
                        .code(defaultCode)
                        .name("DMS System")
                        .footerLeft("Được phát hành năm 2024")
                        .footerLeftLink("www.google.com")
                        .footerRight("Khoa Kỹ thuật phần mềm (SE), Trường CNTT&TT (CIT), Trường Đại học Cần Thơ")
                        .footerRightLink("www.google.com")
                        .build()
        );
    }
}
