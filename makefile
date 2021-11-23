JAVAC = javac
JVM = java
JAVADOC = javadoc
MKBIN = mkdir -p bin

JAVAC_FLAGS = -Xlint -g -d 'bin/'
MAT_FLAGS = -Xlint -g
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
	$(JAVAC) $(JAVAC_FLAGS) $(MAIN).java

# clean the bin directory
# remove any serialized data
clean:
	rm -rf bin
	rm src/data/*.ser

# just run the main class
run:
	$(JVM) $(JAVAC_CP) $(TARGET) $(MAIN)

# compile and run the main class
all:
	$(MKBIN)
	$(JAVAC) $(JAVAC_FLAGS) $(MAINSRC)*.java
	$(JAVAC) $(JAVAC_FLAGS) $(MAIN).java
	$(JVM) $(JAVAC_CP) $(TARGET) $(MAIN)

# run Test.java, meant for testing temporary stuff
test:
	make build
	$(JAVAC) $(JAVAC_FLAGS) $(MAINTEST).java
	$(JVM) $(JAVAC_CP) $(TARGET) $(MAINTEST)

# run the main class in src
mat:
	$(JAVAC) $(MAT_FLAGS) src/*.java
	$(JAVAC) $(MAT_FLAGS) *.java
	$(JVM) $(MAIN)

reset:
	rm src/*.class
	rm src/data/*.ser

.PHONY: build clean run all test mat reset