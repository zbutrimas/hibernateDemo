package entities;

import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class MoviesDao {


    public void listAllMovies() {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // save the person object
            List<Movies> movies = session.createQuery("from Movies", Movies.class).list();
            for(Movies movie : movies) {
                System.out.println(movie.toString());
            }
            // commit transaction
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void jdbcMethod(){
        String url = "jdbc:mysql://localhost:3306/cinema_database";
        String user = "root";
        String pass = "378+";

        try {
            Connection conn = DriverManager.getConnection(url, user, pass);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * from movies");
            while (rs.next()) {
                System.out.printf("id = " + rs.getInt("movieId") );
                System.out.printf("name = " + rs.getString("name") );
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void extractMoviesAt20200101() {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // save the person object
            List<Schedules> schedulesList =
                    session.createQuery("from Schedules e where e.startTime between '2020-01-01 00:00:00' and '2020-01-01 23:59:59'", Schedules.class).list();
            for(Schedules schedules : schedulesList) {
                //System.out.println(schedules.toString());
                System.out.println(schedules.getMovie().toString());
            }
            // commit transaction
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public void moviesReservedByJohnJohnson() {
        Transaction transaction = null;
        Session session = null;
        try {
            session = HibernateUtils.getSessionFactory().openSession();
            // start a transaction
            transaction = session.beginTransaction();
            // save the person object
            List<Schedules> schedulesList =
                    session.createQuery("from Schedules e where e.movieId = ", Schedules.class).list();
            for(Schedules schedules : schedulesList) {
                //System.out.println(schedules.toString());
                System.out.println(schedules.getMovie().toString());
            }
            // commit transaction
            transaction.commit();
        } catch (Exception ex) {
            if (transaction != null) {
                transaction.rollback();
            }
            ex.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
