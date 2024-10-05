package iesvdm.org.fighthub_service.service;

import iesvdm.org.fighthub_service.exception.EntityNotFoundException;
import iesvdm.org.fighthub_service.repository.ClubRepository;
import iesvdm.org.fighthub_service.schema.Club;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClubService {
    @Autowired
    private ClubRepository clubRepository;

    public List<Club> getClubs() {
        return clubRepository.findAll();
    }
    public Club getClub(Long id) {
        return clubRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id, Club.class));
    }
    public Club saveClub(Club club) {
        return clubRepository.save(club);
    }
    public Club updateClub (Long id, Club club){
        Club clubToUpdate = this.getClub(id);
        BeanUtils.copyProperties(club, clubToUpdate, "id");
        System.out.println(clubToUpdate);
        return clubRepository.save(clubToUpdate);
    }
    public void deleteClub(Long id) {
        Club clubToDelete = this.getClub(id);
        clubRepository.delete(clubToDelete);
    }
}
