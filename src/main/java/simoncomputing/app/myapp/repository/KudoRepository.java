package simoncomputing.app.myapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import simoncomputing.app.myapp.model.entity.Kudo;

@Repository
public interface KudoRepository extends JpaRepository<Kudo, Long>{

	public Kudo findOneByKudoId( Long kudoId);
	
	@Query( "select k from Kudo k join k.kudee user where user.userId = ?1 order by k.entryDateTime")
	public List<Kudo> findAllKudosForUser( Long userId);
}