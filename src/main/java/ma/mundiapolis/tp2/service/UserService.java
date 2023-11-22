package ma.mundiapolis.tp2.service;

import ma.mundiapolis.tp2.entities.Role;
import ma.mundiapolis.tp2.entities.User;

public interface UserService {
    User addNewUser(User user);
    Role addNewRole(Role role);
    User findUserByUserName(String userName);
    Role findRoleByRoleName(String roleName);
    void addRoleToUser(String userName,String roleName);
    User autehticate(String userName,String password);
}
