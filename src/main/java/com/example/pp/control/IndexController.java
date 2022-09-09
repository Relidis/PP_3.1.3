
/*
import com.example.pp.model.Role;
import com.example.pp.model.User;
import com.example.pp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class IndexController {
    private final UserService userService;

    @Autowired
    public IndexController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value ="/")
    public String openStartPage() {
        List<User> users = userService.getAllUsers();

        if (users.isEmpty()) {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            Role admin = new Role("ROLE_ADMIN");
            Role user = new Role("ROLE_USER");
            Set<Role> adminRole = new HashSet<>();
            Set<Role> userRole = new HashSet<>();
            adminRole.add(admin);
            userRole.add(user);
            userService.addUser(new User(1L, "Misha", bCryptPasswordEncoder.encode("admin"), adminRole));
            userService.addUser(new User(2L,  "Dima", bCryptPasswordEncoder.encode("user"), userRole));
            userService.addUser(new User(3L, "Kostya", bCryptPasswordEncoder.encode("dimab"), userRole));
            userService.addUser(new User(4L, "vasyap", bCryptPasswordEncoder.encode("vasyap"), userRole));
            userService.addUser(new User(5L, "vasyap", bCryptPasswordEncoder.encode("kostyag"), userRole));
        }
        return "index";
    }
}

 */