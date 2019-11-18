/* 
 Alexa N. Smith
 COMP 163-002
 October 25, 2019

 This programs interacts with a user to create, view or quit a mad-lib story.
 If a user choses to create a file, the program will copy the text the user inputs
 into a new file. 
*/

import java.io.*;
import java.util.*;

public class MadLibs {
   public static void main(String[] args) throws FileNotFoundException {
      
      boolean madLibGame = true;
      // step 1: attach scanner to input file
      Scanner console = new Scanner(System.in);
      
      intro();
      
      while (madLibGame = true) {
         madLibGame = menu(console);
      }
   }
   
   // introduces the program to the user
   public static void intro() {
      System.out.println("Welcome to the game of Mad-Libs.");
      System.out.println("I will ask you to provide words");
      System.out.println("and phrases to fill in a story.");
      System.out.println("The result will be written to an output file.");
      System.out.println();
   }
   
   // prompts user to create, view, or quit a mad-lib game  
   public static boolean menu(Scanner console)throws FileNotFoundException {
      System.out.print("(C)reate mad-lib, (V)iew mad-lib, (Q)uit? ");
      String response = console.next();
      response = response.toLowerCase();
      if (response.charAt(0) == 'c') {
         create(console);
         return true;
      } else if (response.charAt(0) == 'v') {
         view(console);
         return true;
      } else if (response.charAt(0) == 'q') {
         return false;
      } else {
         return true;
      }
   }
   
   // step 2: method for view file  
   public static void view(Scanner console)throws FileNotFoundException {
      System.out.print("File name to view: ");
      String fileName = console.next();
      
      Scanner input = new Scanner(new File(fileName));
      while (input.hasNextLine()) {
         String text = input.nextLine();
         System.out.println();
         System.out.println(text);
      }
   }
   
   // step 3: method to create file
   public static void create(Scanner console) throws FileNotFoundException {
      System.out.print("Input file name: ");
      String inputFile = console.next();
      System.out.print("Output file name: ");
      String createOutput = console.next();
      String x = " ";
      
      // step 1: attach scanner to input file
      Scanner input = new Scanner(new File(inputFile));
      // step 2: look through the file to get each line
      PrintStream outputFile = new PrintStream(new File(createOutput));
      while (input.hasNextLine()) {
         // reads a single line from mad-lib
         String line = input.nextLine();
         Scanner tokens = new Scanner(line);
         // replace method to replace characters
         while (tokens.hasNext()) {
            String token = tokens.next();
            if (token.startsWith("<") && token.endsWith(">")) {
               //String anA = anA(x);
               token = token.replace('<',' ');
               token = token.replace('>',' ');
               token = token.replace('-',' ');
               
               char c = token.charAt(1);
               // prompts the user for a different prompt if the placeholder begins with a vowel               
               if (c == 'a'|| c == 'e'|| c == 'i' || c == 'o'||    
               c == 'u' || c == 'A' || c == 'E' || c == 'I'|| 
               c == 'O' || c == 'U') {
               
                  x = "an";
               }  else { 
                  x = "a";
               }
            
               System.out.print("Please type " + x + token);
               String word = console.next();
               // output word to file
               outputFile.print(word + " ");
              
            } else { // output other tokens without <> to file
               outputFile.println(token + " ");   
            } 
         }
      }
      System.out.println("Your mad-lib has been created!");
      System.out.println();
   }
}
