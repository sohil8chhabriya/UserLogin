package authplugin.dao;

import authplugin.domain.LoginDetails;

/**
 * Created by sohil chhabriya on 21-Apr-15.
 */
public interface LoginDetailsDao {
    LoginDetails getUserDetails();
    void setUserDetails();
    boolean isUserAuth();

}
