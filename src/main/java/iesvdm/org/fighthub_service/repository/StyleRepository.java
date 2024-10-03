package iesvdm.org.fighthub_service.repository;

import iesvdm.org.fighthub_service.schema.Style;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StyleRepository extends JpaRepository<Style, Long> {
}
