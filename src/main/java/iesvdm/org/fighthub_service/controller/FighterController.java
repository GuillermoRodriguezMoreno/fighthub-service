package iesvdm.org.fighthub_service.controller;

import iesvdm.org.fighthub_service.schema.Fighter;
import iesvdm.org.fighthub_service.service.FighterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin(origins = "*")
@RequestMapping("/v1/fighthub-service/fighters")
public class FighterController {
    @Autowired
    private FighterService fighterService;

    @GetMapping(value = {"", "/"})
    public List<Fighter> getFighters() {
        log.info("FighterController: getFighters");
        return fighterService.getFighters();
    }
    @GetMapping(value = {"/{id}"})
    public Fighter getFighter(@PathVariable Long id) {
        log.info("FighterController: getFighter - id: " + id);
        return fighterService.getFighter(id);
    }
    @PostMapping(value = {"", "/"})
    public Fighter saveFighter(@RequestBody Fighter fighter) {
        log.info("FighterController: saveFighter - id: " + fighter.getId());
        return fighterService.saveFighter(fighter);
    }
    @PutMapping(value = {"/{id}"})
    public Fighter updateFighter(@PathVariable Long id, @RequestBody Fighter fighter) {
        log.info("FighterController: updateFighter - id: " + id);
        return fighterService.updateFighter(id, fighter);
    }
    @DeleteMapping(value = {"/{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public void deleteFighter(@PathVariable Long id) {
        log.info("FighterController: deleteFighter - id: " + id);
        fighterService.deleteFighter(id);
    }
}
