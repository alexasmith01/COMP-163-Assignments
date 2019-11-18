/* 
Alexa Smith
COMP 163-002
Riley Porter
November 4, 2019


This program takes a DNA input file from the user and calculates 
the amount of nucleotides, their molar mass, and each nucleotide's
percentage in the mass. Once the data is calculated, it is printed
in an output file created by the user. 

*/

import java.util.*;
import java.io.*;

public class DNA {

   public static final int DNA = 4;
   //public static final int JUNK = 5;
   public static final int JUNK = 1;
   
   public static void main(String[] args) throws FileNotFoundException {
      Scanner console = new Scanner(System.in);
      
      // introduces the program to the user
      System.out.println("This program reports information about DNA");
      System.out.println("nucleotide sequences from an input file.");
      System.out.print("Input file name? ");
      String inputFile = console.next();
      System.out.print("Output file name? ");
      String output = console.next();
      
      Scanner input = new Scanner(new File(inputFile));
      PrintStream outputFile = new PrintStream(new File(output));
      int dash = 0;
      double[] dnaMass = new double[DNA];
      
      
      while (input.hasNextLine()) {
         String region = input.nextLine();
         String nucleotides = input.nextLine().toUpperCase();
         // process each nucleotide
         int[] dnaAmount = parseDNA(nucleotides);
         // calculates amount of dashes/junk in each DNA list
         double junkCount = junkTotal(nucleotides);
         // calculates the mols of each DNA nucleotide
         double[] dnaMol = totalMass(dnaAmount);
         // calculates mass of the DNA
         double dnaSum = sum(dnaMol, junkCount);
         // converts the DNA mols to percentages out of the mass 
         double[] massPer = massPercent(dnaMol, dnaSum);
         // outputs data to separate file given by the user
         output(region, nucleotides, outputFile, dnaAmount, dnaSum, massPer);
         
      }
   
   }
   
   // parses DNA sequence Stringinto an array of counts for the four nucleotides
   public static int[] parseDNA(String nucleotides) { // int dash
      int[] dnaCount = new int[DNA];
      
      for (int i = 0; i < nucleotides.length(); i++) {
         char nextChar = nucleotides.charAt(i);
          // count each nucleotide
         if (nextChar == 'A') {
            dnaCount[0]++;
         } else if (nextChar == 'C'){
            dnaCount[1]++;
         } else if (nextChar == 'G') {
            dnaCount[2]++;
         } else if (nextChar == 'T') {   
            dnaCount[3]++;
         } else { // nextChar == '-'
            junkTotal(nucleotides);
            // return junk amount in another method
         }
      }  
      return dnaCount;
   }
   
   // counts the junk (-) in the line of DNA
   // junk has a molar mass of 100.00 per (-)
   public static int junkTotal(String nucleotides) {
      int dash = 0;
      for (int i = 0; i < nucleotides.length(); i++) {
         char nextDash = nucleotides.charAt(i);
         
         if (nextDash == '-') {
            dash++;
         }
      }
      return dash;
   }
   
   // computes the total mass for a DNA sequence
   public static double[] totalMass(int[] dnaAmount) { 
      double A = 135.128; // molar mass for each nucleotide
      double C = 111.103;
      double G = 151.128;
      double T = 125.107;
      double J = 100.00;
      
      double[] dnaMass = new double[DNA];
      dnaMass[0] = dnaAmount[0] * A;
      dnaMass[1] = dnaAmount[1] * C;
      dnaMass[2] = dnaAmount[2] * G;
      dnaMass[3] = dnaAmount[3] * T;
      
      return dnaMass;
   }
   
   // computes the sum (rounded to the tenth place)
   public static double sum(double[] dnaMol, double junkCount) {
      double sum = dnaMol[0] + dnaMol[1] + dnaMol[2] + dnaMol[3] + (junkCount * 100.00);
      sum = Math.round(sum * 10.0) / 10.0;
      return sum;
   }
   
   // computes the mass percent of each nucleotide and stores in an array
   // rounded percentages to the tenth place
   public static double[] massPercent(double[] dnaMol, double dnaSum) {
      double[] dnaRound = new double[DNA];
      for (int i = 0; i < dnaMol.length; i++) {
         dnaRound[i] = (dnaMol[i] / dnaSum) * 100.0;
         dnaRound[i] = Math.round(dnaRound[i] * 10.0) / 10.0;
      }
      return dnaRound;
   } 
   
   // prints data to output file
   public static void output(String region, String nucleotides, PrintStream outputFile, 
                             int[] dnaAmount, double dnaSum, double[] massPer) {
      outputFile.println("Region Name: " + region);
      outputFile.println("Nucleotides: " + nucleotides);
      outputFile.println("Nuc. Counts: " + Arrays.toString(dnaAmount));
      outputFile.println("Total Mass%: " + Arrays.toString(massPer) + " of " + dnaSum);
      outputFile.println();
   }
}

