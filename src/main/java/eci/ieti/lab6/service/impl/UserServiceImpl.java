package eci.ieti.lab6.service.impl;

import eci.ieti.lab6.entity.User;
import eci.ieti.lab6.service.UserService;
import eci.ieti.lab6.service.UserServiceExeption;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    CopyOnWriteArrayList<User> listUsersCache= new CopyOnWriteArrayList<>();
    User user1= new User("1","123","pepito@gmail.com");
    User user2=new User("2","123","pablo@gmail.com");
    User user3= new User("3","123","vanessa@gmail.com");
    User user4= new User("4","123","laura@gmail.com");

    public UserServiceImpl(){
        listUsersCache.add(user1);
        listUsersCache.add(user2);
        listUsersCache.add(user3);
        listUsersCache.add(user4);
    }

    @Override
    public List<User> getAll() {
        return listUsersCache;
    }

    @Override
    public User getById(String userId) throws UserServiceExeption {
        List<User> users= listUsersCache.stream()
                .filter(i -> i.getId().equals(userId))
                .collect(Collectors.toList());
        if(users.size()==1){
            return users.get(0);
        }else{
            throw new UserServiceExeption("No hay usuarios o hay mas de un usuario con ese ID");
        }

    }

    @Override
    public User create(User user) {
        listUsersCache.add(user);
        user.setId(String.valueOf(listUsersCache.size()));
        return user;
    }

    @Override
    public User update(User user) throws UserServiceExeption {
        User gottenUser= getById(user.getId());
        String newContraseña= (gottenUser.getContraseña().equals(user.getContraseña()))?gottenUser.getContraseña():user.getContraseña();
        String newEmail= (gottenUser.getEmail().equals(user.getEmail()))?gottenUser.getEmail():user.getEmail();
        gottenUser.setContraseña(newContraseña);
        gottenUser.setEmail(newEmail);
        return gottenUser;
    }

    @Override
    public void remove(String userId) throws UserServiceExeption {
        User gottenUser= getById(userId);
        listUsersCache.remove(gottenUser);
    }
}
