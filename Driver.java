/*
 *  **      Title: Prototype - Level Generator v1.2
 *  ** Programmer: Lance Z Raju
 *  **       Date: 11/07/2017
 */

import java.util.*;
public class Driver {
    public static int ASboundary = 20;
    public static int MDboundary = 12;
    public static int operation = 0;
    public static int answer = 0;
    public static void main (String[] args){
        
        boolean winning = true;
        double levelNum = 1.1;
        
        
        while(winning){
            //Display level with levelNum; increment by 0.1 each loop run.
            System.out.println("Level "+ levelNum );    
            
            
            
            if (levelNum%0.5==0){
                ASboundary = ASboundary + 8;
                MDboundary = MDboundary + 2;
            }
            int question[]= generate(levelNum);
            answer = question[0];
            String toString = "" + question[0];
            
            if(operation == 1){
                for (int i = 1; i < question.length; i++){
                    answer = answer + question[i];
                    toString += " + " + question[i];
                }
            }
            else if(operation == 2){
                for (int i = 1; i < question.length; i++){
                    answer = answer - question[i];
                    toString += " - " + question[i]; 
                }
            }
            else if(operation == 3){
                for (int i = 1; i < question.length; i++){
                    answer = answer * question[i];
                    toString += " * " +question[i];
                }
            }
            else if(operation == 4){
                for (int i = 1; i < question.length; i++){
                    answer = answer / question[i];
                    toString += " / " + question[i];
                }
            }
            else{
                System.out.println("If Operation failed.");
            }
            System.out.println(toString);
            System.out.println("Answer should be :" + answer);
            Scanner s = new Scanner(System.in);
            int playerchoice = s.nextInt();
            if (answer == playerchoice){
                System.out.println("Win!");
            }
            else{
                System.out.println("LOSE!");
                winning = false;
            }
            
            //Call play. If player wins the level, winning continues.
            //winning = play(ASboundary);
            
            
            
            
            
            //Increment level
            levelNum = levelNum+0.1;
        }
        
        
    }
    
    public static boolean play(int range){
        
        
        
        
        
        
        return true;
   
    
    }
    public static int[] generate(double levelNum){
        Random rng = new Random();
        int temp = (int)levelNum*10;
        int equationSize = rng.nextInt(temp) +1;
        equationSize = equationSize/10 + 1;
        int x[] = new int[equationSize+1];
        System.out.println("Equation size : " + equationSize);
        
        //1 = add, 2 = subtract. 3 = mult, 4 = divide
        operation = rng.nextInt(4)+1;
       
        //generate question components. If 1 or 2, ASBoundary used. If 3 or 4, MDBoundary
        for(int i = 0; i < x.length; i++){
            if (operation ==1||operation == 2){
                x[i] = rng.nextInt(ASboundary)+1;
            }
            else{
                x[i] = rng.nextInt(MDboundary)+1;
            }
        }
 
        
        return x;
    }
}
