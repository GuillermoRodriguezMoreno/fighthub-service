package iesvdm.org.fighthub_service.controller;

import iesvdm.org.fighthub_service.schema.Fight;
import iesvdm.org.fighthub_service.service.FightService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin(origins = "*")
@RequestMapping("/v1/fighthub-service/fights")
public class FightController {
    @Autowired
    private FightService fightService;

    @GetMapping(value = {"", "/"})
    public List<Fight> getFights() {
        log.info("FightController: getFights");
        return fightService.getFights();
    }
    @GetMapping(value = {"/{id}"})
    public Fight getFight(@PathVariable Long id) {
        log.info("FightController: getFight - id: " + id);
        return fightService.getFight(id);
    }
    @PostMapping(value = {"", "/"})
    public Fight saveFight(@RequestBody Fight fight) {
        log.info("FightController: saveFight - id: " + fight.getId());
        return fightService.saveFight(fight);
    }
    @PutMapping(value = {"/{id}"})
    public Fight updateFight(@PathVariable Long id, @RequestBody Fight fight) {
        log.info("FightController: updateFight - id: " + id);
        return fightService.updateFight(id, fight);
    }
    @DeleteMapping(value = {"/{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public void deleteFight(@PathVariable Long id) {
        log.info("FightController: deleteFight - id: " + id);
        fightService.deleteFight(id);
    }
}
