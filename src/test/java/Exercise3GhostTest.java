import base.PageBase;
import pages.ghost.GhostStartPage;
import org.junit.jupiter.api.Test;

public class Exercise3GhostTest extends PageBase {
    /*
      a. Navigate to https://ghost.org/
      b. Navigate to "Community Forum" section using the "Resources" menu.
      c. Search for “create new blog”
      d. Open one of the search results
     */

    @Test
    public void blogSearchTermTest(){
        new GhostStartPage(driver)
                .navigateToCommunityForumPage()
                .searchTerm("create new blog")
                .openOneSearchedResult();
    }
}
