package ma.mundiapolis.tp2.service;

import jakarta.transaction.Transactional;
import ma.mundiapolis.tp2.entities.Role;
import ma.mundiapolis.tp2.entities.User;
import ma.mundiapolis.tp2.repositories.RoleRepo;
import ma.mundiapolis.tp2.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepo userRepository;
    @Autowired
    private RoleRepo roleRepository;
    @Override
    public User addNewUser(User user) {
        user.setUserId(UUID.randomUUID().toString());
        return userRepository.save(user);
    }

    @Override
    public Role addNewRole(Role role) {

        return roleRepository.save(role);
    }

    @Override
    public User findUserByUserName(String userName) {
        return userRepository.findByUserName(userName);
    }

    @Override
    public Role findRoleByRoleName(String roleName) {
        return roleRepository.findByRoleName(roleName);
    }

    @Override
    public void addRoleToUser(String userName, String roleName) {
        User user = findUserByUserName(userName);
        Role role = findRoleByRoleName(roleName);
        if(user.getRoles() !=null) {
            user.getRoles().add(role);
            userRepository.save(user);
        }


    }

    @Override
    public User autehticate(String userName, String password) {
        User user=userRepository.findByUserName(userName);
        if(user==null) throw  new RuntimeException("Bad credentials");
        if(user.getPassword().equals(password)){
            return  user;
        }
        throw  new RuntimeException("Bad credentials");
    }
}
