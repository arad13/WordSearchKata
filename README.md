# WordSearchKata

WordSearchKata is a java program to designed to solve the Word Search problem defined at: https://github.com/PillarTechnology/kata-word-search

# Building The Program

Generate the program by running compileWordSearchKata.bat located in the RoodCodeLocation\src directory

# Executing the Program

To run the program, run the following command from the command line/terminal:
    RootCodeLocation\src> java -jar WordSearcher.jar

When run, the program asks for a single input - the file directory with the location of the desired word search problem file to be solved.

The output will contain the results for each provided word on a separate line, with the coordinates of each letter beginning with the first of the word.
Coordinates are of the form (x-axis, y-axis) with (0,0) being the top left corner of the letter grid.

# Executing Tests

To run the tests in junit, first download junit from:
    https://github.com/downloads/junit-team/junit/junit-4.10.jar

Next, navigate to the RootCodeLocation folder in a command-line\terminal.
Execute the following commands:
   set CLASSPATH=%JUnit Location%\junit-4.10.jar;%RootCodeLocation%\src;%RootCodeLocation%\tests;

Navigate to the \tests folder and execute:
   javac WordSearchTests.java

Navigate back to the root folder and execute:
   java org.junit.runner.JUnitCore WordSearchTests.java