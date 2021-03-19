package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int movieId;

    private String name;

    private String category;

    private int durationInMinutes;

    private String description;

//    @OneToMany(mappedBy = "movies")
//    private List<Schedules> schedulesList;
//
//    public List<Schedules> getSchedulesList() {
//        return schedulesList;
//    }
//
//    public void setSchedulesList(List<Schedules> schedulesList) {
//        this.schedulesList = schedulesList;
//    }

    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getDurationInMinutes() {
        return durationInMinutes;
    }

    public void setDurationInMinutes(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Movies{" +
                "movieId=" + movieId +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", durationInMinutes=" + durationInMinutes +
                ", description='" + description + '\'' +
                '}';
    }
}
