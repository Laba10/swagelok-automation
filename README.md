**TEMPLATE TESTS AUTOMATION PROJECT**

**Project configuration**

create .gitignore file and fill it with:
.gitignore
.idea/
.target/
src/test/resources/META-INF
target
etc.

**Dependencies**
download and set up Maven
pom.xml - file with plugins and dependencies

**For tests run**
from commandline: mvn clean test site jetty:run
clean - delete old compiled code and artifacts
test - compile and run tests
mvn clean test - clean and run


**Run single suite/method via Intellij IDEA**
Make sure that you removed all the old run configurations

Open Run \ Debug configuration window (Run -> Edit Configurations...)
Open Defaults configurations and open Junit java configuration

For execution specific test suite:
Fill the Main class: field with com.swagelok.tests.JunitRunner
Working directory as: $MODULE_WORKING_DIR$ 
Save

For execution specific method:
Select variable as method and provide class name "com.swagelok.tests.suites.CartSuite"
and in next field method name "verifyProducts"
Now you can run single scenario via context menu (right-click -> run)