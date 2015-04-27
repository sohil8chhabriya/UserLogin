package authplugin.dao;

import authplugin.domain.LoginDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * Created by sohil chhabriya on 21-Apr-15.
 */
public class LoginDetailsDaoImpl implements LoginDetailsDao {

    private LoginDetails loginDetails = new LoginDetails();
    private SessionFactory sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
    private LoginDetails userDetails;

    @Override
    public LoginDetails getUserDetails() {
        return this.loginDetails;
    }

    @Override
    public void setUserDetails() {
        this.loginDetails.setName("sohil");
        this.loginDetails.setPassword("sohil");
        this.loginDetails.setPhone("9804484111");
        this.loginDetails.setDateOfBirth("8 july 1990");

        Session session = sessionFactory.openSession();
        session.beginTransaction();

        session.save(loginDetails);

        session.getTransaction().commit();
        session.close();
        sessionFactory.close();
        setUser(loginDetails);
    }

    @Override
    public boolean isUserAuth() {
        return false;
    }

    private void setUser(LoginDetails user) {
        this.userDetails = user;
    }
}
