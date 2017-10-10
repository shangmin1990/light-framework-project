package com.benjamin.project.service;

import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


/**
 * Created by benjamin on 2017/6/1.
 */
@Service("userService2")
public class UserService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDetails userDetails = new User(s, "ab", true,
                true, true, true,
                AuthorityUtils.createAuthorityList("ROLE_USER"));
        return userDetails;
    }
}
