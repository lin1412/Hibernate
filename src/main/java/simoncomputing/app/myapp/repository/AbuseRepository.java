package simoncomputing.app.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import simoncomputing.app.myapp.model.entity.Abuse;

@Repository
public interface AbuseRepository extends JpaRepository<Abuse, Long>{

}