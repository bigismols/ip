import java.util.Scanner;

public class WansBot {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String logo ="                 __"
                + "\n|  |  /\\  |\\ | /__` "
                + "\n|/\\| /~~\\ | \\| .__/\n";

        String hr = "----------------------------------------------------------------------";

        System.out.println(hr + "\nWans:");
        System.out.println("Hey, I'm\n" + logo);
        System.out.println("Can I help? (even though I lowkey don't want to)\n" + hr);

        while (true) {
            System.out.println("User: ");
            String userInput = sc.nextLine();

            if (userInput.equalsIgnoreCase("")) {

            } else if (userInput.equalsIgnoreCase("")) {

            } else if (userInput.equalsIgnoreCase("bye")) {
                String exit = "|  _ \\ \\   / /  ____|"
                        + "\n| |_) \\ \\_/ /| |__"
                        + "\n|  _ < \\   / |  __|"
                        + "\n| |_) | | |  | |____"
                        + "\n|____/  |_|  |______";
                System.out.println("Wans: ");
                System.out.println(exit + "\nWe won't miss you :(");
                System.out.println(hr);
                System.exit(0);
            } else {
                System.out.println("Wans:");
                System.out.println(userInput);
                System.out.println(hr);
            }
        }
    }
}
