import java.util.Scanner;
import java.util.ArrayList;

public class ListMaker {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> arrList = new ArrayList<>();
        String ans = "";
        boolean run = true;

        do {
            ans = printMenu(in, arrList);
            switch (ans) {
                case "A":
                    addToArrList(in, arrList);
                    break;
                case "a":
                    addToArrList(in, arrList);
                    break;
                case "D":
                    deleteFromArrList(in, arrList);
                    break;
                case "d":
                    deleteFromArrList(in, arrList);
                    break;
                case "P":
                    displayArrList(arrList);
                    break;
                case "p":
                    displayArrList(arrList);
                    break;
                case "Q":
                    if (SafeInput.getYNConfirm(in, "Are you sure")) {
                        run = false;
                    } else {
                        System.out.println("Returning to menu...");
                    }
                    break;
                case "q":
                    if (SafeInput.getYNConfirm(in, "Are you sure")) {
                        run = false;
                    } else {
                        System.out.println("Returning to menu...");
                    }
                    break;
            }
        } while (run);
    }

    public static void addToArrList(Scanner in, ArrayList arrList) {
        String itemToAdd = SafeInput.getNonZeroLenString(in, "What would you like to add to the array list");
        arrList.add(itemToAdd);
    }

    public static void deleteFromArrList(Scanner in, ArrayList arrList) {
        int itemToDelete = SafeInput.getRangedInt(in, "What item do you like to remove?", 1, arrList.size());
        arrList.remove(itemToDelete - 1);
    }

    public static void displayArrList(ArrayList arrList) {
        for (int i = 0; i < arrList.size(); i++) {
            System.out.println(arrList.get(i));
        }
    }

    private static String printMenu(Scanner in, ArrayList arrList) {
        if (arrList.isEmpty()) {
            System.out.println("Your list is currently empty.");
        } else {
            System.out.println("Current list:");
            for (int i = 0; i < arrList.size(); i++) {
                System.out.printf("    %d. %s\n", i + 1 , arrList.get(i));
            }
        }
        return SafeInput.getRegExString(in, "Select a menu option:\n    A: Add\n    D: Delete\n    P: Print\n    Q: Quit\n", "[AaDdPpQq]").toUpperCase();
    }
}