
package hu.me.iit.webapp.first;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "article")
public class MainController {

    private List<ArticleDto> articles =new ArrayList<>();
    @GetMapping(path="", produces= MediaType.APPLICATION_JSON_VALUE)
    List<ArticleDto> allArticles() {
   return articles;
    }

    @PostMapping(path="")
    void newArticle(@RequestBody @Valid ArticleDto articleDto){
        articles.add(articleDto);
    }

    private int findArticleById(String id){
        int found=-1;
        for (int i=0;i<articles.size();i++){
            if (articles.get(i).getTitle().equals(id)){
                found=i;
                break;
            }
        }
        return found;
    }

    @PutMapping(path="/{id}")
        void replaceArticle(@PathVariable("id") String id, @RequestBody @Valid ArticleDto articleDto){
            int found=findArticleById(id);
            for (int i=0;i<articles.size();i++){
                if (articles.get(i).getTitle().equals(id)){
                    found=i;
                    break;
                }
            }
            if (found!=-1){
                ArticleDto foundArticle=articles.get(found);
                foundArticle.setAuthor(articleDto.getAuthor());
                foundArticle.setPages(articleDto.getPages());
            }
        }


    @DeleteMapping(path="/{id}")
        void deleteArticle(@PathVariable("id") String id){
            int found=findArticleById(id);
            for (int i=0;i<articles.size();i++){
                if (articles.get(i).getTitle().equals(id)){
                    found=i;
                    break;
                }
            }
            if (found!=-1){
                articles.remove(found);
            }
        }
    }
