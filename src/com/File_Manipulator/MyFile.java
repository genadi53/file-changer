package com.File_Manipulator;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

import javax.servlet.ServletException;

public class MyFile{
    String filePath  =  null;
    List<String> lines;

    public MyFile(String filePath) throws IOException {
        this.filePath = filePath;
        
        // Read all rows/lines in the file and save them to a list
        lines = Files.readAllLines(Path.of(filePath), StandardCharsets.UTF_8);
    }
  
    // First finds the two lines/rows chosen by the user and splits them to array of Strings
    // then finds searched words and swaps their places and save changes
    public void swapWords(int line1, int line2, int word1Position, int word2Position) throws IOException, CustomException {
    	  String contentOfLine1 = findLine(line1);
          String contentOfLine2 = findLine(line2);

          String[] arrayOfWords1 = contentOfLine1.split(" ");
          String[] arrayOfWords2 = contentOfLine2.split(" ");

          String searchedWord1 = findWord(arrayOfWords1,word1Position);
          String searchedWord2 = findWord(arrayOfWords2,word2Position);


          if(line1 != line2){

              arrayOfWords1[word1Position-1] = searchedWord2;
              System.out.println(arrayOfWords1[word1Position-1]);
              arrayOfWords2[word2Position-1] = searchedWord1;
              System.out.println(arrayOfWords2[word2Position-1]);

              lines.set(line1-1,makeString(arrayOfWords1));
              lines.set(line2-1,makeString(arrayOfWords2));
              Files.write(Path.of(filePath), lines, StandardCharsets.UTF_8);

          } else {
              arrayOfWords1[word1Position-1] = searchedWord2;
              System.out.println(arrayOfWords1[word1Position-1]);
              arrayOfWords1[word2Position-1] = searchedWord1;
              System.out.println(arrayOfWords1[word2Position-1]);

              lines.set(line1-1,makeString(arrayOfWords1));
              Files.write(Path.of(filePath), lines, StandardCharsets.UTF_8);
          }


    }

    // Creates one String from given an array of Strings
    private String makeString(String[] words) throws CustomException{
        StringBuilder string = new StringBuilder();

        if(words.length == 0) {   
        	throw new CustomException("The line have no content.");   
        }
        
        for (int i = 0; i < words.length; i++){
            string.append(" ").append(words[i]);
        }
        string.deleteCharAt(0);
        return string.toString();
    }

    // Search array full of Strings for a word with specific position and if it finds it - return it.
    private String findWord(String[] words, int position) throws CustomException{
    	
    	if(position > words.length) {
        	throw new CustomException("The line have less words.");   
    	}
    	
        for(int i = 0; i < words.length; i++){
            if(i == position-1){
                System.out.println(words[i]);
                return words[i];
            }
        }
        return null;
    }

    // Search for a line by given number(Position of the line in file) then reads all lines from the file
    // until coming to the specific number and returning a String from content of the line.
    private String findLine(int lineNumber) throws IOException, CustomException {
        int lineCounter = 1;
        String searchedLine = null;
      
        if(lineNumber > lines.size()) {  
        	throw new CustomException("No line with number " + lineNumber);   
        }
        
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String lineContent = scanner.nextLine();
                //System.out.println(data);
                if(lineCounter == lineNumber){
                    searchedLine = lineContent;
                }
                lineCounter++;
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error 404 - File not found.");
            e.printStackTrace();
        }
       
        return searchedLine;
    }

    // By given two numbers(Positions of lines/rows in the file) finds their positions by calling findLine method 
    // and then swap their places and saves the changes
    public void swapLines(int line1, int line2) throws IOException, CustomException {

        String searchedLine1 = null;
        String searchedLine2 = null;

        searchedLine1 = findLine(line1);
        searchedLine2 = findLine(line2);

        lines.set(line1-1 , searchedLine2);
        lines.set(line2-1 , searchedLine1);
        Files.write(Path.of(filePath), lines, StandardCharsets.UTF_8);
    }

    
    // Create a String, which will be displayed to the user on the web page
    public String printFile() throws FileNotFoundException {
        File file = new File(filePath);
        StringBuilder fileContent = new StringBuilder((int)file.length());
        Scanner scanner = new Scanner(file);
        
            while(scanner.hasNextLine()) {
                fileContent.append(scanner.nextLine() + System.lineSeparator()).append("<br>"); 
            }	
            return fileContent.toString();
    }

	

}


