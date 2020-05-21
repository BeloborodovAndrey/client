package client.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class User implements UserDetails {

    private Long id;

    private String username;

    private String lastname;

    private Short age;

    private String email;

    private String password;

    private String rolesList;

    private Set<Role> roles;

    public User() {
    }

    public User(Long id, String username, String lastname, Short age, String email, String password, String rolesList) {
        this.id = id;
        this.username = username;
        this.lastname = lastname;
        this.age = age;
        this.email = email;
        this.password = password;
        this.rolesList = rolesList;
    }

    public void addRoles(Set<Role> roles) {
        setRoles(roles);
        for (Role role : roles) {
            role.addUser(this);
        }
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public void setUserName(String name) {
        this.username = name;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return getRoles();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRolesList() {
        return rolesList;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Short getAge() {
        return age;
    }

    public void setAge(Short age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRolesForList() {
        rolesList = "";
        for (Role role: roles) {
            rolesList = rolesList + role.getName() + " ";
        }
    }

    public void setRolesList(String rolesList) {
        this.rolesList = rolesList;
    }

    public void getRolesFromRolesList() {
       Set<String> set = Stream.of(rolesList.split(" ")).collect(Collectors.toSet());
       this.roles = new HashSet<>();
        for (String role: set) {
            roles.add(new Role(role));
        }
    }
}
