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
@Table(name = "footers")
public class Footer {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "footer_left")
    private String left;
    @Column(name = "footer_right")
    private String right;
    @ManyToOne
    @JoinColumn(name = "footer_page_id")
    private Page footerPage;
}
