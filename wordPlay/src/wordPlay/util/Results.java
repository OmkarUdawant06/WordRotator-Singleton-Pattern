package wordPlay.util;

import java.io.IOException;
import java.io.FileWriter;
import java.io.File;

public class Results implements StdoutDisplayInterface, FileDisplayInterface{

    File fp;
    FileWriter opfile;

    public Results(String fname) {
        try {
            fp = new File(fname);
            opfile = new FileWriter(fp);
        } catch (IOException e) {
            e.getMessage();
            System.out.println(e);
        }
    }

    /**
     * Prints output to console
     */
    public void printToConsole(String text)
    {
        System.out.println(text+" ");
    }

    /**
     * Add a new line after previous line is processed
     */
    public void addNewlineToConsole() {
        System.out.print("\n");
    }

    /**
     * Write the output in a File
     */
    public void addOutputToFile(String text) {
        try {
            if(fp.length() == 0) {
                opfile = new FileWriter(fp, false);
            }
            else {
                opfile = new FileWriter(fp, true);
            }
            opfile.write(text + " ");
        } catch (IOException e) {
            e.getMessage();
            System.out.println(e);
        }
    }

    /**
     * Add new line to output in a File
     */
    public void addNewLineToFile() {
        try {
            if(opfile.toString().isEmpty())
                opfile.write("\n");
            else
                opfile.append("\n");
        } catch (IOException e) {
            e.getMessage();
            System.out.println(e);
        }
    }

    /**
     * To close the opened File
     */
    public void fc() {
        try {
            opfile.close();
        } catch(IOException e) {
            e.getMessage();
            System.out.println(e);
        }
    }

}
