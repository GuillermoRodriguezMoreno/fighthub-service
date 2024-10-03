package iesvdm.org.fighthub_service.service;

import iesvdm.org.fighthub_service.exception.EntityNotFoundException;
import iesvdm.org.fighthub_service.repository.UserRepository;
import iesvdm.org.fighthub_service.schema.User;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }
    public User getUser(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(id, User.class));
    }
    public User saveUser(User user) {
        return userRepository.save(user);
    }
    public User updateUser(Long id, User user) {
        User userToUpdate = this.getUser(id);
        BeanUtils.copyProperties(user, userToUpdate, "id");
        return userRepository.save(userToUpdate);
    }
    public void deleteUser(Long id) {
        User userToDelete = this.getUser(id);
        userRepository.delete(userToDelete);
    }
}
