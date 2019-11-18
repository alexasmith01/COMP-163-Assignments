/*Alexa Smith
COMP 163, Section 2

This program prints the words to a famous nursery rhyme.*/

public class SongAssignment {
   public static void main(String[] args) {
      firstLine();
      System.out.print(" fly.");
      System.out.println();
      lastLine();
      spider();
      verseOne();
      bird();
      verseTwo();
      cat();
      verseThree();
      dog();
      verseFour();
      mouse();
      verseFive();
   }
   
   public static void firstLine() {
      System.out.print("There was an old woman who swallowed a");
   }
   
   public static void lastLine() {
      System.out.println("I don't know why she swallowed that fly,");
      System.out.println("Perhaps she'll die.");
      System.out.println();
   }
   
   public static void spider() {
      firstLine();
      System.out.print(" spider,");
      System.out.println("\nThat wriggled and iggled and jiggled inside her.");
   }
   
   public static void verseOne() {
      System.out.println("She swallowed the spider to catch the fly,");
      lastLine();
   }
   
   public static void bird() {
      firstLine();
      System.out.print(" bird,");
      System.out.println("\nHow absurd to swallow a bird.");
   }
   
   public static void verseTwo() {
      System.out.println("She swallowed the bird to catch the spider,");
      verseOne();
   }
 
   public static void cat() {
      firstLine();
      System.out.println(" cat,");
      System.out.println("Imagine that to swallow a cat.");
   }
   
   public static void verseThree() {
      System.out.println("She swallowed the cat to catch the bird,");
      verseTwo();
   }
      
   public static void dog() {
      firstLine();
      System.out.print(" dog,");
      System.out.println("\nWhat a hog to swallow a dog.");
   }
   
   public static void verseFour() {
      System.out.println("She swallowed the dog to catch the cat,");
      verseThree();
   }
   
   public static void mouse() {
      firstLine();
      System.out.print(" mouse,");
      System.out.println("\nA poor mouse that came into the house.");
   }
   
   public static void verseFive() {
      System.out.println("She swallowed the mouse to catch the dog,");
      verseFour();
      firstLine();
      System.out.print(" horse,");
      System.out.println("\nShe died of course.");
   }
}