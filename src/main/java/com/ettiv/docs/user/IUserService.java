package com.ettiv.docs.user;
import java.util.Optional;

public interface IUserService {

    User registerNewUserAccount(User accountDto);

    void saveRegisteredUser(User user);

    void deleteUser(User user);

    User findUserByEmail(String email);

    Optional<User> getUserByID(long id);

    void changeUserPassword(User user, String password);

    boolean checkIfValidOldPassword(final User user, final String oldPassword);

    boolean emailExists(final String email);

    }
