package interactions;


import java.util.Scanner;

public class Response {
    private String msg;

    public String getResponse() {
        return msg;
    }

    public Response invoke(String inputString) {
        Scanner scanner = new Scanner(System.in);
        CliPrinter cli = new CliPrinter();
        cli.print(inputString);
        msg = scanner.nextLine();
        return this;
    }
}
