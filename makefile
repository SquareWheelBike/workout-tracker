JAVAC = javac
JVM = java
JAVADOC = javadoc
MKBIN = mkdir -p bin

JAVAC_FLAGS = -g -d 'bin/'
JAVAC_CP = -cp

MAINSRC = src/
TARGET = bin

MAIN = Workout
MAINTEST = Test

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

# run Test.java, meant for testing temporary stuff
test:
	$(JVM) $(JAVAC_CP) $(TARGET) $(MAINTEST)

# run the main class in src
mat:
	$(JAVAC) src/*.java
	$(JAVAC) $(MAIN).java
	$(JVM) $(MAIN)

#delete the user data and compile files
reset:
	$(JAVAC) src/*.java
	$(JAVAC) $(MAIN).java
	$(JVM) $(MAIN)

.PHONY: build clean run all test