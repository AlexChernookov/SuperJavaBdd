# SuperJavaBdd

This is an example of test automation framework using JGiven library to create BDD tests without additional DSL as in Cucumber or SpecFlow frameworks. 
Gradle and ChromeDriver are required.
Before runnung test you will have to build project.
If you are running thie of Windows machine, please configure path to chrome, geckodriver or IE dirver in gradle.properties file

To run tests just run command in terminal:<br>
<b> gradle test jgivenTestReport </b>

for exaple to run test agains chromediver you need to run 
 
After run all tests you could find a nice run report 
build/reports/jgiven/test/html/index.html

<img src="report.png" alt="Report example">
