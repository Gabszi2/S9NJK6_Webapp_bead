package hu.me.iit.webapp.first.controll;


import hu.me.iit.webapp.first.service.Anime;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class AnimeDto {
    private Long id;
    @NotEmpty
    private String name;
    @Min(5)
    private int time;

    public AnimeDto() {
    }

    public AnimeDto(Anime anime) {
        this.id = anime.getId();
        this.name = anime.getName();
        this.time = anime.getTime();
    }
    public Anime toAnime(){
    return new Anime(id,name, time);
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
