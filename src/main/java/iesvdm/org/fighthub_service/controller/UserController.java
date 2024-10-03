package iesvdm.org.fighthub_service.controller;

import iesvdm.org.fighthub_service.schema.User;
import iesvdm.org.fighthub_service.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@CrossOrigin(origins = "*")
@RequestMapping("/v1/fighthub-service/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(value = {"", "/"})
    public List<User> getUsers() {
        log.info("UserController: getUsers");
        return userService.getUsers();
    }
    @GetMapping(value = {"/{id}"})
    public User getUser(Long id) {
        log.info("UserController: getUser - id: " + id);
        return userService.getUser(id);
    }
    @PostMapping(value = {"", "/"})
    public User saveUser(@RequestBody User user) {
        log.info("UserController: saveUser - id: " + user.getId());
        return userService.saveUser(user);
    }
    @PutMapping(value = {"/{id}"})
    public User updateUser(@PathVariable Long id, @RequestBody User user) {
        log.info("UserController: updateUser - id: " + id);
        return userService.updateUser(id, user);
    }
    @DeleteMapping(value = {"/{id}"})
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @ResponseBody
    public void deleteUser(@PathVariable Long id) {
        log.info("UserController: deleteUser - id: " + id);
        userService.deleteUser(id);
    }
}
