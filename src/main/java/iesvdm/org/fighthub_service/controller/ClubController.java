package iesvdm.org.fighthub_service.controller;

import iesvdm.org.fighthub_service.schema.Club;
import iesvdm.org.fighthub_service.service.ClubService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin(origins = "*")
@RequestMapping("/v1/fighthub-service/clubs")
public class ClubController {
    @Autowired
    private ClubService clubService;

    @GetMapping(value = {"", "/"})
    public List<Club> getClubs() {
        log.info("ClubController: getClubs");
        return clubService.getClubs();
    }
    @GetMapping(value = {"/{id}"})
    public Club getClub(@PathVariable Long id) {
        log.info("ClubController: getClub - id: " + id);
        return clubService.getClub(id);
    }
    @PostMapping(value = {"", "/"})
    public Club saveClub(@Valid @RequestBody Club club) {
        log.info("ClubController: saveClub - id: " + club.getId());
        return clubService.saveClub(club);
    }
    @PutMapping(value = {"/{id}"})
    public Club updateClub(@PathVariable Long id, @Valid @RequestBody Club club) {
        log.info("ClubController: updateClub - id: " + id);
        return clubService.updateClub(id, club);
    }
    @DeleteMapping(value = {"/{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public void deleteClub(@PathVariable Long id) {
        log.info("ClubController: deleteClub - id: " + id);
        clubService.deleteClub(id);
    }
}
