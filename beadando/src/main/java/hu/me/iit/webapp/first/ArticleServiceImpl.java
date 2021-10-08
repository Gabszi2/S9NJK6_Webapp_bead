package hu.me.iit.webapp.first;

import java.util.List;

public class ArticleServiceImpl implements ArticleService {
    private final int MAXIMUM_ARTICLE_COUNT=10;
    private final ArticleRepository aricleRepository;

    public ArticleServiceImpl(ArticleRepository aricleRepository) {
        this.aricleRepository = aricleRepository;
    }

    @Override
    public List<ArticleDto> findAll() {
        return null;
    }

    @Override
    public ArticleDto getByID(Long id) {
        return aricleRepository.getByID(id);
    }

    @Override
    public Long save(ArticleDto articleDto) {
        if (aricleRepository.findAll().size()>MAXIMUM_ARTICLE_COUNT){
            throw new TooMuchArticleException();
        }
        return aricleRepository.save(articleDto);
    }

    @Override
    public void delete(Long id) {

    }
}
