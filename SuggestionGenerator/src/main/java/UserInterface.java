import java.util.Scanner;

public class UserInterface {
    Scanner scanner = new Scanner(System.in);

    public String displayMainMenu() {
        System.out.println("                                ");
        System.out.println("======== Suggestion Bot ========");
        System.out.println("(1) Get Suggestion");
        System.out.println("(2) Exit");
        System.out.print("Select option > ");


        return scanner.nextLine();
    }

    public void displayInvalidInput() {
            System.out.println("                                 ");
            System.out.println("Invalid choice! Please try again!");
        }
}
