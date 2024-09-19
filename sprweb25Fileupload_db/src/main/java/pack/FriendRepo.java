package pack;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FriendRepo extends JpaRepository<Friend, Integer> {

	@Query("SELECT max(f.bunho) FROM Friend f")
	Integer findLastBunho();
//	 Friend findTopByOrderByBunhoDesc();
}
