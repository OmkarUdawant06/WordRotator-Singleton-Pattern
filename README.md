# CSX42: Assignment 1
## Name: Omkar Udawant

-----------------------------------------------------------------------
-----------------------------------------------------------------------


Following are the commands and the instructions to run ANT on your project.
#### Note: build.xml is present in wordPlay/src folder.

-----------------------------------------------------------------------
## Instruction to clean:

####Command: ant -buildfile wordPlay/src/build.xml clean

Description: It cleans up all the .class files that were generated when you
compiled your code.

-----------------------------------------------------------------------
## Instruction to compile:

####Command: ant -buildfile wordPlay/src/build.xml all

Description: Compiles your code and generates .class files inside the BUILD folder.

-----------------------------------------------------------------------
## Instruction to run:

####Command: ant -buildfile wordPlay/src/build.xml run -Dinput="input.txt" -Doutput="output.txt" -Dmetrics="metrics.txt"

Note: Arguments accept the absolute path of the files.


-----------------------------------------------------------------------
## Description:

I have tried to implement all functions efficiently but my code is still not 100% optimized. I have followed guidelines to write good variable names so that it is easy for client to understand what the variable is used for. Given proper comments where ever required for better understanding of code.

Driver.java- This file contains main method which creates object for Fileprocessor class and Results class for accessing input.txt, output.txt and metrics.txt files respectively. Driver class mainly contains call to functions such as rotating words in a sentence, calculating average word length and average number of words per sentence.try catch and finally block are written where code is most likely to produce exception. At the end of try block, output is written to respective files. After performing operations on files, they are closed in finally block.

WordRotator.java- This class accepts word from input file and rotates it to right side depending on the index position of each word in a sentence. It accepts word, calculates its length and checks if the word contains a period or not. If it does not contain a period, the word is rotated using for loop which iterates until the location/position of word in sentence. The character is shifted in circular manner. And then the ouput i.e. rotated word is returned. If the word contains a period, the string is trimmed from its tail using substring method, and a boolean flag is set to true which indicates that a period occured. Then again circular shift is performed on string. After modified string is calculated, code checks if flag was set(true) or unset(false). If flag is set, return statement adds period at the end of string, else it returns the modified string.

MetricsCalculator.java- This class file is used to calculate the average of words per sentence in input.txt file and average word length. It contains two methods avgWordPerSentence and avgCharCount. Along with these methods, I have written a method to round float value upto 2 decimal places.

Results.java- This class is a helper class for other java classes. I have written methods such as opening file, writting file, printing to console, closing file, adding new line or spaces to Console as well as output file in this class. Results class is extended from StdoutDisplayInterface class and FileDisplayInterface class.      

No Data Structure used in this project.
Comments are given as per javadoc style.  
-----------------------------------------------------------------------
### Academic Honesty statement:
-----------------------------------------------------------------------

"I have done this assignment completely on my own. I have not copied
it, nor have I given my solution to anyone else. I understand that if
I am involved in plagiarism or cheating an official form will be
submitted to the Academic Honesty Committee of the Watson School to
determine the action that needs to be taken. "

Date: 6-10-2020


