package hu.me.iit.webapp.first.controll;

import hu.me.iit.webapp.first.service.Anime;
import hu.me.iit.webapp.first.service.AnimeService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/anime")
public class AnimeController {
private final AnimeService animeService;

    public AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }

    @GetMapping
    public Iterable<AnimeDto> getAllAnime(){
        List<AnimeDto> animeDtoList=new ArrayList<>();
        for (Anime anime:animeService.getAllAnime()
             ) {
            animeDtoList.add(new AnimeDto(anime));
        }
        return animeDtoList;
    }

    @GetMapping("/{id}")
    public AnimeDto getById(@PathVariable("id") Long id) {
        return new AnimeDto(animeService.getById(id));

    }

    @PostMapping(consumes = "application/json")
    public AnimeDto save(@RequestBody @Valid AnimeCreateDto animeCreateDto){
        return new AnimeDto(animeService.create(animeCreateDto.toAnime()));
    }

    @PutMapping
    public  void save(@RequestBody @Valid AnimeDto animeDto){
        animeService.save(animeDto.toAnime());
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {
        animeService.delete(id);
    }

@GetMapping("/findByTimeGT")
    public Iterable<AnimeDto> findLongAnime(@RequestParam("time") int time){
        List<AnimeDto> animeDtoList=new ArrayList<>();
    for (Anime anime:animeService.findAllByTimeGreaterThan(time)
         ) {
        animeDtoList.add(new AnimeDto(anime));
    }
    return animeDtoList;
}

}
