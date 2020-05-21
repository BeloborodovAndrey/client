package client.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@Controller
@RequestMapping("/")
public class UsersController {

    public String redirectFromRoles(HttpServletRequest req, Collection<? extends GrantedAuthority> authorities) {
        boolean isAdmin = false;
        for (GrantedAuthority grantedAuthority : authorities) {
            if (grantedAuthority.getAuthority().equals("ADMIN")) {
                isAdmin = true;
                break;
            }
        }
        if (isAdmin) {
            return req.getContextPath() + "/admin";
        } else {
            return req.getContextPath() + "/user";
        }
    }

    @GetMapping("/")
    public String getLoginPage(HttpServletRequest request, Authentication authentication) {
        //User user = createTestUser();
        //userService.addUser(user);
        if (authentication != null) {
            if (authentication.isAuthenticated()) {
                return "redirect:" + redirectFromRoles(request, authentication.getAuthorities());
            }
        }
        return "login";
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, Authentication authentication) {
        if (authentication.isAuthenticated()) {
            authentication.setAuthenticated(false);
        }
        return "redirect:" + request.getContextPath() + "/";
    }

    @GetMapping("/user")
    public String getUser() {
        return "user";
    }

    @GetMapping("/admin")
    public String getUsersPage(HttpServletRequest request) {
        return "admin";
    }
}
