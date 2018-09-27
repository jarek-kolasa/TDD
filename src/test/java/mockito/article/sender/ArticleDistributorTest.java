package mockito.article.sender;

import mockito.article.article.Article;
import mockito.article.article.Type;
import mockito.article.client.Channel;
import mockito.article.database.ArticleDataAccess;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;
import static sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap.Byte1.other;

public class ArticleDistributorTest {

    @Test
    public void sportGoesToSportPoliticsGoesToOther() {

        Channel sport = mock(Channel.class);
        Channel entertainment = mock(Channel.class);
        Channel other = mock(Channel.class);
        ArticleDataAccess dataAccess = mock(ArticleDataAccess.class);

        ArticleDistributor distributor = new ArticleDistributor(sport, entertainment, other, dataAccess);

        // given this list of articles is returned form the database
        List<Article> list = asList(
                new Article("Sport is fun", Type.SPORT),
                new Article("Politics is sad", Type.POLITICS));

        when(dataAccess.getTodaysArticle()).thenReturn(list);

        // when we distribute
        distributor.distributeTodays();

        // then one goes to sport and one goes to other
        verify(sport).accept(any());
        verify(other).accept(any());
        verify(entertainment, never()).accept(any());
    }

}