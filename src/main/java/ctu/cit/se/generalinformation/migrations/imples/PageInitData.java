package ctu.cit.se.generalinformation.migrations.imples;

import ctu.cit.se.generalinformation.dtos.pages.CreatePageReqDTO;
import ctu.cit.se.generalinformation.migrations.IBaseInitData;
import ctu.cit.se.generalinformation.repositories.IProjectRepository;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Component
public class PageInitData implements IBaseInitData<CreatePageReqDTO> {
    @Autowired
    private IProjectRepository projectRepository;
    private String defaultCode = "U2FsdGVkX1/CWjVqRRnlyitZ9vISoCgx/rEeZbKMiLQ=";
    private String projectName = "dms_project";
    public String getProjectCode() {
        return defaultCode + "_" + projectName;
    }
    @Override
    public List<CreatePageReqDTO> getInitData() {
        var projects = projectRepository.findByCode(getProjectCode());
        if (projects.isEmpty()) {
            return List.of();
        }
        var projectId = projects.get(0).getId();
        return List.of(
                CreatePageReqDTO.builder()
                        .name("Trang chủ")
                        .code(defaultCode + "_" + "dms_page_homepage")
                        .projectId(projectId.toString())
                        .headerTitle("HỆ THỐNG GIÁM SÁT ĐỘ MẶN VÀ LỊCH ĐÓNG MỞ CỐNG / ĐẬP")
                        .headerBody("Hệ thống hỗ trợ quản lý các thông tin về lịch đóng / mở của hệ thống cống / đập và cảm biến trên địa bàn tỉnh Hậu Giang")
                        .build(),
                CreatePageReqDTO.builder()
                        .name("Quản lý người dùng")
                        .code(defaultCode + "_" + "dms_page_user_management")
                        .projectId(projectId.toString())
                        .headerTitle("QUẢN LÝ TÀI KHOẢN NGƯỜI DÙNG")
                        .headerBody("Hỗ trợ quản lý thông tin tài khoản người dùng, cung cấp tài khoản")
                        .build(),
                CreatePageReqDTO.builder()
                        .name("Quản lý vai trò")
                        .code(defaultCode + "_" + "dms_page_role_management")
                        .projectId(projectId.toString())
                        .headerTitle("QUẢN LÝ VAI TRÒ CỦA NGƯỜI DÙNG")
                        .headerBody("Hỗ trợ quản lý thông tin về vai trò và quyền hạn của người dung bên trong hệ thống")
                        .build(),
                CreatePageReqDTO.builder()
                        .name("Quản lý cống / đập")
                        .code(defaultCode + "_" + "dms_page_dam_management")
                        .projectId(projectId.toString())
                        .headerTitle("QUẢN LÝ CỐNG / ĐẬP")
                        .headerBody("Hỗ trợ quản lý các thông tin chung về hệ thống cống / đập trực thuộc tỉnh Hậu Giang")
                        .build(),
                CreatePageReqDTO.builder()
                        .name("Quản lý sông / kênh / rạch")
                        .code(defaultCode + "_" + "dms_page_river_management")
                        .projectId(projectId.toString())
                        .headerTitle("QUẢN LÝ SÔNG / KÊNH / RẠCH")
                        .headerBody("Hỗ trợ quản lý thông tin về hệ thống sông / kênh / rạch trên địa bàn tỉnh Hậu Giang")
                        .build(),
                CreatePageReqDTO.builder()
                        .name("Quản lý trạm cảm biến")
                        .code(defaultCode + "_" + "dms_page_station_management")
                        .projectId(projectId.toString())
                        .headerTitle("QUẢN LÝ TRẠM CẢM BIẾN")
                        .headerBody("Hỗ trợ quản lý thông tin các trạm cảm biến tại các vị trí trực thuộc tỉnh Hậu Giang")
                        .build(),
                CreatePageReqDTO.builder()
                        .name("Quản lý loại cống / đập")
                        .code(defaultCode + "_" + "dms_page_dam_type_management")
                        .projectId(projectId.toString())
                        .headerTitle("QUẢN LÝ LOẠI CỐNG / ĐẬP")
                        .headerBody("Hỗ trợ quản lý thông tin về các loại hình cống / đập đang được sử dụng tại tỉnh Hậu Giang")
                        .build(),
                CreatePageReqDTO.builder()
                        .name("Thông tin chi tiết cống / đập")
                        .code(defaultCode + "_" + "dms_page_dam_detail")
                        .projectId(projectId.toString())
                        .headerTitle("THÔNG TIN CỐNG / ĐẬP CHI TIẾT")
                        .headerBody("Hỗ trợ theo dõi và thao tác các thông tin cống / đập chi tiết")
                        .build()
        );
    }
}
