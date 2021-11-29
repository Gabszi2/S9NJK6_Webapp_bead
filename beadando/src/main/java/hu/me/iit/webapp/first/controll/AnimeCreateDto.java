package hu.me.iit.webapp.first.controll;

import hu.me.iit.webapp.first.service.Anime;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class AnimeCreateDto {

    @NotEmpty
    private String name;
    @Min(5)
    private int time;

    public AnimeCreateDto() {
    }

    public AnimeCreateDto(Anime anime) {

        this.name = anime.getName();
        this.time = anime.getTime();
    }
    public Anime toAnime(){
        return new Anime(null,name, time);
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
