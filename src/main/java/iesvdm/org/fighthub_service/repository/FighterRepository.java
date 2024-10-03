package iesvdm.org.fighthub_service.repository;


import iesvdm.org.fighthub_service.schema.Fighter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FighterRepository extends JpaRepository<Fighter, Long> {
}
