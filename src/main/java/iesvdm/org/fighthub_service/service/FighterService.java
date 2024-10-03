package iesvdm.org.fighthub_service.service;

import iesvdm.org.fighthub_service.exception.EntityNotFoundException;
import iesvdm.org.fighthub_service.repository.FighterRepository;
import iesvdm.org.fighthub_service.schema.Fighter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FighterService {
    @Autowired
    private FighterRepository fighterRepository;

    public List<Fighter> getFighters() {
        return fighterRepository.findAll();
    }
    public Fighter getFighter(Long id) {
        return fighterRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id, Fighter.class));
    }
    public Fighter saveFighter(Fighter fighter) {
        return fighterRepository.save(fighter);
    }
    public Fighter updateFighter(Long id, Fighter fighter) {
        Fighter fighterToUpdate = this.getFighter(id);
        BeanUtils.copyProperties(fighter, fighterToUpdate, "id");
        return fighterRepository.save(fighterToUpdate);
    }
    public void deleteFighter(Long id) {
        Fighter fighterToDelete = this.getFighter(id);
        fighterRepository.delete(fighterToDelete);
    }
}
