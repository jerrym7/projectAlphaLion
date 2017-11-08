/*
 *  **      Title: Prototype - Level Generator v1.25
 *  ** Programmer: Lance Z Raju
 *  **       Date:
 */

import java.util.*;
public class Driver {
    //==========================================================================
    //==========================================================================
    // ASboundary::int - represents maximum value from [0 to ASBoundary-1) for addition 
    //                  and subtraction values in a level
    // MDBoundary::int - same idea as ASBoundary, but for multiplying/dividing.
    // operation::int - determine operation used; add=1, subtract=2, multiply =3,
    //                  divide = 4
    // answer:: int - the answer.
    //==========================================================================
    //==========================================================================
    public static int ASboundary = 20;
    public static int MDboundary = 12;
    public static int operation = 0;
    public static int answer = 0;
	public static int lives =3;
    public static Random RNG = new Random();
    public static void main (String[] args){
        
        
        
        // Although levelNum is used for displaying, it also decides how big a
        // problem will be, and also how big the numbers will be.
        double levelNum = 1.1;
        
        
        //Continue loop while player is winning. Starts off true, because
        // the player is already winning by choosing our amazing game.
        boolean winning = true;
        while(lives>0){
            //Display level with levelNum; increment by 0.1 each loop run.
            System.out.println("Level "+ levelNum );    
            
            
            //Difficulty mechanic. Level multiples of 0.5 (level 1.5, 2.0, 2.5..)
            // will have larger boundaries, which means larger numbers potentially
            if (levelNum%0.5==0){
                ASboundary = ASboundary + 15;
                MDboundary = MDboundary + 2;
            }
            
            // Call generate, which creates an array of unique, random numbers
            // to be used in a question.
            int question[]= generate(levelNum);
            answer = question[0];
            
            //toString will be the output, modified based on operation (+, -, *, /)
            String toString = "" + question[0];
            
            //Adding 
            if(operation == 1){
                //Note: each for-loop starts at value 1, because the first value MUST be added
                // to the 'answer'. Otherwise, you end up subtracting answer (which is 0)
                // by all the values in the question.
                for (int i = 1; i < question.length; i++){
                    answer = answer + question[i];
                    toString += " + " + question[i];
                }
            }
            //Subtracting
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
                //fail-case. wont occur though
                System.out.println("If Operation failed.");
            }
            //display question
            System.out.println(toString);
            // Rusty answer generator, but it does create a unique positioning
            // system for each answer. Could be improved if deviation formula is
            // used for 'wrong' answers added to the list.
            ArrayList <Integer> allAnswers = new ArrayList<Integer>();
            allAnswers.add(answer);
            allAnswers.add(answer + 1);
            allAnswers.add(answer - 1);
            allAnswers.add(answer +10);

            int pick = 0;
            while (!allAnswers.isEmpty()){
                pick = RNG.nextInt(allAnswers.size());
                System.out.println("\t" + allAnswers.remove(pick));
            }
            Scanner s = new Scanner(System.in);
            int playerchoice = s.nextInt();
            if (answer == playerchoice){
                System.out.println("Win!");
            }
            else{
				lives--;
                System.out.println("Lost a life");
            }
            
            levelNum = levelNum+0.1;
        }// end -while loop for game. If winning = false, exits.
        
        System.out.println("Thanks for playing");
    }
    
  
    public static int[] generate(double levelNum){
        //As the level increases, the likelihood of a 3 number, 4 number, or 5 number
        // problem increases. At level 1.1, the likelihood of a 3 number problem is 
        // '10%'.
        Random rng = new Random();
        int temp = (int)levelNum*10;
        int equationSize = rng.nextInt(temp) +1;
        equationSize = equationSize/10 + 1;
        int x[] = new int[equationSize+1];
        
        
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

