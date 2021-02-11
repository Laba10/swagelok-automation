### _**SWAGELOK TESTS AUTOMATION PROJECT**_

**How to open project via IntelliJ IDEA:**
1. Download project from GitHub
2. Download and set up Maven
3. Open IntelliJ IDEA
4. Click Import Maven project
5. Select pom.xml in downloaded project
6. Click import

**Project configuration**

create .gitignore file and fill it with:
.gitignore
.idea/
.target/
src/test/resources/META-INF
target
etc.

**Dependencies**
- download and set up Maven
- pom.xml - file with plugins and dependencies


**For tests run**

from commandline: mvn clean test site
- clean - delete old compiled code and artifacts
- test - compile and run tests
- mvn clean test - clean and run

from Maven block in IntelliJ IDEA:
- open lifecycle section-> select clean, test 
- Click "Run Maven Build"





**Run single suite/method via Intellij IDEA**

Make sure that you removed all the old run configurations

- Open Run \ Debug configuration window (Run -> Edit Configurations...)
- Open Defaults configurations and open Junit java configuration

For execution specific test suite:

- Fill the Main class: field with com.swagelok.tests.JunitRunner
- Working directory as: $MODULE_WORKING_DIR$ 
- Save

For execution specific method:
- Select variable as method and provide class name "com.swagelok.tests.suites.CartSuite"
- and in next field method name "verifyProducts"
- Now you can run single scenario via context menu (right-click -> run)