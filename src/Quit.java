import java.util.Scanner;

public class Quit implements Command{
    public void quit() {

    }

    @Override
    public boolean run(Scanner sc) {
        return false;
    }

    @Override
    public String name() {
        return "quit";
    }
}
