# Java Selenium testing project

This is a Java Selenium framework using Page Objects Model for web automation testing
## Running tests on browser
The tests are run on Chrome by default.

### Prerequisites

This example requires the following softwares to run:
  * [Java](https://www.oracle.com/technetwork/java/javase/downloads/index.html) or [openJDK](https://openjdk.java.net/install/)
  * [Maven](https://maven.apache.org/download.cgi)
  * [Chrome driver](https://chromedriver.chromium.org/)
  * Chrome browser

### Setting up the project

* Clone git folder
* Download and install items from prerequisites list
* Create maven project in IDE (IntelliJ IDEA, Eclipse etc.) using this code sources
* Default location for chrome driver is "C:\chromedriver\chromedriver.exe"
* To use default settings, create this folder C:\chromedriver\" and copy the "chromedriver.exe" file

## How to run tests

Tests are placed inside the folder "\src\test\java\":

* Exercise3GhostTest class -> blogSearchTermTest() : solution for exercise 3 on page "https://ghost.org/"
* Exercise4Way2AutomationTest class -> validateShownDateTest() : solution for exercise 4 on page "http://way2automation.com/way2auto_jquery/index.php"

Ways to run tests:
* by running the methods having "@Test" annotation: "blogSearchTermTest()" and "validateShownDateTest()"
or
* by running the classes "Exercise3GhostTest" and "Exercise4Way2AutomationTest"
