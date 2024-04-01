package ctu.cit.se.generalinformation.repositories;

import ctu.cit.se.generalinformation.entities.Footer;
import ctu.cit.se.generalinformation.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IFooterrRepository extends JpaRepository<Footer, UUID> {
}
