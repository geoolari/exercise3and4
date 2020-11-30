import base.PageBase;
import org.junit.jupiter.api.Test;
import pages.way2automation.Way2AutomationStartPage;

public class Exercise4Way2AutomationTest extends PageBase {
    /*
       a. Navigate to http://way2automation.com/way2auto_jquery/index.php
       b. Fill in the mandatory info and submit the form (pop-up registration form appears with no cookies from the page on first visit).
       c. Open the "Date picker" widget.
       d. Navigate to the "FORMAT DATE" section.
       e. Select today's date.
       f. Select the "ISO 8601" Format option.
       g. Validate the shown date against the current date.
     */

    @Test
    public void validateShownDateTest(){
        new Way2AutomationStartPage(driver)
                .register()
                .navigateToDatePickerPage()
                .openFormatDateTab()
                .pickTodayDate()
                .pickFormatDateAsISO8601()
                .validateShownDate();
    }
}
