unit:
	mvn test

coverage:
	mvn cobertura:cobertura

compile:
	mvn compile

enhance:
	mvn openjpa:enhance

webserver: compile enhance
	mvn jetty:run

help:
	@echo "****************************************************"
	@echo "*****      \033[1;34mJava Makefile help\033[0;0m                  *****"
	@echo "****************************************************"
	@echo ""
	@echo "    \033[32mcompile     :\033[0m    - compile all .java files"
	@echo "    \033[32munit        :\033[0m    - run jUnit tests"
	@echo "    \033[32mcoverage    :\033[0m    - generates coverage report"
	@echo "    \033[32menhance     :\033[0m    - openjpa enhance Java entity classes"
	@echo "    \033[32mwebserver   :\033[0m    - run the jetty webserver"
	@echo "\n"

.PHONY: unit coverage compile enhance webserver help
