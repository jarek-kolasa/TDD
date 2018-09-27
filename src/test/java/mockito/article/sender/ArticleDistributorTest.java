package mockito.article.sender;

import mockito.article.article.Article;
import mockito.article.article.Type;
import mockito.article.client.EntertainmentChannel;
import mockito.article.client.OtherChannel;
import mockito.article.client.SportsChannel;
import mockito.article.database.ArticleDataAccess;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ArticleDistributorTest {

    @Mock
    private SportsChannel sport;

    @Mock
    private EntertainmentChannel entertainment;

    @Mock
    private OtherChannel other;

    @Mock
    private ArticleDataAccess dataAccess;

    @InjectMocks
    private ArticleDistributor distributor;


    @Test
    public void sportGoesToSportPoliticsGoesToOther() {

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