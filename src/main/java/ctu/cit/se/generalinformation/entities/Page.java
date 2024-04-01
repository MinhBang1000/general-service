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
@Table(name = "pages")
public class Page {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "page_name")
    private String name;
    @ManyToOne
    @JoinColumn(name = "page_project_id")
    private Project project;
    @OneToMany(mappedBy = "headerPage", cascade = CascadeType.ALL)
    private List<Header> headers = new ArrayList<>();
    @OneToMany(mappedBy = "footerPage", cascade = CascadeType.ALL)
    private List<Footer> footers = new ArrayList<>();
}
