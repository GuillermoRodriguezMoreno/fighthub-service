package iesvdm.org.fighthub_service.controller;

import iesvdm.org.fighthub_service.schema.Style;
import iesvdm.org.fighthub_service.service.StyleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin(origins = "*")
@RequestMapping("/v1/fighthub-service/styles")
public class StyleController {
    @Autowired
    private StyleService styleService;

    @GetMapping(value = {"", "/"})
    public List<Style> getStyles() {
        log.info("StyleController: getStyles");
        return styleService.getStyles();
    }
    @GetMapping(value = {"/{id}"})
    public Style getStyle(@PathVariable Long id) {
        log.info("StyleController: getStyle - id: " + id);
        return styleService.getStyle(id);
    }
    @PostMapping(value = {"", "/"})
    public Style saveStyle(@RequestBody Style style) {
        log.info("StyleController: saveStyle - id: " + style.getId());
        return styleService.saveStyle(style);
    }
    @PutMapping(value = {"/{id}"})
    public Style updateStyle(@PathVariable Long id, @RequestBody Style style) {
        log.info("StyleController: updateStyle - id: " + id);
        return styleService.updateStyle(id, style);
    }
    @DeleteMapping(value = {"/{id}"})
    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStyle(@PathVariable Long id) {
        log.info("StyleController: deleteStyle - id: " + id);
        styleService.deleteStyle(id);
    }
}
