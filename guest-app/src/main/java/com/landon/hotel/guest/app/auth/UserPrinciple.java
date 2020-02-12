package com.landon.hotel.guest.app.auth;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

public class UserPrinciple implements UserDetails {
    private Optional<User> user;
    private List<AuthGroup> authGroups;

    public UserPrinciple(Optional<User> user,List<AuthGroup> authGroups){
        this.user = user;
        this.authGroups = authGroups;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
       if(authGroups == null) {
           return Collections.emptySet();

       }
       //Set due to uniqueness
        Set<SimpleGrantedAuthority> grantedAuthorities = new HashSet<>();
       authGroups.forEach(group -> {
           grantedAuthorities.add(new SimpleGrantedAuthority(group.getAuthGroup()));
       });
       return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return this.user.get().getPassword();
    }

    @Override
    public String getUsername() {
        return this.user.get().getUserName();
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
}
