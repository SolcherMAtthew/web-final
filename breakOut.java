import javax.swing.*;
import java.awt.*;
import java.awt.AWTEvent;
import java.awt.Color;
import java.awt.MouseInfo;
import java.util.concurrent.TimeUnit;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.util.Random;
import java.awt.event.KeyListener;
import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.awt.FontMetrics;



public class breakOut extends JFrame{
   public breakOut(){
      setSize(2600,2600);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setLocationRelativeTo(null);
      setVisible(true);
   }

   public static void main(String a[]){
      new breakOut();
   }

   public void paint(Graphics g){
      int XMove=0;
      int YMove=1;
      int ballX = 900;
      int ballY = 700;
      int life = 3;
      
      
      
      Color redish = new Color(255,10,10);
      Color black = new Color(1,1,1);
      Color green = new Color(10,100,10);
                
                     
      int i = 0;                            
      int run = 1;
      int row = 1;
      int[] runArray;
      int[] rowArray;
      Rectangle[] rectArray;
      
      rectArray = new Rectangle[99];
      runArray = new int[12];
      rowArray = new int[12];
   
      runArray[0] = 1;
      rowArray[0] = 1;
      
   
            
                
            
      while(run<12){    
                      
        // if ((row + run) % 2==0){
         
         g.setColor(black);
         runArray[run] = (run-1) * 100 + 10;
         rowArray[row] = 50 * row - 25;
         Rectangle r = new Rectangle(runArray[run], rowArray[row],100,50);
         i = i+1;
          
         g.drawString(String.valueOf(i),runArray[run],rowArray[row]);
      
         g.setColor(green);
         g.fillRect (runArray[run],rowArray[row], 100, 50);
        // }
        // else{
          //  g.setColor(redish);
           // g.fillRect(  ((run-1) * 100 + 10), (50 * row-25), 100,50);
           // Rectangle r = new Rectangle( ((run-1) * 100 + 10), (50 * row-25), 100,50);
            //int n = i+1;
            //rectArray[i] = r;
         
                   
                  
         //}  
         g.setColor(black);
               
               //    FontMetrics fm = g.getFontMetrics();
               //   int  w = fm.stringWidth("F:");
               // int h = fm.getAscent();
               //g.drawString(" "+run * row, run * 50, 50 * row + (h/4));
         run=run+1;
         if(run%11==0){
            row=row+1;
            run=1;
            if (row == 11){
               run=12;
            }
               
            
             
         }
      
             
      }
      while(life > 0)
      {
         
         try{
            
            TimeUnit.MILLISECONDS.sleep(3);
            Random r = new Random();
            int R = r.nextInt(255-1) + 1;
            int G = r.nextInt(255-1) + 1;
            int B = r.nextInt(255-1) + 1;
            
            double mouseX = MouseInfo.getPointerInfo().getLocation().getX();
            double mouseY = MouseInfo.getPointerInfo().getLocation().getY();
            int X = (int)mouseX;
            int Y = (int)mouseY;
            if (X < 910){
                  
               g.setColor(redish);
               g.fillRect(X, 920, 90, 10); 
               
               Color white = new Color(255,255,255);
               g.setColor(white);
               g.fillRect(X+95, 920, 1000, 10); 
               g.fillRect(X-1000, 920, 1000, 10); 
            }
            Color randomColor = new Color(R,G,B);
            g.setColor(randomColor);
            g.fillOval(ballX, ballY, 20,20);
            ballX=ballX+XMove;
            ballY=ballY+YMove;
            
            if (ballY>899 && ballY<910){
               if (ballX> X-20 && ballX< X+110){
                  YMove = -1;
                  XMove = ((ballX - X)/10)-4;
               }
               
               if (ballX< X-20 || ballX> X+110){
                  life=life-1;
                  ballX = X+45;
                  ballY = 890;
                  XMove=  0;
                  YMove= -1;     
               }
            }
            if (ballX>1010){
               
               ballX = 500;
               ballY = 890;
               XMove=  0;
               YMove= -1;     
            }
            
            
            if (ballY<20){
               YMove = 1;
            }
            
            if (ballX<0){
               XMove =XMove * -1;
            }
            if (ballX>1000){
               XMove =XMove * -1;
            }
            if(XMove == 0 && YMove == 1){
               YMove=2;
            }
            if(XMove == 0 && YMove == -1){
               YMove=-2;
            }
            
            if(ballY<1451){
            
            
               int n = (ballX/100+1) + ((ballY/50 )*10); 
               g.drawString(String.valueOf(n),50,50);
               
            
            
               if (n<101){
                  Color white = new Color(255,255,255);
               
                  g.setColor(white);
                  g.fillRect(rectArray[n].x,rectArray[n].y,100,50);
                
               
               }
            }
         }
         
            
            
         catch(InterruptedException ex){
            Thread.currentThread().interrupt();
            
         }
      
      }     
      
   }
}
