package ma.mundiapolis.tp2.repositories;

import ma.mundiapolis.tp2.entities.Consultation;
import ma.mundiapolis.tp2.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConsultationRepo extends JpaRepository<Consultation, Long> {



}