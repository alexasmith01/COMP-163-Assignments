/*
Alexa N. Smith
9/23/19
Riley Porter
COMP 163-002

This program codes for the famous Cafe Wall illusion.

*/ 

import java.awt.*;

public class CafeWall {

   public static final int MORTAR = 2;

   public static void main(String[] args){
      DrawingPanel panel = new DrawingPanel(650, 400);
      panel.setBackground(Color.GRAY);
      Graphics g = panel.getGraphics();
      
      drawRow(g, 0, 0, 20, 4, 0);
      drawRow(g, 50, 70, 30, 5, 0);
      
      drawGrid(g, 10, 150, 25, 4, 0);
      drawGrid(g, 250, 200, 25, 3, 10);
      drawGrid(g, 425, 180, 20, 5, 10);
      drawGrid(g, 400, 20, 35, 2, 35);     
   }
  
   
 //draws each row of box pairs according to their sizes
   public static void drawRow(Graphics g, int x, int y, int size, int pairs, int offset) {
      for (int i = 1; i <= pairs;  i++) {
         g.setColor(Color.BLACK);
         g.fillRect(x + 2 * size * (i - 1), y, size, size);
      
         g.setColor(Color.BLUE);
         g.drawLine(x + 2 * size * (i - 1), y, x + size * (2 * i - 1), y + size);
         g.drawLine(x + size * (2 * i - 1), y, x + 2 * size * (i - 1), y + size);
      
         g.setColor(Color.WHITE);
         g.fillRect(x + size * (2 * i - 1), y, size, size);
      }  
   }
 
 //draws a sing grid of rows based off of the row method
   public static void drawGrid(Graphics g, int x, int y, int size, int pairs, int offset) {
      for (int i = 0; i < pairs * 2; i++) {
         drawRow(g, x + offset *(i % 2), y + (size * i) + MORTAR + i, size, pairs, offset);
      }
   }
} 

        
   
