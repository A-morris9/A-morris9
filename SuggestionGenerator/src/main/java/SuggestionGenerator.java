import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class SuggestionGenerator {
    List<String> suggestions = new ArrayList<>();
    public static List<String> history = new ArrayList<>();
    UserInterface ui = new UserInterface();
    Random random = new Random();
    static String choice;
    public int listLength, rand;
    public static String getChoice() {
        return choice;
    }
    public static List<String> getHistory() {
        return history;
    }
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
                ui.displayHistory();

            }else if (userChoice.equals("3")) {
                ui.displayEnd();
                break;
            } else {
                ui.displayInvalidInput();
            }
        }
    }

    private void pullSuggestion() {
        choice = suggestions.get(this.rand);
        ui.displaySuggestion();
        fillHistory();
    }

    private void randomNumber() {
        int rand = 0;
        while (true){
            this.rand = random.nextInt(listLength);
            if(this.rand !=0) break;
        }
    }
    private void fillHistory() {
        history.add(choice);
    }
}
