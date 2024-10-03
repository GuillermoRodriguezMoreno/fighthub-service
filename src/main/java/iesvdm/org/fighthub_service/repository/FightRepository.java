package iesvdm.org.fighthub_service.repository;

import iesvdm.org.fighthub_service.schema.Fight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FightRepository extends JpaRepository<Fight, Long> {
}
