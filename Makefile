SOURCES = $(shell find $(SRC_DIR) -name "*.java")

all: 
	mkdir -p bin dist
	javac -d bin $(SOURCES)
	jar cfm dist/fodus-java.jar manifest.mf -C bin .

clean: 
	rm -rf ./bin/ 
	rm -rf ./dist/

