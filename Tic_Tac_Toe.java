
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

//Note: This game we can do with 2D array also

public class Tic_Tac_Toe {

    int countPlayer1=0;
    int countPlayer2=0;
    int singlePlayerCount=0;
    int pcCount=0;
    int player1Count=0;
    int player2Count=0;
    int flag=0;



    static Scanner sc = new Scanner(System.in);
    Random rand = new Random();
   
    ArrayList<Integer> user_Input = new ArrayList<>();// for collecting the user entered position,checking for if position already taken then should not able to take that positon again,so 

    ArrayList<Integer> pc_Collected_Input = new ArrayList<>();// for collecting the pc entered position

    public void design(char ch[])
     {
        // design for the game layout

        System.out.println("\n\t\t\t\t\t\t\t\t\t\t\t\t   Result:");
        System.out.print("\n\t\t\t\t\tPlayer 1: x");
        System.out.println("\t\t\t\t\t\tPlayer1:"+ countPlayer1+" Times Wins");
        System.out.print("\t\t\t\t\tPlayer 2: o");
        System.out.println("\t\t\t\t\t\tPlayer2:"+ countPlayer2+" Times Wins");


        System.out.printf("\t\t\t\t\t\t\t\t     |      | \n");
        System.out.printf("\t\t\t\t\t\t\t\t %c   |  %c   |  %c  \n", ch[0], ch[1], ch[2]);
        System.out.printf("\t\t\t\t\t\t\t\t_____+______+_____\n");
        System.out.printf("\t\t\t\t\t\t\t\t %c   |  %c   |  %c  \n", ch[3], ch[4], ch[5]);
        System.out.printf("\t\t\t\t\t\t\t\t_____+______+_____\n");
        System.out.printf("\t\t\t\t\t\t\t\t %c   |  %c   |  %c  \n", ch[6], ch[7], ch[8]);
        System.out.printf("\t\t\t\t\t\t\t\t     |      | \n");

    }

    public int checkPosition(Integer position)
     {
         // checking entered position is valid or not postion should be between 1 to 9

        while (position > 9 || position == 0) {
            System.out.println("\t\t\t\t\t\t***Warn:Please Enter The Correct Position From 1-9***");

            position = sc.nextInt();
            position = checkPositionContains(position);
        }
        return position;
    }

    public int checkPositionContains(Integer position) 
    {
        // here is the most important function of this whole game , here we are checking the entered position already taken or not, if taken then try for another position and at last returning the correct position

        boolean contain_pc = pc_Collected_Input.contains(position);
        boolean contain_own = user_Input.contains(position);

        if (contain_pc == true || contain_own == true) {
            while (contain_pc != false || contain_own != false) {
                System.out.println("\t\t\t\t\t\t***Warn:Position Already Taken, Try For Another One***");

                position = sc.nextInt();
                contain_own = user_Input.contains(position);
                contain_pc = pc_Collected_Input.contains(position);
            }
        }
        return position;
    }

    public void multiPlayerInput(char ch[]) 
    {
        // This function made for multiplayer , here player will beat each other
    
        // System.out.println("The flag is:"+flag);
        if(flag==1)// for indecating the previous executed function is singleplayer
        {
           countPlayer1=player1Count=0;
           countPlayer2=player2Count=0;
        }
        flag=2;
       
        System.out.println("\t\t\t\t\t\t_____________________________________________________");
        System.out.println("\n\t\t\t\t\t\t\t***Welcome To Multi-Player Competition***");
        System.out.println("\t\t\t\t\t\t_____________________________________________________\n\n");
        design(ch);
        while (true) {
            if (user_Input.size() == 5) 
            {
                //here we are giving the chance first for the fitst player so at last also position will entered by first player so if player 1 entered 5 times then game should be over beacause player 2 also entered position opponents to player 1 so total position will 5+4=9 
                System.out.println("\n\n\t\t\t\t\t\t\t  |__________________________|");
                System.out.println("\t\t\t\t\t\t\t\t *** Game Draw ***");
                System.out.println("\t\t\t\t\t\t\t  |__________________________|");
            System.out.println("\t\t\t\t\t\t_____________________________________________________");
                break;
            }
            // System.out.println("The user size is:"+user_Input.size());
            System.out.println("Player 1: Enter your Position");
            Integer position = sc.nextInt();

            position = checkPositionContains(position);

            position = checkPosition(position);

            user_Input.add(position);//adding position to the user_input

            ch[position - 1] = 'x';
            if(checkConditions()==1){
            countPlayer1++;
            design(ch);
            }
            else 
            design(ch);
            if (checkConditions() == 1) 
            {
                player1Count++;
                countPlayer1=player1Count;
                // checkConditions function will return 1 for the win 
                System.out.println("\n\n\t\t\t\t\t\t\t  |____________________________|");
                System.out.println("\t\t\t\t\t\t\t\t *** Player 1 Win ***");
                System.out.println("\t\t\t\t\t\t\t  |____________________________|");
            System.out.println("\t\t\t\t\t\t_____________________________________________________");

                break;
            }
            if (user_Input.size() == 5) 
            {
                //here we are giving the chance first for the fitst player so at last also position will entered by first player so if player 1 entered 5 times then game should be over beacause player 2 also entered position opponents to player 1 so total position will 5+4=9 
                System.out.println("\n\n\t\t\t\t\t\t\t  |__________________________|");
                System.out.println("\t\t\t\t\t\t\t\t *** Game Draw ***");
                System.out.println("\t\t\t\t\t\t\t  |__________________________|");
            System.out.println("\t\t\t\t\t\t_____________________________________________________");
                break;
            }

            System.out.println("Player 2: Enter your Position");
            Integer position1 = sc.nextInt();

            position1 = checkPositionContains(position1);

            position1 = checkPosition(position1);

            pc_Collected_Input.add(position1);// adding position to the pc_collected_input

            ch[position1 - 1] = 'o';

            if(checkConditions()==-1){
                countPlayer2++;
                design(ch);
                }
            else 
            design(ch);
           
            if (checkConditions() == -1) 
            {
                // here checkcondition returns -1 when pc win so we are collecting all position of player 2 in pc_collected_input so if -1 then player 2 will win
                player2Count++;
                countPlayer2=player2Count;
                System.out.println("\n\n\t\t\t\t\t\t\t  |____________________________|");
                System.out.println("\t\t\t\t\t\t\t\t *** Player 2 Win ***");
                System.out.println("\t\t\t\t\t\t\t  |____________________________|");
            System.out.println("\t\t\t\t\t\t_____________________________________________________");

                break;
            }
        }

    }

