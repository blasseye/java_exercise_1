import java.io.IOException;
import java.util.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.stream.Collectors;

class Launcher
{
    public static void main(String[] args) throws IOException {
        System.out.println("Bienvenue jeune padawan.");

        Scanner variable = new java.util.Scanner(System.in);
        String mot = variable.nextLine();


        while (!mot.equals("quit"))
        {
            if (mot.equals("fibo"))
            {
                //fibo
                int n0=0;
                int n1=1;
                int n2=1;
                System.out.println("Vous avez lancé une suite de Fibonacci.\nEcrivez un nombre n pour connaitre la valeur de la suite au rang n.");
                Scanner index = new java.util.Scanner(System.in);
                int n = Integer.parseInt(index.nextLine());
                if (n==0)
                    n2=0;
                if (n==1)
                    n2=1;
                else {
                    for (int i = 2; i <= n; i++) {
                        n2 = n0 + n1;
                        n0 = n1;
                        n1 = n2;
                    }
                }
                System.out.println("La valeur de l'index " + n + " de la suite de Fibonacci est :" + n2);
            }
            if (mot.equals("freq"))
            {
                System.out.println("Mettez le chemin d'un texte a connaitre");
                Scanner chemin = new java.util.Scanner(System.in);
                Path chem = Paths.get(chemin.nextLine());
                if(chem.toFile().exists())
                {
                    try {
                        String texte = java.nio.file.Files.readString(chem);
                        String texteV2 = texte.replaceAll("\\p{Punct}", " ");
                        String texteV3 = texteV2.toLowerCase();
                        String[] texteV4 = texteV3.split(" ");
                        Map<String,Long> mots=  Arrays.stream(texteV4).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));

                        Map<String ,Long> topThree = mots.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(3).collect(Collectors.toMap(
                                        Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

                        System.out.println("Top3 : " + topThree);
                    }
                    catch (IOException e)
                    {
                        System.out.println("Unreadable file : ");
                        e.getMessage();
                    }
                }
                else
                {
                    System.out.println("Unreadable file: "+chem);
                }

            }
            else {
                System.out.println("Unknown command");
            }
            variable = new java.util.Scanner(System.in);
            mot = variable.nextLine();
        }
    }
}
