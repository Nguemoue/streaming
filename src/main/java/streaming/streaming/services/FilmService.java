package streaming.streaming.services;

import streaming.database.DatabaseConnection;
import streaming.streaming.Film;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FilmService {

    public static void storeFilm(Film film) {
        String sql = "INSERT INTO films(name, description, age_min, duration, release_year, trailer) VALUES (?, ?, ?, ?, ?, ?)";

        try {Connection connection = DatabaseConnection.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, film.getName());
            preparedStatement.setString(2, film.getDescription());
            preparedStatement.setInt(3, film.getAgeMin());
            preparedStatement.setInt(4, film.getDuration());
            preparedStatement.setInt(5, film.getReleaseYear());
            preparedStatement.setString(6, film.getTrailer());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }
    }
    public static List<Film> listFilms() {
        List<Film> films = new ArrayList<>();
        String sql = "SELECT * FROM films";

        try {
            Connection connection = DatabaseConnection.getConnection();

             PreparedStatement preparedStatement = connection.prepareStatement(sql);
             ResultSet resultSet = preparedStatement.executeQuery();
             int count = 1;
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String description = resultSet.getString("description");
                int ageMin = resultSet.getInt("age_min");
                int duration = resultSet.getInt("duration");
                int releaseYear = resultSet.getInt("release_year");
                String trailer = resultSet.getString("trailer");

                Film film = new Film(name, description, ageMin, duration, releaseYear, trailer);
                film.setId(count);
                films.add(film);
                count = count+1;
            }
        } catch (SQLException e) {
            System.out.print(e.getMessage());
        }

        return films;
    }
}


