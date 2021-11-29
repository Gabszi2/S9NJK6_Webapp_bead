package hu.me.iit.webapp.first.repository;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Anime {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private int time;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int lenght) {
        this.time = lenght;
    }

    public Anime() {
    }

    public Anime(Long id, String name, int time) {
        this.id = id;
        this.name = name;
        this.time = time;
    }
}
