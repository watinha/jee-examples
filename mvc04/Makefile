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
	echo "Manifest-version: 1.0" > manifest.mf;\
	echo "Main-Class: $$MAIN" >> manifest.mf;\
	echo "Class-Path: $$CLASSPATH" >> manifest.mf;

jar: manifest
jar:
	@$(CD) build;\
	$(JAR) cfvm ../package.jar ../manifest.mf *;\
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
	-@$(MKDIR) src lib build test test/build test/src test/lib

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
		$(MKDIR) webapp/web-inf/;\
		touch webapp/web-inf/web.xml;\
		echo "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" > webapp/web-inf/web.xml;\
		echo "<web-app xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"" >> webapp/web-inf/web.xml;\
		echo "     xmlns=\"http://java.sun.com/xml/ns/javaee\"" >> webapp/web-inf/web.xml;\
		echo "     xmlns:web=\"http://java.sun.com/xml/ns/javaee/web-app_3_0.xsd\"" >> webapp/web-inf/web.xml;\
		echo "     id=\"WebApp_ID\" version=\"3.0\">" >> webapp/web-inf/web.xml;\
		echo "    <display-name>JavaCMD for Web</display-name>" >> webapp/web-inf/web.xml;\
		echo "    <servlet>" >> webapp/web-inf/web.xml;\
		echo "        <servlet-name></servlet-name>" >> webapp/web-inf/web.xml;\
		echo "        <servlet-class></servlet-class>" >> webapp/web-inf/web.xml;\
		echo "    </servlet>" >> webapp/web-inf/web.xml;\
		echo "    <servlet-mapping>" >> webapp/web-inf/web.xml;\
		echo "        <servlet-name></servlet-name>" >> webapp/web-inf/web.xml;\
		echo "        <url-pattern></url-pattern>" >> webapp/web-inf/web.xml;\
		echo "    </servlet-mapping>" >> webapp/web-inf/web.xml;\
		echo "</web-app>" >> webapp/web-inf/web.xml;\
		$(MKDIR) webapp/meta-inf;\
	fi;

war: webapp compile
	@$(RM) -rf webapp/web-inf/classes webapp/web-inf/lib;\
	$(CP) -r build webapp/web-inf/classes;\
	$(CP) -r lib webapp/web-inf/lib;\
	$(CD) webapp;\
	$(JAR) cvf ../webapp.war .;\
	$(CD) ../;

webserver: war
	$(JVM) -jar executaveis/jetty-runner-9.2.1.jar webapp

clean:
	@echo "cleanning build files...";\
	$(RM) -rf build;\
	$(RM) -rf test/build;\
    $(MKDIR) build;\
    $(MKDIR) test/build;\
	$(RM) *.jar

.PHONY: compile manifest clean run help init jar junit webapp war
