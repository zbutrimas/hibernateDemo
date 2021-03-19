import entities.MoviesDao;

public class Main {

    public static void main(String[] args) {

       // Write your code here
        MoviesDao moviesDao = new MoviesDao();
        moviesDao.listAllMovies();
        //moviesDao.jdbcMethod();
        System.out.println("Looking for movies 2020-01-01");
        moviesDao.extractMoviesAt20200101();

        System.out.println("Movies reserved by John Johnson");
        moviesDao.moviesReservedByJohnJohnson();
    }
}

