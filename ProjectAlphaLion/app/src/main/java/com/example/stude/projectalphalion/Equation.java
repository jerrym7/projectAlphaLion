package com.example.stude.projectalphalion;
import java.util.Random;
public class Equation {
	Random rand;//random generator object
	protected String questionString ="";//hold the question
	protected String[] miniEqs;
	protected int numberOfOperations = 1;//default operations
	protected float correctAnswer = 0;//hold the correct answer
	protected String allOperations[]; //holds all operations to do.
	protected int index=0;//keep track of the index. 
	protected int boundary=2;//numbers to be operated
	public Equation()
	{
		String equationString = questionString;
		double answer = correctAnswer;
	}
	//get the answer
	private double getAnswer()
	{
		return correctAnswer;
	}
	//getter for the String
	private String getQuestionString()
	{
		return questionString;
	}
	//get a random set of operation
	private void howManyOperation(double level)
	{
		int operations=(int)level;
		rand  = new Random();
		//simple +,-,/,*, %, equations
		if(level<=1)
		{
			numberOfOperations= (rand.nextInt(2)+1);//one to two operation
		}
		//else just +,-,/,*
		else if(level<=2)
		{
			numberOfOperations= (rand.nextInt(3)+1);//1-3 operations
		}
		else if(level<=3)
		{
			numberOfOperations= (rand.nextInt(4)+1);//random number 1-4
		}
		else 
		{
			numberOfOperations= (rand.nextInt(operations)+1); //random number of operation from 1-level
		}
		
		
	}
	public void start(double level) {
		// TODO Auto-generated method stub
		howManyOperation(level);
		allOperations = new String[numberOfOperations];
		//partOfEquation = new String[numberOfOperations];
		inArrOperations();//input all the operations in a string of array
		System.out.println("What is "+questionString+"?");
		extractDecimal(correctAnswer);
		System.out.println(correctAnswer);
		
	}

	//extract to two decimal places
	
	public void extractDecimal(float answer)
	{
		float xRound;
		int xIntThous = (int)(correctAnswer*1000);// this is 123456
		int xIntHund = (int)(correctAnswer*100);// this is 12345
		if (xIntThous%10 >=5)
		{
			xRound = (float) ((xIntHund+1)/100.);
		}
		else
		{
			xRound = (float) (xIntHund/100.);
		}
		
		correctAnswer = xRound;
	}
	
	//put all the operations in the array
	private void inArrOperations() {
		// TODO Auto-generated method stub
		for(int i=0; i<allOperations.length;i++)
		{
			allOperations[i] = setOperation(numberOfOperations,index);//get all the operations in the equation
			index++;//update
			numberOfOperations--;//update
		}
		
		calculateEquation(allOperations);
		
	}
	
