package ctu.cit.se.generalinformation.repositories;

import ctu.cit.se.generalinformation.entities.Header;
import ctu.cit.se.generalinformation.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface IHeaderRepository extends JpaRepository<Header, UUID> {
    
}
