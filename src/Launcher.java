import java.util.*;

class Launcher
{
public static void main(String[] args)
{
    System.out.println("Bienvenue jeune padawan.");

    Scanner variable = new java.util.Scanner(System.in);
    String mot = variable.nextLine();

    if (mot != "quit")
    {
        System.out.println("Unknown command");
    }
}
}
