
import java.util.Scanner;
public class SafeInput {

    public static String getNonZeroLenString (Scanner pipe, String prompt){
        String retString = "";
        do {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        } while (retString.length() == 0);
        return retString;
    }


    public static int getInt (Scanner pipe, String prompt){

        int retVal = 0;


        System.out.print(prompt);
        if (pipe.hasNextInt()) {
            retVal = pipe.nextInt();
        } else {
            String word = pipe.next();
            System.err.println(word + " is not a numerical value");
        }

        return retVal;
    }

    public static double getDouble (Scanner pipe, String prompt) {

        double retVal = 0;


        System.out.print(prompt);
        if (pipe.hasNextDouble()) {
            retVal = pipe.nextDouble();
        } else {
            String word = pipe.next();
            System.err.println(word + " is not a numerical value ");
        }
        return retVal;

    }

    public static int getRangedInt (Scanner pipe, String prompt,int low, int high){

        int retVal = low - 1;
        String trash = "";

        do {
            System.out.print("\n" + prompt + " [" + low + "-" + high + "]: ");
            if (pipe.hasNextInt()) {
                retVal = pipe.nextInt();
                if (retVal < low || retVal > high) {
                    System.out.println("Input " + retVal + " is not in range, please enter another input");
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("Input has to be a number not " + trash);
            }
        } while (retVal < low || retVal > high);

        return retVal;
    }

    public static double getRangedDouble (Scanner pipe, String prompt,double low, double high){

        double retVal = low - 1;
        String trash = "";

        do {
            System.out.print("\n" + prompt + " [" + low + "-" + high + "]: ");
            if (pipe.hasNextDouble()) {
                retVal = pipe.nextDouble();
                if (retVal < low || retVal > high) {
                    System.out.println("Input " + retVal + " is not in range, please enter another input");
                }
            } else {
                trash = pipe.nextLine();
                System.out.println("Input has to be a number not " + trash);
            }
        } while (retVal < low || retVal > high);

        return retVal;
    }

    public static boolean getYNConfirm(Scanner pipe, String prompt) {
        boolean retBoolean = false;
        String ans = "";
        boolean runCode = true;
        do {
            System.out.print("\n" + prompt + "? [Y/N] ");
            if (pipe.hasNext()) {
                ans = pipe.nextLine().toUpperCase();
                if (ans.equals("Y") || ans.equals("N")) {
                    runCode = false;
                }
            }
        } while (runCode);
        if (ans.equals("Y")) {
            retBoolean = true;
        }
        return retBoolean;
    }

    public static String getRegExString (Scanner pipe, String prompt, String regEx){
        {
            String value = "";
            boolean gotAValue = false;


            do {
                System.out.print(prompt + ": ");
                value = pipe.nextLine();
                if (value.matches(regEx)) {
                    gotAValue = true;
                } else {
                    System.out.println("\nInvalid input: " + value);
                }

            } while (!gotAValue);

            return value;
        }


    }

    public static void prettyHeader(String msg) {
        if (msg.length() < 52) {
            int position = 0;
            int valSpace = 0;
            boolean isEvenLength = (msg.length() % 2 == 0);
            for (int i = 0; i < 3; i++) {
                if (i % 2 == 0) {
                    for (int j = 0; j < 60; j++) {
                        System.out.print("*");
                    }
                    System.out.println();
                } else {
                    position = (54 - msg.length());
                    System.out.print("***");
                    for (int k = 0; k < position / 2; k++) {
                        System.out.print(" ");
                    }
                    System.out.print(msg);
                    if (isEvenLength) {
                        valSpace = position / 2;
                    } else {
                        valSpace = position / 2 + 1;
                    }
                    for (int l = 0; l < valSpace; l++) {
                        System.out.print(" ");
                    }
                    System.out.println("***");
                }
            }
        } else {
            System.out.println("Your message is too long to display, please input a shorter message.");
        }
    }

}




