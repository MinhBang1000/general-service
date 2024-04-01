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
    @Column(name = "project_description")
    private String description;
    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    private List<Page> pages = new ArrayList<>();
}
