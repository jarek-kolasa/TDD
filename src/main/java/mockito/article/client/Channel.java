package mockito.article.client;

import mockito.article.article.Article;

/**
 * A target to relevant articles
 */
public interface Channel {

    /**
     * Call this to send an article to its destination
     * @param article the article to send
     */
    void accept(Article article);
}
