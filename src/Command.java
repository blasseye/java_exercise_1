import java.util.Scanner;

public interface Command {
    public abstract boolean run (Scanner sc);
    public abstract String name();
}