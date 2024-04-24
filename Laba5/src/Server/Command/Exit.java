package Server.Command;

/**
 * This command is used to exit the console application
 */
public class Exit extends Command {


    public Exit() {
    }

    public void execute(String id) {
        System.exit(52);
    }
}
