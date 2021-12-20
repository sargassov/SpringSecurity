package security.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import security.entities.User;
import security.services.UserService;

import java.security.Principal;

@RestController
@RequiredArgsConstructor
public class DemoController {
    private final UserService userService;

//    Если мы прописываем права доступа черех SecurityConfig, то аннотацию @PreAuthorize("hasRole('USER')")
//    над каждым методом контроллера не нужно делать?

    @GetMapping("/")
    public String homePage() {return "home";}

    @GetMapping("/unsecured")
    public String insecuredPage() {return "unsecured";}

    @GetMapping("/auth_page")
    public String authenticatedPage() {return "authenticated";}

    @GetMapping("/admin")
    public String adminPage() {return "admin";}

    @GetMapping("/user_info")
    public String daoTestPage(Principal principal) {
        User user = userService.findByUsername(principal.getName())
                .orElseThrow(() -> new RuntimeException("Unable to find user by Username: " + principal.getName()));
        return "Authenticated user info: " + user.getUsername() + " : " + user.getEmail();
    }
}
