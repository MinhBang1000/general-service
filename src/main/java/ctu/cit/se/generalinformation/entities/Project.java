package ctu.cit.se.generalinformation.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "project_name")
    private String name;
    @Column(name = "project_code")
    private String code;
    @Column(name = "project_footer_left")
    private String footerLeft;
    @Column(name = "project_footer_left_link")
    private String footerLeftLink;
    @Column(name = "project_footer_right")
    private String footerRight;
    @Column(name = "project_footer_right_link")
    private String footerRightLink;
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Page> pages = new ArrayList<>();
}