    public int checkConditions() 
    {
        // here 1 for win and -1 for loose means pc win

        List<Integer> topRow = Arrays.asList(1, 2, 3);//just we are viewing the array as list
        List<Integer> midRow = Arrays.asList(4, 5, 6);
        List<Integer> bottomRow = Arrays.asList(7, 8, 9);

        List<Integer> leftCol = Arrays.asList(1, 4, 7);
        List<Integer> midCol = Arrays.asList(2, 5, 8);
        List<Integer> rightCol = Arrays.asList(3, 6, 9);

        List<Integer> Diagonal1 = Arrays.asList(1, 5, 9);
        List<Integer> Diagonal2 = Arrays.asList(3, 5, 7);

        if (user_Input.containsAll(topRow) || user_Input.containsAll(midRow) || user_Input.containsAll(bottomRow)
                || user_Input.containsAll(leftCol) || user_Input.containsAll(midCol) || user_Input.containsAll(rightCol)
                || user_Input.containsAll(Diagonal1) || user_Input.containsAll(Diagonal2))
            return 1;

        else if (pc_Collected_Input.containsAll(topRow) || pc_Collected_Input.containsAll(midRow)
                || pc_Collected_Input.containsAll(bottomRow) || pc_Collected_Input.containsAll(leftCol)
                || pc_Collected_Input.containsAll(midCol) || pc_Collected_Input.containsAll(rightCol)
                || pc_Collected_Input.containsAll(Diagonal1) || pc_Collected_Input.containsAll(Diagonal2))
            return -1;

        else
            return 0;

    }
    public int breakCondition(char ch[])
    {
        
        if (checkConditions() == 1) {
            singlePlayerCount++;
            countPlayer1=singlePlayerCount;
            design(ch);
            System.out.println("\n\n\t\t\t\t\t\t\t  |__________________________|");
            System.out.println("\t\t\t\t\t\t\t\t *** You Win ***");
            System.out.println("\t\t\t\t\t\t\t  |__________________________|");
        System.out.println("\t\t\t\t\t\t_____________________________________________________");

            return 1;
        } else if (checkConditions() == -1) {
            pcCount++;
            countPlayer2=pcCount;
            design(ch);
            System.out.println("\n\n\t\t\t\t\t\t\t  |__________________________|");
            System.out.println("\t\t\t\t\t\t\t\t *** You Lose ***");
            System.out.println("\t\t\t\t\t\t\t  |__________________________|");
        System.out.println("\t\t\t\t\t\t_____________________________________________________");


            return -1;
        }
        return 0;
    }

