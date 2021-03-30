package Tools;

import java.util.Scanner;
import Enums.Logs;

public class Tools{


    // In bounds up to and including
    public static boolean IntegerInBounds(Integer input, Integer min, Integer max){

        if(input >= min && input <= max){
            return true;
        }

        Logs.OutOfBounds.PrintOutLog();
        return false;

    }

    // In bounds up to and including
    public static boolean StringInBounds(String input, Integer min, Integer max){
        if(input.length() >= min && input.length() <= max){
            return true;
        }

        Logs.OutOfBounds.PrintOutLog();
        return false;
    }

    public static String SafeStringInput(){
        Scanner scanner = new Scanner(System.in);

        String input;

        while (true){
            try{
                input = scanner.nextLine();
                return input;
            }catch (Exception exception){
                Logs.NotValid.PrintOutLog();
            }
        }
    }

    public static Integer SafeIntegerInput(){
        Scanner scanner = new Scanner(System.in);

        int input;

        while (true){
            try{
                input = scanner.nextInt();
                return input;
            }catch (Exception exception){
                Logs.NotValid.PrintOutLog();
            }
        }
    }

    public static String SafeStringInputWithInBounds(Integer min, Integer max){

        Scanner scanner = new Scanner(System.in);

        String input = null;

        boolean Valid = false;

        while (!Valid){
            try{
                input = scanner.next();
                Valid = StringInBounds(input, min, max);
            }catch (Exception exception){
                Logs.NotValid.PrintOutLog();
            }
        }

        return input;
    }

    public static Integer SafeIntegerInputWithInBounds(Integer min, Integer max){
        Scanner scanner = new Scanner(System.in);

        int input = 0;

        boolean Valid = false;

        while (!Valid){
            try{
                String temp = scanner.next();
                input = Integer.parseInt(temp);
                Valid = IntegerInBounds(input, min, max);
            }catch (Exception exception){
                Logs.NotValid.PrintOutLog();
            }
        }

        return input;
    }

    public static void DisplayMenuName(String text){
        System.out.println(text);
        System.out.println();
    }

    public static void PrintTheChosenOne(String chosen){
        System.out.println("You have chosen: " + chosen);
        System.out.println();
    }

    public static void PrintTheChosenOne(Integer chosen){
        System.out.println("You have chosen: " + chosen.toString());
        System.out.println();
    }

    public static void PrintTheChosenOne(Enum chosen){
        System.out.println("You have chosen: " + chosen.toString());
        System.out.println();
    }




}
