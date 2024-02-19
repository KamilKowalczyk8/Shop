package com.example.demo.configuration;

import com.example.demo.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;

public class CustomerUserDetails implements UserDetails {
    private String username;
    private String password;

    public CustomerUserDetails(User user){
        this.username = user.getUsername();
        this.password = user.getPassword();
    }
    public Collection <? extends GrantedAuthority> getAuthorites(){return null;}

    public String getPassword() {return password;}

    public String getUsername() {return username;}

    public boolean isAccountNonExpired(){return true;}

    public boolean isAccountNonLocked(){return true;}

    public boolean isCredentialsNonExpired(){return true;}

    public boolean isEnabled(){return true;}
}
