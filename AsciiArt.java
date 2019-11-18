 
/*
Alexa N. Smith
COMP 163-002
Riley Porter
   
In this assignment, I am writing a program that creates an ASCII art that I created.
*/
public class AsciiArt {
   public static void main(String[] args) {
      triangle();
     
   }
   
   //outputs the upside down triangle
   public static void triangle() {
      for (int i = 1; i <= 8; i++) {
         
         for (int space = 1; space <= (i * 1 - 1); space++) {
            System.out.print(" ");
         }
         
         for (int triangle = 1; triangle <= (i * -1 + 9); triangle++) {
            System.out.print("<>");         
         }
         
         System.out.println();
      }
   }
 }
   
   


