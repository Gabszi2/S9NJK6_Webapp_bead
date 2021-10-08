package hu.me.iit.webapp.first;

import java.util.List;

public interface ArticleService {
    List<ArticleDto> findAll();
    ArticleDto getByID(Long id);
    Long save(ArticleDto articleDto);
    void delete(Long id);
}
