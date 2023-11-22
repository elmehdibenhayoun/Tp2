package ma.mundiapolis.tp2.repositories;

import ma.mundiapolis.tp2.entities.Medecin;
import ma.mundiapolis.tp2.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MedecinRepo extends JpaRepository<Medecin, Long> {



}