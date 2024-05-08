package ctu.cit.se.generalinformation.repositories;

import ctu.cit.se.generalinformation.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IProjectRepository extends JpaRepository<Project, UUID> {
    List<Project> findByCode(String code);
}