	//start the equations by parts
	private void calculateEquation(String[] allOperations2) {
		// TODO Auto-generated method stub
		rand = new Random();
		int indexes=0;
		int counter = 0;
		for(int i = 0;i<allOperations2.length;i++)
		{
			calculateParts(allOperations2[i],(boundary+rand.nextInt(2)),indexes,counter);
			indexes++;
			counter++;
		}
		
	}
	//calculate part by parts
	private void calculateParts(String operation,int boundaryxyz,int indexes, int counter) {
		// TODO Auto-generated method stub
		rand = new Random();//create random numbers
		//numbers to be added, subtracted
		//generate random number from 0 to 10
		
		int x = rand.nextInt(11);
		int y = rand.nextInt(11);
		int z = rand.nextInt(11);
		if(operation.equals(null))//check if null
		{
			return;
		}
		else if(operation.equals("+") && boundary>=3)
		{
			if(counter==0)
			{
			questionString += "("+Integer.toString(x)+" + " + Integer.toString(y)+" + "+Integer.toString(z);
			}
			else
			{
				questionString += "+("+Integer.toString(x)+" + " + Integer.toString(y)+" + "+Integer.toString(z)+")";
			}
			correctAnswer=(float)correctAnswer+ (x+y+z);
		}
		else if (operation.equals("+")&& boundary<3)
		{
			if(counter==0)
			{
			questionString += "("+Integer.toString(x)+" + " + Integer.toString(y)+")";
			}
			else
			{
				questionString += "+("+Integer.toString(x)+" + " + Integer.toString(y)+")";
			}
			correctAnswer=(float) correctAnswer+(x+y);
		}
		
		else if(operation.equals("-") && boundary>=3)
		{
			if(counter==0)
			{
			questionString += "("+Integer.toString(x)+" - " + Integer.toString(y)+" - "+Integer.toString(z);
			}
			else
			{
				questionString += "-("+Integer.toString(x)+" - " + Integer.toString(y)+" - "+Integer.toString(z)+")";
			}
			correctAnswer=(float)correctAnswer- (x-y-z);
		}
		else if (operation.equals("-") && boundary<3)
		{
			if(counter==0)
			{
			questionString += "("+Integer.toString(x)+" - " + Integer.toString(y)+")";
			//had to do it separated because then it would be 0-(x-y) which is negative and in reality it suppose to be positive
			correctAnswer= (float)correctAnswer + (x-y);
			}
			else
			{
				questionString += "-("+Integer.toString(x)+" - " + Integer.toString(y)+")";
				correctAnswer= (float)correctAnswer-(x-y);
			}
			
		}
		else if(operation.equals("*") && boundary>=3)
		{
			if(counter==0)
			{
			questionString += "("+Integer.toString(x)+" * " + Integer.toString(y)+" * "+Integer.toString(z);
			}
			else
			{
				questionString += "*("+Integer.toString(x)+" * " + Integer.toString(y)+" * "+Integer.toString(z)+")";
			}
			correctAnswer= (float)correctAnswer*(x*y*z);
		}
		else if (operation.equals("*")&& boundary<3)
		{
			if(counter==0)
			{
			questionString += "("+Integer.toString(x)+" * " + Integer.toString(y)+")";
			correctAnswer = correctAnswer + (x*y);
			}
			else
			{
				questionString += "*("+Integer.toString(x)+" * " + Integer.toString(y)+")";
				correctAnswer= (float) correctAnswer* (x*y);
			}
			
		}
		else 
		{
			if(y==0)
			{
				y=(rand.nextInt(10)+1);
				if(counter==0)
				{
				questionString += "("+Integer.toString(x)+" / " + Integer.toString(y)+")";
				correctAnswer = (float)correctAnswer+ (float) ((float)x/(float)y);
				}
				else
				{
					questionString += "/("+Integer.toString(x)+" / " + Integer.toString(y)+")";
					correctAnswer = (float) correctAnswer/((float)x/(float)y);
				}
			}
			else{
			if(counter==0)
			{
			questionString += "("+Integer.toString(x)+" / " + Integer.toString(y)+")";
			correctAnswer = (float)correctAnswer+((float)x/(float)y);
			}
			else
			{
				//make sure there is no denominator that is equal to zero.
				float w =((float)x/(float)y);
				if(w==0){
					w= w+1;
					questionString += "/("+Float.toString(w) +")";
					
				}
				questionString += "/("+Integer.toString(x)+" / " + Integer.toString(y)+")";
				correctAnswer = (float) correctAnswer/w;
			}
			}
		}
	}
	//get the operations number
	private String setOperation(int numberOfOperations, int index)
	{
		rand = new Random();//start the random object
		int getOperation;
		if(numberOfOperations<=0)
		{
			allOperations[index] = null;
			return null;
		}
		else if(numberOfOperations == 1)
		{
			getOperation = rand.nextInt(5);//random number from 0-4
			if(getOperation == 0)
			{
				return "+";
			}
			else if(getOperation == 1)
			{
				return "-";
			}
			else if(getOperation == 2)
			{
				return  "*";
			}
			else if(getOperation == 3)
			{
				return "/";
			}
			else 
				return "%";
		}
		else
			//just get 
			getOperation = rand.nextInt(4);//random number from 0-3
			if(getOperation == 0)
			{
				return "+";
			}
			else if(getOperation == 1)
			{
				return "-";
			}
			else if(getOperation == 2)
			{
				return "*";
			}
			else
			{
				return "/";
			}
			
	}
	

}