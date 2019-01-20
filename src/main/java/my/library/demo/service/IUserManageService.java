package my.library.demo.service;

import my.library.demo.model.User;

public interface IUserManageService {
    boolean isUsernameExist(User user);
    boolean registerNewUser(User user);
}
