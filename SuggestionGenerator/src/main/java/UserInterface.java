import java.math.BigDecimal;
import java.util.Scanner;

public class UserInterface {

    Scanner scanner = new Scanner(System.in);


    public String displayMainMenu() {
        System.out.println("                                ");
        System.out.println("======== Suggestion Bot ========");
        System.out.println("(1) Get Suggestion");
        System.out.println("(2) Suggestion History");
        System.out.println("(3) Exit");
        System.out.print("Select option > ");

        return scanner.nextLine();
    }

    public void displayInvalidInput() {
            System.out.println("                                 ");
            System.out.println("Invalid choice! Please try again!");
        }

    public void displaySuggestion() {
      System.out.println("                                ");
      System.out.println("================================");
      System.out.println("Your Suggestion Is " + SuggestionGenerator.getChoice());
      System.out.println("================================");
     }

    public void displayHistory() {
        System.out.println("                                ");
       for (String str : SuggestionGenerator.getHistory()) {
           System.out.println(str);
       }
        }

    public void displayEnd() {
        System.out.println("                                ");
        System.out.println("================================");
        System.out.println("===========And Scene!===========");
        System.out.println("================================");
    }
}
