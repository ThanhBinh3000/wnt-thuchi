package vn.com.gsoft.thuchi.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import vn.com.gsoft.thuchi.model.system.Profile;
import vn.com.gsoft.thuchi.repository.feign.UserProfileFeign;
import vn.com.gsoft.thuchi.service.UserService;


import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserProfileFeign userProfileFeign;

    @Override
    public Optional<Profile> findUserByToken(String token) {
        ObjectMapper objectMapper = new ObjectMapper();
        Profile profile = objectMapper.convertValue(userProfileFeign.getProfile().getData(), Profile.class);
        return Optional.of(profile);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
