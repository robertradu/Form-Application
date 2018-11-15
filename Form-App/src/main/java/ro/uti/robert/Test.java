package ro.uti.robert;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {
    public static void main(String[] args) {

        Coordinates coordinates = new Coordinates();
        coordinates.setAltitude(23.4);
        coordinates.setLatitude(345.3);
        coordinates.setLongitude(12.65);

        Configuration configuration = new Configuration().configure().addAnnotatedClass(Coordinates.class);

        SessionFactory sessionFactory = configuration.buildSessionFactory();

        Session session = sessionFactory.openSession();



        //System.out.println(coordinates.getAltitude());

       Transaction transaction = session.beginTransaction();
        session.save(coordinates);

        transaction.commit();
  //      session.close();
    }
}
