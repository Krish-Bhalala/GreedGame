# Make sure to clean the old compiled files before running new files
play: clean
	javac GreedGame.java
	java GreedGame

clean:
	rm -f *.class