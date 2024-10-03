package iesvdm.org.fighthub_service.repository;

import iesvdm.org.fighthub_service.schema.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
}
