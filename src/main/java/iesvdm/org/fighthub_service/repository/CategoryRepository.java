package iesvdm.org.fighthub_service.repository;

import iesvdm.org.fighthub_service.schema.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long>{
}
