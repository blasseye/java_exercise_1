import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Freq implements Command{
    @Override
    public boolean run(Scanner sc) {
        System.out.println("Mettez le chemin d'un texte a connaitre");
        Scanner chemin = new java.util.Scanner(System.in);
        Path chem = Paths.get(chemin.nextLine());
        if (chem.toFile().exists()) {
            try {
                String texte = java.nio.file.Files.readString(chem);
                String texteV2 = texte.replaceAll("\\p{Punct}", " ");
                String texteV3 = texteV2.toLowerCase();
                String[] texteV4 = texteV3.split(" ");
                Map<String, Long> mots = Arrays.stream(texteV4).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

                Map<String, Long> topThree = mots.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).limit(3).collect(Collectors.toMap(
                        Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

                System.out.println("Top3 : " + topThree);
            }
            catch (IOException e) {
                System.out.println("Unreadable file : ");
                e.getMessage();
                return false;
            }
        }
        else
        {
            System.out.println("Unreadable file : ");
            return false;
        }
        return true;
    }
    @Override
    public String name() {
        return ("Freq");
    }
}
