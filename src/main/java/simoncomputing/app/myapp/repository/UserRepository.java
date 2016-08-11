package simoncomputing.app.myapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import simoncomputing.app.myapp.model.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	public User findOneByUserId( Long userId);
}