import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SuggestionGenerator {
    List<String> suggestions = new ArrayList<>();
    UserInterface ui = new UserInterface();
    Random random = new Random();
    public int size;
    public int listLength;
    public int rand;
    public SuggestionGenerator() {
        fillSuggestions();
      listLength = suggestions.size();
    }

    private void fillSuggestions() {
        File input = new File("suggestionList.txt");
        Scanner fs = null;
        try {
            fs = new Scanner(input);
            while (fs.hasNextLine()) {
                String line = fs.nextLine();
                this.suggestions.add(line);
            }
        } catch (FileNotFoundException e) {

        } finally {
            if (fs != null)
                fs.close();
        }
    }

    public static void main(String[] args) {
        SuggestionGenerator cli = new SuggestionGenerator();
        cli.run();
    }
    public void run(){
        while (true) {
            String userChoice = ui.displayMainMenu();

            if (userChoice.equals("1")) {
                randomNumber();
                pullSuggestion();
            } else if (userChoice.equals("2")) {
                System.out.println("                                ");
                System.out.println("================================");
                System.out.println("===========And Scene!===========");
                System.out.println("================================");
                break;
            } else {
                ui.displayInvalidInput();
            }
        }


    }

    private void pullSuggestion() {
        String choice = suggestions.get(this.rand);
        System.out.println("                    ");
        System.out.println("================================");
        System.out.println("Your suggestion is " + choice);
        System.out.println("================================");
    }

    private void randomNumber() {
        int rand = 0;
        while (true){
            this.rand = random.nextInt(listLength);
            if(this.rand !=0) break;
        }
    }
}
