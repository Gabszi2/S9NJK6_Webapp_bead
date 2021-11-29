package hu.me.iit.webapp.first.service;

public interface AnimeService {
    Iterable<Anime> getAllAnime();
    Anime getById(Long id);
    Anime create(Anime anime);
    void save(Anime anime);
    void delete(Long id);
    Iterable<? extends Anime> findAllByTimeGreaterThan(int time);
}
