import java.io.IOException;
import java.util.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Function;
import java.util.stream.Collectors;

class Launcher
{
    public static void main(String[] args){
        int i;
        System.out.println("Bienvenue jeune padawan!");

        boolean Isrunning = false;
        ArrayList<Command> CommandList = new ArrayList<>();
        CommandList.add(new Quit());
        CommandList.add(new Fibo());
        CommandList.add(new Freq());
        int index;
        Scanner var = new Scanner(System.in);
        while (!Isrunning) {
            index = -1;
            String UserEntry = var.next();
            for ( i = 0 ; i < CommandList.size(); i++){
                if (UserEntry.equals(CommandList.get(i).name())){
                    index = i;
                }
            }
            if (index == -1){
                System.out.println("Unknow Command");
            }
            else {
                Isrunning = CommandList.get(index).run(var);
                System.out.println("Fin de fonction, retour dans le coté obscure de la force");
            }
        }
    }
}
