package ma.mundiapolis.tp2.repositories;

import ma.mundiapolis.tp2.entities.RendezVous;
import ma.mundiapolis.tp2.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepo extends JpaRepository<Role, Long> {
    Role findByRoleName(String roleName);
}
