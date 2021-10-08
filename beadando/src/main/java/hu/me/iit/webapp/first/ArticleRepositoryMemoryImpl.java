package hu.me.iit.webapp.first;

import java.util.ArrayList;
import java.util.List;

public class ArticleRepositoryMemoryImpl implements ArticleRepository {
    private List<ArticleDto> articles =new ArrayList<>();

    private Long findArticleById(String id){
        int found=-1;
        for (int i=0;i<articles.size();i++){
            if (articles.get(i).getTitle().equals(id)){
                found=i;
                break;
            }
        }
        return found;
    }

    @Override
    public List<ArticleDto> findAll() {
        return articles;
    }

    @Override
    public ArticleDto getByID(Long id) {
        return null;
    }

    @Override
    public Long save(ArticleDto articleDto) {

        int found=findArticleById(articleDto.getId());


        if (found!=-1){
            ArticleDto foundArticle=articles.get(found);
            foundArticle.setAuthor(articleDto.getAuthor());
            foundArticle.setPages(articleDto.getPages());
        }
        else
        {
            articles.add(articleDto)
        };
    }

    @Override
    public void delete(Long id) {

    }
}
