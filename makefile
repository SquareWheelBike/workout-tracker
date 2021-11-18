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

# compile all .java files in src/
build: 
	$(MKBIN)
	$(JAVAC) $(JAVAC_FLAGS) $(MAINSRC)*.java
	$(JAVAC) $(JAVAC_FLAGS) *.java

# clean the bin directory
clean:
	rm -rf $(TARGET)

# just run the main class
run:
	$(JVM) $(JAVAC_CP) $(TARGET) $(MAIN)

# compile and run the main class
all:
	$(MKBIN)
	$(JAVAC) $(JAVAC_FLAGS) $(MAINSRC)*.java
	$(JAVAC) $(JAVAC_FLAGS) *.java
	$(JVM) $(JAVAC_CP) $(TARGET) $(MAIN)


.PHONY: build clean run all