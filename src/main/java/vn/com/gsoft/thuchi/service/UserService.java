package vn.com.gsoft.thuchi.service;

import vn.com.gsoft.thuchi.model.system.Profile;

import java.util.Optional;

public interface UserService extends BaseService {
    Optional<Profile> findUserByToken(String token);

    Optional<Profile> findUserByUsername(String token);

}
