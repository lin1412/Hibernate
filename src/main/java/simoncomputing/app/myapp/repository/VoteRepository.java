package simoncomputing.app.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import simoncomputing.app.myapp.model.entity.Vote;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long>{

}