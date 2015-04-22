export JVM="java"
export JC="javac"
export JAR="jar"
export SH="sh"
export RM="rm"
export LN="ln"
export CP="cp"
export FLAGS=""
export CD="cd"
export MKDIR="mkdir"
export CLASSPATH=""
export TEST_CLASSPATH=""

help:
	@echo "****************************************************"
	@echo "*****      \033[1;34mJava Makefile help\033[0;0m                  *****"
	@echo "****************************************************"
	@echo "    - Make sure all your .java source codes are placed inside the src/ directory"
	@echo ""
	@echo "    \033[32mcompile     :\033[0m    - compile all .java files in the build directory"
	@echo "    \033[32mjar         :\033[0m    - generate a .jar file for the application"
	@echo "    \033[32mrun         :\033[0m    - run the .jar file"
	@echo "    \033[32mtest-compile:\033[0m    - compile the test files"
	@echo "    \033[32mjunit       :\033[0m    - run all test files"
	@echo "    \033[32mwebapp      :\033[0m    - creates a directory structure for JEE applications"
	@echo "    \033[32mwar         :\033[0m    - creates a .war file to be deployed in a servlet container"
	@echo "\n"

compile:
	@echo "compiling java files...";\
	CLASSPATH="";\
	CHANGED="";\
	for i in `find lib -name "*.jar"`; do\
		CLASSPATH="$$i:$$CLASSPATH";\
	done;\
	for i in `find src -depth -name *.java | nl | sort -nr | cut -f 2-`; do\
		PKG_DIR=`echo "$$i" | sed "s/\(src.*\)\/.*\.java/\1/"`;\
		CLASS_FILE=`echo "$$i" | sed "s/src\/\(.*\)\.java/.\/build\/\1\.class/"`;\
        if [ ! -e $$CLASS_FILE -o $$CLASS_FILE -ot $$i ]; then\
			echo "recompiling $$PKG_DIR/*.java...";\
			CHANGED="$$CHANGED $$i";\
			if [ $$? -ne 0 ]; then\
				exit 1;\
			fi;\
		fi;\
	done;\
	if [ "$$CHANGED" ]; then\
		$(JC) -d build -cp "$$CLASSPATH:build/" $$CHANGED;\
	else\
		echo "No changed files.";\
	fi;

manifest: compile
	@MAIN=`grep -r "public static void main" src/* | grep -v .swp| sed "s/src\/\(.*\).java:.*/\1/" | head -n 1`;\
	CLASSPATH="./";\
	for i in `find lib -name "*.jar"`; do\
		CLASSPATH="$$CLASSPATH $$i";\
	done;\
	echo "The main class of the jar file is: $$MAIN";\
	echo "Manifest-version: 1.0" > META-INF/manifest.mf;\
	echo "Main-Class: $$MAIN" >> META-INF/manifest.mf;\
	echo "Class-Path: $$CLASSPATH" >> META-INF/manifest.mf;

jar: manifest
jar:
	@$(CD) build;\
	$(CP) -r ../META-INF/ META-INF/;\
	$(JAR) cfvm ../package.jar ../META-INF/manifest.mf *;\
	$(CD) ..;

run: jar
run:
	@echo "Running...";\
	echo "";\
	CLASSPATH="./";\
	for i in `find lib -name "*.jar"`; do\
		CLASSPATH="$$CLASSPATH:$$i";\
	done;\
	$(JVM) -cp "$$CLASSPATH" -jar package.jar;\
	echo "";

init:
	-@$(MKDIR) src lib build test test/build test/src test/lib META-INF/

junit: test-compile
	@echo "running jUnit tests...";\
	TEST_CLASSPATH="";\
	for i in `find test/lib -name "*.jar"`; do\
		TEST_CLASSPATH="$$i:$$TEST_CLASSPATH";\
	done;\
	TESTS=`find test/build -name *Test.class | sed "s/\//./g" | sed "s/\.class//" | sed "s/test\.build\.//"`;\
	$(JVM) -cp "$$TEST_CLASSPATH:test/build/:build/" org.junit.runner.JUnitCore $$TESTS

