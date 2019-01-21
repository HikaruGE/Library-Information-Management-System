package my.library.demo.service;

import my.library.demo.model.User;
import my.library.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class UserManageServiceImpl implements IUserManageService {

    @Autowired
    UserRepository userRepository;

    @Override
    public boolean isUsernameExist(User user) {
        String username = user.getUsername();
        User temp = userRepository.findByUsername(username);
        if(temp == null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public boolean registerNewUser(User user) {
        if(isUsernameExist(user)){
            return false;
        }else{
            userRepository.save(user);
            return true;
        }
    }

    @Override
    public User searchUserById(Long id) {
        return userRepository.findUserById(id);
    }

    @Override
    public void editUserInfo(User user, Long id) {
        User u = userRepository.findUserById(id);
        u.setEmail(user.getEmail());
        u.setPhone(user.getPhone());
        userRepository.saveAndFlush(u);
    }

    @Override
    public User searchUserByName(String name) {
        return userRepository.findByUsername(name);
    }
}
