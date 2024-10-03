package iesvdm.org.fighthub_service.service;

import iesvdm.org.fighthub_service.exception.EntityNotFoundException;
import iesvdm.org.fighthub_service.repository.FightRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import iesvdm.org.fighthub_service.schema.Fight;
import java.util.List;

@Service
public class FightService {
    @Autowired
    private FightRepository fightRepository;

    public List<Fight> getFights() {
        return fightRepository.findAll();
    }
    public Fight getFight(Long id) {
        return fightRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id, Fight.class));
    }
    public Fight saveFight(Fight fight) {
        return fightRepository.save(fight);
    }
    public Fight updateFight(Long id, Fight fight) {
        Fight fightToUpdate = this.getFight(id);
        BeanUtils.copyProperties(fight, fightToUpdate, "id");
        return fightRepository.save(fightToUpdate);
    }
    public void deleteFight(Long id) {
        Fight fightToDelete = this.getFight(id);
        fightRepository.delete(fightToDelete);
    }
}
