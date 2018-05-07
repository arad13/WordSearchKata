@echo off
javac main.java InputParser.java WordSearcher.java
jar -cfm WordSearcher.jar manifest.txt main.class InputParser.class WordSearcher.class WordSearcher$FoundType.class
