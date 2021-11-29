package hu.me.iit.webapp.first.service;

import hu.me.iit.webapp.first.repository.AnimeRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class AnimeServiceImpl implements AnimeService {
    private final AnimeRepository animeRepository;

    public AnimeServiceImpl(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    @Override
    public Iterable<Anime> getAllAnime() {
        List<Anime> rv=new ArrayList<>();
        for (hu.me.iit.webapp.first.repository.Anime anime: animeRepository.findAll()
             ) {
                rv.add(new Anime(anime));
        }
        return rv;
    }

    @Override
    public Anime getById(Long id) {
        Optional<hu.me.iit.webapp.first.repository.Anime> optionalAnime=animeRepository.findById(id);
        if (optionalAnime.isEmpty()){
            throw new NoSuchEntityException(id);
        }
        return new Anime(optionalAnime.get());

    }

    @Override
    public Anime create(Anime anime) {
        return new Anime(animeRepository.save(anime.toEntity()));
    }

    @Override
    public void save(Anime anime) {
        Optional<hu.me.iit.webapp.first.repository.Anime> optionalAnime=animeRepository.findById(anime.getId());
        if (optionalAnime.isEmpty()){
            throw new NoSuchEntityException(anime.getId());
        }
        animeRepository.save(anime.toEntity());
    }

    @Override
    public void delete(Long id) {
       try {
           animeRepository.deleteById(id);
       }catch (EmptyResultDataAccessException e){
           throw new NoSuchEntityException(id);
       }
    }

    @Override
    public Iterable<? extends Anime> findAllByTimeGreaterThan(int time) {
        return StreamSupport.stream(animeRepository.findAllByTimeGreaterThanEqual(time).spliterator(),false)
                .map(Anime::new).collect(Collectors.toList());
    }
}
