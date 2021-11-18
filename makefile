JAVAC = javac
JVM = java
JAVADOC = javadoc
MKBIN = mkdir -p bin

JAVAC_FLAGS = -g -d 'bin/'
JAVAC_CP = -cp

MAINSRC = src/
TARGET = bin

MAIN = Workout
MAINTEST = ass1

.SUFFIXES : .class .java

build: 
	$(MKBIN)
	$(JAVAC) $(JAVAC_FLAGS) $(MAINSRC)*.java
	$(JAVAC) $(JAVAC_FLAGS) *.java

clean:
	rm -rf $(TARGET)

run:
	$(JVM) $(JAVAC_CP) $(TARGET) $(MAIN)


.PHONY: build clean run