test-compile: compile
	@echo "compiling java files...";\
	TEST_CLASSPATH="";\
	for i in `find test/lib -name "*.jar"`; do\
		TEST_CLASSPATH="$$i:$$TEST_CLASSPATH";\
	done;\
	for i in `find test/src -depth -name *.java | nl | sort -nr | cut -f 2-`; do\
		PKG_DIR=`echo "$$i" | sed "s/\(test\/src.*\)\/.*\.java/\1/"`;\
		CLASS_FILE=`echo "$$i" | sed "s/test\/src\/\(.*\)\.java/test\/build\/\1\.class/"`;\
        if [ ! -e $$CLASS_FILE -o $$CLASS_FILE -ot $$i ]; then\
			echo "recompiling $$PKG_DIR/*.java...";\
			$(JC) -d test/build -cp "$$TEST_CLASSPATH:test/build/:build/" $$PKG_DIR/*.java;\
			if [ $$? -ne 0 ]; then\
				exit 1;\
			fi;\
		fi;\
	done

webapp:
	@if	[ ! -e webapp/ ]; then\
		$(MKDIR) webapp/;\
		$(MKDIR) webapp/WEB-INF/;\
		touch webapp/WEB-INF/web.xml;\
		echo "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" > webapp/WEB-INF/web.xml;\
		echo "<web-app xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"" >> webapp/WEB-INF/web.xml;\
		echo "     xmlns=\"http://java.sun.com/xml/ns/javaee\"" >> webapp/WEB-INF/web.xml;\
		echo "     xmlns:web=\"http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd\"" >> webapp/WEB-INF/web.xml;\
		echo "     id=\"WebApp_ID\" version=\"3.0\">" >> webapp/WEB-INF/web.xml;\
		echo "    <display-name>JavaCMD for Web</display-name>" >> webapp/WEB-INF/web.xml;\
		echo "    <servlet>" >> webapp/WEB-INF/web.xml;\
		echo "        <servlet-name></servlet-name>" >> webapp/WEB-INF/web.xml;\
		echo "        <servlet-class></servlet-class>" >> webapp/WEB-INF/web.xml;\
		echo "    </servlet>" >> webapp/WEB-INF/web.xml;\
		echo "    <servlet-mapping>" >> webapp/WEB-INF/web.xml;\
		echo "        <servlet-name></servlet-name>" >> webapp/WEB-INF/web.xml;\
		echo "        <url-pattern></url-pattern>" >> webapp/WEB-INF/web.xml;\
		echo "    </servlet-mapping>" >> webapp/WEB-INF/web.xml;\
		echo "</web-app>" >> webapp/WEB-INF/web.xml;\
	fi;

war: webapp compile
	@$(RM) -rf webapp/WEB-INF/classes webapp/WEB-INF/lib;\
	$(CP) -r build webapp/WEB-INF/classes;\
	$(CP) -r resources webapp/WEB-INF/classes/resources;\
	$(CP) -r lib webapp/WEB-INF/lib;\
	$(CP) -r META-INF/ webapp/META-INF/;\
	$(CD) webapp;\
	$(JAR) cvf ../webapp.war .;\
	$(CD) ../;

persistence:
	@if	[ ! -e META-INF/persistence.xml ]; then\
        echo "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" > META-INF/persistence.xml;\
		echo "<persistence xmlns=\"http://java.sun.com/xml/ns/persistence\"" >> META-INF/persistence.xml;\
		echo "	  xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"" >> META-INF/persistence.xml;\
		echo "	  xsi:schemaLocation=\"http://java.sun.com/xml/ns/persistence" >> META-INF/persistence.xml;\
		echo "	     http://java.sun.com/xml/ns/persistence/persistence_2_0.xsd\"" >> META-INF/persistence.xml;\
		echo "	  version=\"2.0\">" >> META-INF/persistence.xml;\
		echo "    <persistence-unit name=\"tarefas\">" >> META-INF/persistence.xml;\
		echo "        <class>br.com.caelum.tarefas.modelo.Tarefa</class>" >> META-INF/persistence.xml;\
		echo "        <properties>" >> META-INF/persistence.xml;\
		echo "            <property name=\"javax.persistence.jdbc.driver\"" >> META-INF/persistence.xml;\
		echo "                      value=\"com.mysql.jdbc.Driver\" />" >> META-INF/persistence.xml;\
		echo "            <property name=\"javax.persistence.jdbc.url\"" >> META-INF/persistence.xml;\
		echo "                      value=\"jdbc:mysql://localhost/fj21\" />" >> META-INF/persistence.xml;\
		echo "            <property name=\"javax.persistence.jdbc.user\"" >> META-INF/persistence.xml;\
		echo "                      value=\"root\" />" >> META-INF/persistence.xml;\
		echo "            <property name=\"javax.persistence.jdbc.password\"" >> META-INF/persistence.xml;\
		echo "                      value=\"\" />" >> META-INF/persistence.xml;\
		echo "			  <property name=\"openjpa.jdbc.SynchronizeMappings\"">>META-INF/persistence.xml;\
		echo "						value=\"buildSchema(ForeignKeys=true)\"/>">>META-INF/persistence.xml;\
		echo "        </properties>" >> META-INF/persistence.xml;\
		echo "    </persistence-unit>" >> META-INF/persistence.xml;\
		echo "</persistence>" >> META-INF/persistence.xml;\
	fi

jsf: webapp
	@touch webapp/WEB-INF/web.xml;\
	echo "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" > webapp/WEB-INF/web.xml;\
	echo "<web-app xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"" >> webapp/WEB-INF/web.xml;\
	echo "     xmlns=\"http://java.sun.com/xml/ns/javaee\"" >> webapp/WEB-INF/web.xml;\
	echo "     xmlns:web=\"http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd\"" >> webapp/WEB-INF/web.xml;\
	echo "     id=\"WebApp_ID\" version=\"3.0\">" >> webapp/WEB-INF/web.xml;\
	echo "    <display-name>JavaCMD for Web</display-name>" >> webapp/WEB-INF/web.xml;\
	echo "    <servlet>" >> webapp/WEB-INF/web.xml;\
	echo "        <servlet-name>Faces Servlet</servlet-name>" >> webapp/WEB-INF/web.xml;\
	echo "        <servlet-class>javax.faces.webapp.FacesServlet</servlet-class>" >> webapp/WEB-INF/web.xml;\
	echo "    </servlet>" >> webapp/WEB-INF/web.xml;\
	echo "    <servlet-mapping>" >> webapp/WEB-INF/web.xml;\
	echo "        <servlet-name>Faces Servlet</servlet-name>" >> webapp/WEB-INF/web.xml;\
	echo "        <url-pattern>/faces/*</url-pattern>" >> webapp/WEB-INF/web.xml;\
	echo "    </servlet-mapping>" >> webapp/WEB-INF/web.xml;\
	echo "    <welcome-file-list>" >> webapp/WEB-INF/web.xml;\
	echo "        <welcome-file>faces/index.xhtml</welcome-file>" >> webapp/WEB-INF/web.xml;\
	echo "    </welcome-file-list>" >> webapp/WEB-INF/web.xml;\
	echo "    <context-param>" >> webapp/WEB-INF/web.xml;\
	echo "        <param-name>javax.faces.PROJECT_STAGE</param-name>" >> webapp/WEB-INF/web.xml;\
	echo "        <param-value>Development</param-value>" >> webapp/WEB-INF/web.xml;\
	echo "    </context-param>" >> webapp/WEB-INF/web.xml;\
	echo "    <listener>" >> webapp/WEB-INF/web.xml;\
	echo "        <listener-class>com.sun.faces.config.ConfigureListener</listener-class>" >> webapp/WEB-INF/web.xml;\
	echo "    </listener>" >> webapp/WEB-INF/web.xml;\
	echo "</web-app>" >> webapp/WEB-INF/web.xml;
	@touch webapp/WEB-INF/faces-config.xml;\
	echo "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" > webapp/WEB-INF/faces-config.xml;\
	echo "<faces-config" >> webapp/WEB-INF/faces-config.xml;\
	echo "	xmlns=\"http://java.sun.com/xml/ns/javaee\"" >> webapp/WEB-INF/faces-config.xml;\
	echo "	xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"" >> webapp/WEB-INF/faces-config.xml;\
	echo "	xsi:schemaLocation=\"http://java.sun.com/xml/ns/javaee" >> webapp/WEB-INF/faces-config.xml;\
	echo "	http://java.sun.com/xml/ns/javaee/web-facesconfig_2_0.xsd\"" >> webapp/WEB-INF/faces-config.xml;\
	echo "	version=\"2.0\">" >> webapp/WEB-INF/faces-config.xml;\
	echo "</faces-config>" >> webapp/WEB-INF/faces-config.xml;

clean:
	@echo "cleanning build files...";\
	$(RM) -rf build;\
	$(RM) -rf test/build;\
    $(MKDIR) build;\
    $(MKDIR) test/build;\
	$(RM) package.jar

webserver: war
	@$(JVM) -jar jetty-runner.jar webapp

.PHONY: compile manifest clean run help init jar junit webapp war persistence webserver
