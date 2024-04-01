package ctu.cit.se.generalinformation.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "headers")
public class Header {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "header_title")
    private String name;
    @Column(name = "header_description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "header_page_id")
    private Page headerPage;
}
