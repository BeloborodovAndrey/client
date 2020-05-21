package client.serviсe;

import client.model.Role;
import client.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.Response;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HttpHeaders httpHeaders;

    private User createTestUser() {
        User user = new User();
        user.setId(Long.valueOf(1));
        user.setUserName("2");
        user.setPassword("$2a$10$HsmORL95E9Av9wzB5Z6V2OgJWBKHTrSTILh1RO4P47aMPbVLIuzeW");
        user.setLastname("2");
        user.setEmail("2");
        user.setAge((short) 2);
        Set<Role> roles = new HashSet<>();
        Role role = new Role("ADMIN");
        roles.add(role);
        user.addRoles(roles);
        user.setRolesForList();
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User testUser = createTestUser();
        HttpEntity<String> request = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<User>> response = restTemplate.exchange(
                "http://localhost:8088/admin/users", HttpMethod.GET, request,
                new ParameterizedTypeReference<List<User>>(){});
        List<User> users = response.getBody();
        for (User user: users) {
            if(user.getEmail().equals(email)) {
                user.getRolesFromRolesList();
                return user;
            }
        }
        return null;
    }
}
