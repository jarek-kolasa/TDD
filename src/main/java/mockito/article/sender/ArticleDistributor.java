package mockito.article.sender;

import mockito.article.article.Article;
import mockito.article.client.EntertainmentChannel;
import mockito.article.client.OtherChannel;
import mockito.article.client.SportsChannel;
import mockito.article.database.ArticleDataAccess;

/**
 * Work through today's articles sending them out to the right places
 */
public class ArticleDistributor {

    private SportsChannel sport;
    private EntertainmentChannel entertainment;
    private OtherChannel other;
    private ArticleDataAccess dataAccess;

    public ArticleDistributor(SportsChannel sport, EntertainmentChannel entertainment, OtherChannel other, ArticleDataAccess dataAccess) {
        this.sport = sport;
        this.entertainment = entertainment;
        this.other = other;
        this.dataAccess = dataAccess;
    }

    public void distributeTodays() {
        for (Article article : dataAccess.getTodaysArticle()) {
            switch (article.getType()) {
                case SPORT:
                    sport.accept(article);
                    break;
                case ENTERTAINMENT:
                    entertainment.accept(article);
                    break;
                default:
                    other.accept(article);
                    break;
            }
        }
    }
}
