package client.controller;

import client.model.User;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.Response;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/")
public class UsersRestController {

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    HttpHeaders httpHeaders;

    @GetMapping("/admin/users")
    public ResponseEntity<List<User>> getUsersList() {
        HttpEntity<String> request = new HttpEntity<>(httpHeaders);
        ResponseEntity<List<User>> response = restTemplate.exchange(
                "http://localhost:8088/admin/users", HttpMethod.GET, request,
                new ParameterizedTypeReference<List<User>>(){});
        List<User> users = response.getBody();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/admin/add")
    public void addUser(@RequestBody User requestUser) {
        HttpEntity<User> request = new HttpEntity<>(requestUser, httpHeaders);
        restTemplate.postForEntity("http://localhost:8088/admin/add", request, HttpEntity.class);
    }


    @PostMapping("/admin/editUser")
    public ResponseEntity<User> getUpdateData(@RequestBody String id) {
        User user = new User();
        user.setId(Long.valueOf(id));
        // Data attached to the request.
        HttpEntity<User> requestBody = new HttpEntity<>(user, httpHeaders);
        // Send request with POST method.
        User serverUser = restTemplate.postForObject("http://localhost:8088/admin/editUser/", requestBody, User.class);
        return new ResponseEntity(serverUser, HttpStatus.OK);
    }

    @PostMapping("/admin/edit")
    public void updateUser(@RequestBody User user) {
        HttpEntity<User> request = new HttpEntity<>(user, httpHeaders);
        restTemplate.postForEntity("http://localhost:8088/admin/edit", request, User.class);
    }

    @PostMapping("/admin/delete")
    public void deleteUser(@RequestBody String id) {
        HttpEntity<String> request = new HttpEntity<>(id, httpHeaders);
        restTemplate.postForEntity("http://localhost:8088/admin/delete", request, User.class);
    }
}
