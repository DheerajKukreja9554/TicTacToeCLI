package params;

import java.util.Scanner;

public class GameParams {

    public static final Scanner SCANNER= new Scanner(System.in);
    public static final char X='X';
    public static final char O='O';
    public static final String compname="Computer";
    public static void welcome() {
        System.out.println("\n\n\n");
        System.out.println("------------    -----------    -----------      ------------      //---\\\\      -----------      ------------    -----------    -----------");
        System.out.println("------------    -----------    -----------      ------------     //-----\\\\     -----------      ------------    -----------    -----------");
        System.out.println("     ||              ||        ||                    ||         ||       ||    ||                    ||         ||       ||    ||         ");
        System.out.println("     ||              ||        ||                    ||         ||       ||    ||                    ||         ||       ||    |----------");
        System.out.println("     ||              ||        ||                    ||         |---------|    ||                    ||         ||       ||    |----------");
        System.out.println("     ||              ||        ||                    ||         |---------|    ||                    ||         ||       ||    ||         ");
        System.out.println("     ||         -----------    -----------           ||         ||       ||    -----------           ||         -----------    -----------");
        System.out.println("     ||         -----------    -----------           ||         ||       ||    -----------           ||         -----------    -----------");

    }
}
