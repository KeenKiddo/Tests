package com.test;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class MovieDao {

    public void addMovie(Movie movie) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Movie movTab = getMovieById(movie.getId());
        	if (movTab == null) {
        		session.save(movie);
        	}
            //session.save(movie);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
    
    public void addRating(Rating rating) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.save(rating);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }
    
    public void addListMovie(List<Movie> movies) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            for (int i = 0; i < movies.size(); i++) {
            	Movie mov = getMovieById(movies.get(i).getId());
            	if (mov == null) {
            		session.save(movies.get(i));
            	}
            }
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public void deleteMovie(int movieid) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            Movie movie = (Movie) session.load(Movie.class, new Integer(movieid));
            session.delete(movie);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public void updateMovie(Movie movie) {
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            session.update(movie);
            session.getTransaction().commit();
        } catch (RuntimeException e) {
            if (trns != null) {
                trns.rollback();
            }
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
    }

    public List<Movie> getAllMovies() {
        List<Movie> movies = new ArrayList<Movie>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            movies = session.createQuery("from movies").list();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return movies;
    }

    public Movie getMovieById(int movieid) {
    	Movie movie = null;
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            String queryString = "from Movie where id = :id";
            Query query = session.createQuery(queryString);
            query.setInteger("id", movieid);
            movie = (Movie) query.uniqueResult();
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return movie;
    }
    
    public List<Rating> getAllRatings() {
        List<Rating> ratings = new ArrayList<Rating>();
        Transaction trns = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            trns = session.beginTransaction();
            ratings = session.createQuery("from Rating").list();
            
            for (Iterator iterator = ratings.iterator(); iterator.hasNext();){
                Rating rat = (Rating) iterator.next(); 
                System.out.print("Id: " + rat.getId()); 
                Movie mov = rat.getMovie();
                System.out.println("\tMovie name: " +  mov.getName());

             }
        } catch (RuntimeException e) {
            e.printStackTrace();
        } finally {
            session.flush();
            session.close();
        }
        return ratings;
    }
}