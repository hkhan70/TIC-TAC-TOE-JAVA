package tictactoe;
import static java.lang.System.exit;
import java.util.*;

public class TicTacToe
{
       	private static Game array[][];
       	
        public static void main(String[] args)//MAIN METHOD OF GAME!!!!!!!
    {      
          array=new Game[3][3];
          Scanner in = new Scanner(System.in);
          TicTacToe q=new TicTacToe();
          System.out.println("    |TIC-TAC-TOE|    \n");
          referenceBoard();
          Board();   
          int u=1;
          System.out.println("Do you want play with person or computer?\n1-Person  2-Computer");
          int h=in.nextInt();          
          while(u<5)
          {               
              xTurn();
              Board();
              boolean z=checkWinner(array);
              if (z==true)
                {
                System.out.println("X is Winner\nCongratulations\n");
                exit(0);
                }
              if(h==1)
              {
              oTurn();
              }
              else if(h==2)
              {
                 automatic();
              }
              Board();
              boolean m=checkWinner(array);
              if (m==true)
                {
                System.out.println("O is Winner\nCongratulations\n");
                exit(0);
                }
              
              u++;
             }      
           //END OF WHILE LOOP
            xTurn();
            Board();
            boolean z=checkWinner(array);
            if (z==true)
            {
                System.out.println("X is Winner\nCongratulations\n");
                exit(0);
            }
            else
                System.out.println("GAME DRAW");          
    }  
          
    public enum Game //Declaring enum with constants.
    {
      X,O,EMPTY;  
    }   
      TicTacToe()//Constructor which initializes the array
      {
          for(int i=0;i<3;i++)
          {
          for(int j=0;j<3;j++)                                  
          {
               array[i][j]=Game.EMPTY;
          }
          }
          
      }
              public static void Board()//Displays the board
       {
            	  
           	System.out.println("/------------------------------\\");
           	for (int i=0;i<3;i++)
           	{
           		for(int j=0;j<3;j++)
           		{
           			if(array[i][j]==Game.EMPTY)
           				{
           				System.out.print("| " + array[i][j] + "  | " );
           				}
                                else    
                                {
           				System.out.print("|   "+array[i][j]+"    | ");           				
           			}          			
           		}
           		System.out.println();
           		System.out.println("|------------------------------| ");
           		System.out.println();
                }	
       }         
            public static boolean checkWinner(Game[][] a)//Determine the winner by checking rows columns and diagnols
       {
            boolean flag = false;
            boolean flag1 = false;
            boolean flag2 = false;
            boolean flag3 = false;
            boolean flag4 = false;
            boolean flag5 = false;
            boolean flag6 = false;
            boolean flag7 = false;
            boolean flag8 = false;
         
            for (int i = 0; i <= 2; i++)
            {
                if ((array[i][0] == Game.O)&&(array[i][1]==Game.O)&&(array[i][2]==Game.O))//Checking rows
                    flag1 = true;
            }
               for (int i = 0; i <= 2; i++)
            {
               if ((array[i][0] == Game.X)&&(array[i][1]==Game.X)&&(array[i][2]==Game.X))//Checking rows
                    flag2 = true;
            }
           
            for (int j = 0; j <= 2; j++)
            {
               if ((array[0][j] == Game.O)&&(array[1][j]==Game.O) &&(array[2][j]==Game.O))//Checking columns 
                    flag3 = true;
            }
              for (int j = 0; j <= 2; j++)
            {
               if ((array[0][j] == Game.X)&&(array[1][j]==Game.X) &&(array[2][j]==Game.X))//Checking columns
                    flag4 = true;
            }          
              
             if ((array[0][0] == Game.O) && (array[1][1]==Game.O) &&(array[2][2]==Game.O))//Checking diagnols
                    flag5 = true;
             
              if ((array[1][1] == Game.X) && (array[2][2]==Game.X) &&(array[0][0]==Game.X))//Checking Diagnols
                    flag6 = true;
           
             if ((array[0][2] == Game.O)&&(array[1][1]==Game.O) && (array[2][0]==Game.O))//Checking Diagnols
                    flag7 = true;
             
             if ((array[0][2] == Game.X)&&(array[1][1]==Game.X) && (array[2][0]==Game.X))//Checking Diagnols
                    flag8 = true;
            
            if (flag1 == true || flag2 == true || flag3 == true || flag4 == true || flag5 == true || flag6 == true || flag7 == true || flag8 == true )
            {
                flag=true;
            }
            else
            {
                flag=false;
            }
            
           return flag;
       } 
        
     public static void xTurn()//Puts X in specified cell
   {
         Scanner in=new Scanner(System.in);
         while(true)
         {         
          System.out.println("Enter slot for X");
          int x=in.nextInt();
          int y=x/10;//Seperating the no into two seprate digits
          int z=x%10;//Seperating the no into two seprate digits
          if((y==1||y==2||y==3)&&(z==1||z==2||z==3))
          {
          }
          else
          {
        	  System.out.println("Invalid Entry......Again");
        	  continue;
          }
          if(array[y-1][z-1]==Game.EMPTY)
         {
            
           array[y-1][z-1]=Game.X;
           break;
         }
          else
         {
           System.out.println("Slot taken");
           continue;
          }
        }
     }
     
     public static void automatic()//For computer player game
     {
          Random rand=new Random();
          while(true)
         {           
             int u=rand.nextInt(34);
             int v=u/10;
             int w=u%10;
             if((v==1||v==2||v==3)&&(w==1||w==2||w==3))
               {
               }
             else
             {
                continue;
             }
             if(array[v-1][w-1]==Game.EMPTY)
             {            
              array[v-1][w-1]=Game.O;
              break;
             }
            else
            {
            continue;
            }          
         }
     }
     public static void oTurn()//puts O in specified cell
{        
        Scanner in = new Scanner(System.in); 
        while(true)
         {         
          System.out.println("Enter slot for O");
          int x=in.nextInt();
          int y=x/10;//Seperating the no into two seprate digits
          int z=x%10;//Seperating the no into two seprate digits
          if((y==1||y==2||y==3)&&(z==1||z==2||z==3))
          {
          }
          else
          {
        	  System.out.println("Invalid Entry......Again");
        	  continue;
          }
          if(array[y-1][z-1]==Game.EMPTY)
         {
           array[y-1][z-1]=Game.O;
           break;
         }
          else
         {
           System.out.println("Slot taken");
           continue;
         }
         }
         
  }     
     public static void referenceBoard()//Reference for player
     {
                System.out.println("REFERENCE BOARD");
                System.out.println("/-----------------\\");
		System.out.println("| " + 11 + "  | " + 12 + "  | " + 13 + "  |");
		System.out.println("|-----------------|");
		System.out.println("| " + 21 + "  | " + 22 + "  | " + 23 + "  |");
		System.out.println("|-----------------| ");
		System.out.println("| " + 31 + "  | " + 32 + "  | " + 33 + "  |");
		System.out.println("\\-----------------/");     
     }   
     
    }


