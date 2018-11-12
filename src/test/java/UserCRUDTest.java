import com.coreteka.entities.Authorities;
import com.coreteka.entities.User;
import com.coreteka.service.AuthoritiesService;
import com.coreteka.service.UserService;
import com.coreteka.service.impl.AuthoritiesServiceImpl;
import com.coreteka.service.impl.UserServiceImpl;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;


public class UserCRUDTest {
    
    @Test
    public void createUser(){

        AuthoritiesService authoritiesService = new AuthoritiesServiceImpl();
        List<Authorities> authoritiesList = authoritiesService.getAuthoritiesList();
        if (authoritiesList.isEmpty()){
            System.out.println("Please populate t_authorities table to run this test");
        }

        long i = new Random().nextLong();
        User user = new User();
        user.setUsername("Murz" + i);
        user.setPassword("***" + i);
        user.setUser_status(true);

        Set<Authorities> authoritiesSet = new HashSet<>();
        authoritiesSet.add(authoritiesList.get(0));

        user.setAuthorities(authoritiesSet);

        UserService userService = new UserServiceImpl();

        userService.createUser(user);

    }
}
