package hu.me.iit.webapp.first.service;

public class Anime {
    private Long id;
    private String name;
    private int time;

    public Anime() {
    }

    public Anime(Long id, String name, int time) {
        this.id = id;
        this.name = name;
        this.time = time;
    }
    public Anime(hu.me.iit.webapp.first.repository.Anime anime) {
        this.id = anime.getId();
        this.name = anime.getName();
        this.time = anime.getTime();
    }

    public hu.me.iit.webapp.first.repository.Anime toEntity(){
        return new hu.me.iit.webapp.first.repository.Anime(id,name, time);

    }

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

    public void setTime(int time) {
        this.time = time;
    }
}