    public void singlePlayerInput(char ch[]) 
    {
        // here we are performing the singleplayer tasks
        // we generating 9 number and unique numbers for pc turn so we are using set 
    
        // System.out.println("The flag is:"+flag);
        if(flag==2)// For indicating the previous excueted function in multiplayer
        {
           countPlayer1=singlePlayerCount=0;
           countPlayer2=pcCount=0;
        }
        flag=1;
       
        Set<Integer> s = new LinkedHashSet<Integer>();
        while (s.size() < 9) {
            int generate = (rand.nextInt(10 - 1) + 1);
            s.add(generate);
        }

        // System.out.println(s);

        ArrayList<Integer> pc_converted_set_To_List = new ArrayList<Integer>(s);// here we are converting the set to list beacause set doesn't contain index methods like get so list has this facility.

        int count = 0;

        // -------User-Start
        System.out.println("\t\t\t\t\t\t_____________________________________________________");
        System.out.println("\n\t\t\t\t\t\t\t***Welcome To Single Player Competition***");
        System.out.println("\n\t\t\t\t\t\t\tHere Your Opponent Will Be PC ! Best Luck");
        System.out.println("\t\t\t\t\t\t_____________________________________________________\n\n");
        design(ch);
        Label1: while (true) {
            // System.out.println("size is user:"+user_Input.size());
           

            if(breakCondition(ch)==1 || breakCondition(ch)==-1)
            break;

            if (user_Input.size() == 5) {
                System.out.println("\n\n\t\t\t\t\t\t\t  |__________________________|");
                System.out.println("\t\t\t\t\t\t\t\t *** Game Draw ***");
                System.out.println("\t\t\t\t\t\t\t  |__________________________|");
        System.out.println("\t\t\t\t\t\t_____________________________________________________");


                break;
            }
            // System.out.println("The size is:"+user_Input.size());

            System.out.println("Player 1 : Enter the position");
            Integer position = sc.nextInt();

            position = checkPositionContains(position);

            position = checkPosition(position);

            user_Input.add(position);
            // System.out.println(user_Input);

            ch[position - 1] = 'x';
            design(ch);
            // ----------User-End-----------

            // ----------Pc-Start-----------
            // System.out.println("The count is:"+count);
            if (count == 9) 
            {
                // when pc count 9 that means number generated are ends 
                System.out.println("\n\n\t\t\t\t\t\t\t  |__________________________|");
                System.out.println("\t\t\t\t\t\t\t\t *** Game Draw ***");
                System.out.println("\t\t\t\t\t\t\t  |__________________________|");
        System.out.println("\t\t\t\t\t\t_____________________________________________________");


                break;
            }
            Integer pc_pos = pc_converted_set_To_List.get(count);
            Boolean contain = user_Input.contains(pc_pos);
            if (contain == true) {
                while (contain != false) {
                    count++;
                    if (count == 9) {
                        if(breakCondition(ch)==1 || breakCondition(ch)==-1)
                        break Label1;
                        System.out.println("\n\n\t\t\t\t\t\t\t  |__________________________|");
                        System.out.println("\t\t\t\t\t\t\t\t *** Game Draw ***");
                        System.out.println("\t\t\t\t\t\t\t  |__________________________|");
        System.out.println("\t\t\t\t\t\t_____________________________________________________");


                        break Label1;//if game draw then exist from the label1 (entire loop)
                    }
                    pc_pos = pc_converted_set_To_List.get(count);
                    contain = user_Input.contains(pc_pos);
                    if (contain == false)
                        pc_Collected_Input.add(pc_pos);
                }
            } 
            else
            pc_Collected_Input.add(pc_pos);

            ch[pc_pos - 1] = 'o';

            design(ch);
            count++;
            
            // System.out.println("The count is:"+count);
            // System.out.println("count value is :"+ count);
            // System.out.println(pc_Collected_Input);

            // ----------Pc-End------------------

        }

    }

    public void chechValidPlayerOption(char ch[])
     {
        //basically menu driven 
        System.out.println("\t\t\t\t\t\t_____________________________________________________");
        System.out.println("\n\t\t\t\t\t\t\t   ***Welcome To Tic Tac Toe***");
        System.out.println("\t\t\t\t\t\t_____________________________________________________");

        while (true) {
            System.out.println("\n\t\t\t\t\t\t   Wanna Play as Single Player or Multiplayer?");
            System.out.println("\n\t\t\t\t\t\t\t\t 1.Single Player");
            System.out.println("\t\t\t\t\t\t\t\t 2.Multi Player");
            System.out.println("\t\t\t\t\t\t\t\t 3. Quit");


            int choice = sc.nextInt();
            if (choice == 1) {
                user_Input.clear();
                pc_Collected_Input.clear();
                ch = new char[9];
                singlePlayerInput(ch);
            } else if (choice == 2) {
                user_Input.clear();
                pc_Collected_Input.clear();
                ch = new char[9];
                multiPlayerInput(ch);
            }else if(choice==3)
             System.exit(0);
             else
             {
                System.out.println("\t\t\t\t\t\t   ***Warn:Please enter the Correct choice***");
             }

        }
    }

    public static void main(String args[]) {
        char ch[] = new char[9];
        Tic_Tac_Toe t1 = new Tic_Tac_Toe();
        t1.chechValidPlayerOption(ch);

    }

}
