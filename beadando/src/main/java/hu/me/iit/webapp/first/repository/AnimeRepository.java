package hu.me.iit.webapp.first.repository;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface AnimeRepository extends PagingAndSortingRepository<Anime,Long> {
    Iterable<Anime> findAllByTimeGreaterThanEqual(int time);

}
