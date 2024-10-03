package iesvdm.org.fighthub_service.repository;

import iesvdm.org.fighthub_service.schema.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
