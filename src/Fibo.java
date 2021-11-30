import java.io.IOException;
import java.util.Scanner;

public class Fibo implements Command{
    @Override
    public boolean run(Scanner sc) {
        try {
            int n0 = 0;
            int n1 = 1;
            int n2 = 1;
            System.out.println("Vous avez lancé une suite de Fibonacci.\nEcrivez un nombre n pour connaitre la valeur de la suite au rang n.");
            Scanner index = new java.util.Scanner(System.in);
            int n = Integer.parseInt(index.nextLine());
            if (n == 0)
                n2 = 0;
            if (n == 1)
                n2 = 1;
            else {
                for (int i = 2; i <= n; i++) {
                    n2 = n0 + n1;
                    n0 = n1;
                    n1 = n2;
                }
            }
            System.out.println("La valeur de l'index " + n + " de la suite de Fibonacci est :" + n2);
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

    @Override
    public String name() {
        return "fibo";
    }
}

