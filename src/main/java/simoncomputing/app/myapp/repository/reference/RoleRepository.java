package simoncomputing.app.myapp.repository.reference;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import simoncomputing.app.myapp.model.entity.reference.RefRole;

@Repository
public interface RoleRepository extends JpaRepository<RefRole, String>{

}