import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random gen = new Random();
        String continueYN = "";
        boolean done = false;
        int crapsRoll, die1, die2, roll2;

        System.out.println("Welcome to Craps!\nThe rules are simple:");
        System.out.println("1. Roll Two Dice.\n2. If the sum is 2,3, or 12; You got craps or crapping out and you lose");
        System.out.println("3. If the sum is 7 or 11 it is a natural and you win!");
        System.out.println("4. For everything else, the sum becomes 'the point' and you keep rolling until you roll a 7 and lose or make the point sum and win");
        do {
            System.out.println("Time to Roll!");
            System.out.print("Press R to roll or Q to quit: ");
            continueYN = in.nextLine();
            if (continueYN.equalsIgnoreCase("Q")) {
                done = true;
                System.out.println("Thanks for playing Craps!");
            } else if (continueYN.equalsIgnoreCase("R")) {
                die1 = gen.nextInt(6) + 1;
                die2 = gen.nextInt(6) + 1;
                crapsRoll = die1 + die2;
                if (crapsRoll == 2 || crapsRoll == 3 || crapsRoll == 12) {
                    System.out.println(crapsRoll);
                    System.out.println("Craps! You lost.");
                    System.out.print("Would you like to play again? (Y/N)");
                    continueYN = in.nextLine();
                    if (continueYN.equalsIgnoreCase("N")) {
                        done = true;
                        System.out.println("Thanks for playing Craps!");
                    } else if (continueYN.equalsIgnoreCase("Y")) {
                        done = false;
                    } else {
                        System.out.print("Invalid input!" + continueYN + "\nPlease select [Y/N]: ");
                    }
                } else if (crapsRoll == 7 || crapsRoll == 11) {
                    System.out.println(crapsRoll);
                    System.out.println("Natural! You won.");
                    System.out.print("Would you like to play again? (Y/N)");
                    continueYN = in.nextLine();
                    if (continueYN.equalsIgnoreCase("Y")) {
                        done = false;
                    } else if (continueYN.equalsIgnoreCase("N")) {
                        done = true;
                        System.out.println("Thanks for playing Craps!");
                    } else {
                        System.out.print("Invalid input!" + continueYN + "\nPlease select [Y/N]: ");
                    }
                } else if (crapsRoll == 4 || crapsRoll == 5 || crapsRoll == 6 || crapsRoll == 8 || crapsRoll == 9 || crapsRoll == 10) {
                    System.out.print(crapsRoll + "\n");
                    do {
                        System.out.println("Time to roll again!");
                        System.out.print("Press R to roll or Q to quit: ");
                        continueYN = in.nextLine();
                        if (continueYN.equalsIgnoreCase("Q")) {
                            done = true;
                        }
                        else if (continueYN.equalsIgnoreCase("R")) {
                            do {
                                die1 = gen.nextInt(6) + 1;
                                die2 = gen.nextInt(6) + 1;
                                roll2 = die1 + die2;
                                if (roll2 == crapsRoll) {
                                    System.out.println(roll2 + "\n");
                                    System.out.println("Point Sum! You win!");
                                    System.out.println("Do you want to play again? (Y/N).");
                                    continueYN = in.nextLine();
                                } else if (roll2 == 7) {
                                    System.out.println(roll2 + "\n");
                                    System.out.println("You rolled a 7 before a point sum! You lose!");
                                    System.out.println("Do you want to play again? (Y/N).");
                                    continueYN = in.nextLine();
                                }
                                else
                                {
                                    System.out.print("Invalid input!" + continueYN + "\nPlease select [Y/N]: ");
                                }
                            }while (!continueYN.equalsIgnoreCase("N"));
                        }else
                        {
                            System.out.print("Invalid input!" + continueYN + "\nPlease select [R/Q]: ");
                        }
                    }while(!continueYN.equalsIgnoreCase("Q"));
                }
            }
        }while(!done);
    }
}