package wordPlay.driver;

import wordPlay.util.FileProcessor;
import wordPlay.util.Results;
import java.io.IOException;

import wordPlay.handler.WordRotator;
import wordPlay.metrics.MetricsCalculator;

/**
 * @author John Doe
 *
 */
public class Driver {
	public static void main(String[] args) throws IOException {

		/*
		 * As the build.xml specifies the arguments as input,output or metrics, in case the
		 * argument value is not given java takes the default value specified in
		 * build.xml. To avoid that, below condition is used
		 */
		if ((args.length != 3) || (args[0].equals("${input}")) || (args[1].equals("${output}")) || (args[2].equals("${metrics}"))) {
			System.err.println("Error: Incorrect number of arguments. Program accepts 3 arguments.");
			System.exit(0);
		}

		/*
		 * Create object of class FileProcessor and Results
		 * path of input.txt, output.txt and metrics.txt is passed
		 * as argument to objects created
		 * */
		FileProcessor fp = new FileProcessor(args[0]);
		Results newFile = new Results(args[1]);
		Results metricsFile = new Results(args[2]);

		try {
			String word;
			StringBuilder text = new StringBuilder();
			int count=1;
			float wordCounter=0, lineCount=0, totalCharCount=0, avgWordCount=0;

			MetricsCalculator ms = new MetricsCalculator();

			while((word = fp.poll())!=null){
				WordRotator wr = new WordRotator(word);
				String rev = wr.revString(count);
				text.append(rev).append(" ");

				/*
				 * Check if word contains a period to start new line
				 * */
				if(word.contains(".")) {
					count = 1;
					text.append('\n');
					lineCount = lineCount + 1;
					word = word.substring(0,word.length()-1);
				}
				else {
					count = count + 1;
				}

				totalCharCount = totalCharCount + word.length();
				wordCounter = wordCounter + 1;
			}

			/* Calculate average words per sentence
			 * */
			avgWordCount = ms.avgWordPerSentence(wordCounter,lineCount, 2);
			/* Calculate average character count per sentence
			 * */
			totalCharCount = ms.avgCharCount(totalCharCount, wordCounter,2);

			/* Print output to Console
			 * */
			newFile.addNewlineToConsole();
			newFile.printToConsole(text.toString());
			/* write to output.txt
			 * */
			newFile.addOutputToFile(text.toString());

			/* Print output to Console
			 */
			metricsFile.printToConsole("AVG_NUM_WORDS_PER_SENTENCE: "+avgWordCount);
			metricsFile.printToConsole("AVG_WORD_LENGTH: "+totalCharCount);
			/* write to output.txt
			 */
			metricsFile.addOutputToFile("AVG_NUM_WORDS_PER_SENTENCE: "+avgWordCount+"\nAVG_WORD_LENGTH: "+totalCharCount);
			metricsFile.addNewLineToFile();
		}
		catch(Exception e) {
			e.getMessage();
			System.out.println(e);
		}
		finally {
			/* Close all files
			 */
			newFile.fc();
			metricsFile.fc();
		}
	}
}