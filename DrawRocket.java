/* 
Alexa Smith
COMP 163-002
Riley Porter


This program will code for a drawing of a rocketship, 
and will be able to scale sizes from 3 to 6.
*/

public class drawRocket {
   public static final int SCALE = 10;
   
   public static void main(String[] args){
      rocketNose();
      line();
      topHalf();
      bottomHalf();
      line();
      bottomHalf();
      topHalf();
      line();
      rocketNose();
   }
      
//outputs the nose of the rocket
   public static void rocketNose() {
      for (int i = 1; i <= (SCALE * 2 - 1); i++) {
      
         for (int space = 1; space <= (i * -1 + 2 * SCALE); space ++) {
            System.out.print(" ");
         }
      
         for (int forwardSlash = 1; forwardSlash <= i; forwardSlash++) {
            System.out.print("/");
         }
         
         System.out.print("**");
         
                  
         for (int backSlash = 1; backSlash <= i; backSlash++) {
            System.out.print("\\");
         }
         
         System.out.println();                
      } 
   }
//outputs line in the mid-section of the rocket body
   public static void line() {
      for (int i = 1; i <= 1; i++) {
         System.out.print("+");
         
      for (int line = 1; line <= SCALE * 2; line++) {
         System.out.print("=*");
      }
      
      System.out.println("+");
      
      }
   }
//outputs the top half of the rocket body
   public static void topHalf() {
      for (int i = 1; i <= SCALE; i++) {
         System.out.print("|");
         
         for (int dot = 1; dot <= (i * -1 + SCALE); dot++) {
            System.out.print(".");
         }
            
         for (int pyramid = 1; pyramid <= i; pyramid++) {
            System.out.print("/\\");
         }
         
         for (int dot = 1; dot<= (i * -2 + 2 * SCALE); dot++){
            System.out.print(".");
            
         }
         for (int pyramid = 1; pyramid <= i; pyramid++) {
            System.out.print("/\\");
         }
         
         for (int dot = 1; dot <= (i * -1 + SCALE); dot++) {
            System.out.print(".");
         }
         
         System.out.println("|");
      }  
   }
   
//outputs the bottom half of the rocket body
//same at the top half but in reverse order
   public static void bottomHalf() {
      for (int i = SCALE; i >= 1; i--) {
         System.out.print("|");
         
         for (int dot = 1; dot <= (i * -1 + SCALE); dot++) {
            System.out.print(".");
         }
         
         for (int pyramid = 1; pyramid <= i; pyramid++) {
            System.out.print("\\/");
         }
         
         for (int dot = 1; dot <= (i * -2 + 2 * SCALE); dot++) {
            System.out.print(".");
         }

         for (int pyramid = 1; pyramid <= i; pyramid++) {
            System.out.print("\\/");
         }
         
         for (int dot = 1; dot <= (i * -1 + SCALE); dot++) {
            System.out.print(".");
         }

         System.out.println("|");
      }
   }
}
 

   

