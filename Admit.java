/*
Alexa N. Smith
COMP 163-002
Riley Porter
September 30, 2019

This program will prompt the user for information 
about two applicants and compute an overall
score for each applicant. 
*/

import java.util.*;

public class Admit {
   public static void main(String[] args) {
      giveIntro();
      Scanner console = new Scanner(System.in);
    
      System.out.println("Information for applicant #1:");
      double testInfor1 = getTest(console); 
      double gpaScore1 = gpaInfo(console);
     
      System.out.println();
     
      System.out.println("Information for applicant #2:");
      double testInfor2 = getTest(console);
      double gpaScore2 = gpaInfo(console);
      
      scoreComparison (gpaScore1, gpaScore2, testInfor1, testInfor2);
      
   }
   
   // Introduces program to the user
   public static void giveIntro() {
      System.out.println("This program compares two applicants to");
      System.out.println("determine which one seems like the stronger");
      System.out.println("applicant. For each candidate I will need");
      System.out.println("either SAT or ACT scores plus a weighted GPA.");
      System.out.println();
      
   }
   
   //uses the console Scanner to prompt applicant's information about test scores
   public static double getTest(Scanner console){
      System.out.print("\tdo you have 1) SAT scores or 2) ACT scores? ");
      int type = console.nextInt();
      double examScore;
      
      if (type == 1) { // SAT score
         System.out.print("\tSAT math? ");
         double math = console.nextInt();
          
         System.out.print("\tSAT critical reading? ");
         double satReading = console.nextInt();
          
         System.out.print("\tSAT wrtiting? ");
         double writing  = console.nextInt();  
         
         examScore = (2 * math + satReading + writing) / 32;
         System.out.print("\texam score = " + round1(examScore));
         
         System.out.println();
         
         return examScore;
      } 
      if (type == 2) { // ACT score
         System.out.print("\tACT English? ");
         double english = console.nextInt();
         
         System.out.print("\tACT math? ");
         double actMath = console.nextInt();
         
         System.out.print("\tACT reading? ");
         double actReading = console.nextInt();
         
         System.out.print("\tACT science? ");
         double science = console.nextInt();
         
         examScore = (english + 2 * actMath + actReading + science) / 1.8;
         System.out.print("\texam score = " + round1(examScore)); 
         
         System.out.println();
         
         return examScore;
      } 
      return type;
   }
       
  // asks more questions about the user's GPA
  // returns gpaScore 
   public static double gpaInfo(Scanner console) {
      System.out.print("\toverall GPA? ");
      double overallGPA = console.nextDouble();
          
      System.out.print("\tmax GPA? ");
      double maxGPA = console.nextDouble();
          
      System.out.print("\tTranscript Multiplier? ");
      double transcriptMulti = console.nextDouble();
      
      double gpaScore = gpaFor(overallGPA, maxGPA, transcriptMulti);
      System.out.print("\tGPA score = " + round1(gpaScore));
      
      System.out.println();
      
      return gpaScore;
   }
   
   // returns the GPA Score
   public static double gpaFor(double overallGPA, double maxGPA, double transcriptMulti) {
      return (overallGPA / maxGPA) * 100 * transcriptMulti;
      
   }
   
   // returns the result of rounding n to 1 digit after the decimal point
   public static double round1(double n) {
      return Math.round(n * 10.0) / 10.0;
   }
   
   // calculates the overall score of the applicants
   // reports the results
   public static void scoreComparison (double gpaScore1,double gpaScore2, double testInfor1, double testInfor2) {
      double overallScore1 = testInfor1 + gpaScore1;
      double overallScore2 = testInfor2 + gpaScore2;
      System.out.println();
      System.out.println("First applicant overall score = " + round1(overallScore1));
      System.out.println("Second applicant overall score = " + round1(overallScore2));
      
      if(overallScore1 > overallScore2) {
         System.out.println("The first applicant seems to be better");
      } else if (overallScore1 < overallScore2) {
         System.out.println("The second applicant seems to be better");
      } else { //the overall scores are equal
         System.out.println("The two applicants seem to be equal");
      }
   }

}