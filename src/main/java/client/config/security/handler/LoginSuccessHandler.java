package client.config.security.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {



    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException {
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        Collection<? extends GrantedAuthority> authorities
                = authentication.getAuthorities();
        String redirect = redirectFromRoles(authorities);
        httpServletResponse.sendRedirect(redirect);
    }

    private String redirectFromRoles(Collection<? extends GrantedAuthority> authorities) {
        String result = "/user";
        if (authorities.stream().findAny().get().getAuthority().equals("ADMIN")) {
            result = "/admin";
        }
        return result;
    }
}