package interactions;

public class CliPrinter implements UserInteraction {

    @Override
    public void print(String msg) {
        System.out.println(msg);
    }

}
