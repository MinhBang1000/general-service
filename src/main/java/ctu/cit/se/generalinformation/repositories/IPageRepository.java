package ctu.cit.se.generalinformation.repositories;

import ctu.cit.se.generalinformation.entities.Page;
import ctu.cit.se.generalinformation.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IPageRepository extends JpaRepository<Page, UUID> {
    List<Page> findByCode(String code);
}
