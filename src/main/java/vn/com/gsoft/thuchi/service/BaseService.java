package vn.com.gsoft.thuchi.service;

import vn.com.gsoft.thuchi.model.system.Profile;

public interface BaseService {
    Profile getLoggedUser() throws Exception;

}
