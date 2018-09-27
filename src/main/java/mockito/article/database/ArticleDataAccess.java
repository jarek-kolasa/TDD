package mockito.article.database;

import mockito.article.article.Article;

import java.util.List;

public interface ArticleDataAccess {

    /**
     * @return all articles from today
     */
    List<Article> getTodaysArticle();
}
