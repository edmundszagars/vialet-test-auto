# vialet tests
Project includes 3 scenarios for 1 feature:
* User enters valid data in registration first form page
* User enters invalid data in registration first form page
* User enters valid data in registration first form page (FAILS ON PURPOSE TO SHOW SCREENSHOT FUNCTIONALITY)

Reports for test results are generated online. Link for them will be available in console after test run. 
Look for:
 **_View your Cucumber Report at:                                            
 https://reports.cucumber.io/reports/8de21a2b-fe62-4040-b873-666a26348e15_** in console output
                                                                         


### Technologies used
* JAVA 11
* Cucumber JAVA
* Cucumber JUnit
* Cucumber Picocontainer (Dependency Injection)
* Selenide as WebDriver
* Selenoid as host for browsers to run tests on  
* Lombok To reduce boilerplate JAVA code
* Googlecode json-simple for reading and serializing test data
* Gradle as build tool

### Ho to run tests
#### Prerequisites
* Docker should be installed on machine and should be running if remote run feature is used
#### On Windows 
1. Execute **'cm_windows_amd64.exe selenoid start'** in projects directory to start Selenoid 
2. Execute **'cm_windows_amd64.exe selenoid-ui start'** this will enable option to see test execution in browser (127.0.0.1:8080 to access Selenoid UI)
3. Execute **'./gradlew cucumber'** to run all tests

#### On Mac
1. Grant permission to execute **'cm_darwin_amd64'** with command **'chmod  +x cm'** in projects directory
2. Execute **'cm_darwin_amd64 selenoid start'** in projects directory to start Selenoid 
    If Mac Os does not allow to execute this because developer cannot be verified run **'xattr -d com.apple.quarantine cm_darwin_amd64'**
3. Execute **'cm_darwin_amd64 selenoid-ui start'** this will enable to see test execution in browser (127.0.0.1:8080 to access Selenoid UI)    
4. Execute **'./gradlew cucumber'** to run all tests

_For more details on Selenoid setup:_ https://aerokube.com/selenoid/latest/

####System properties
Test configuration properties supported:
* _-Dcucumber.tags_ (For running specific test)
* _-PBROWSER=firefox_ (For specify browser where tests should be executed)
* _-PLOCAL_RUN_ (If you want tu run test locally and don't want to use Selenoid)

For example command **'gradlew cucumber -Dcucumber.tags="@register" -PBROWSER=firefox'** will execute scenario annotated with tag "@register" on firefox browser
And **'./gradlew cucumber -PLOCAL_RUN=true'** will execute tests locally (Chrome needs to be installed on machine)