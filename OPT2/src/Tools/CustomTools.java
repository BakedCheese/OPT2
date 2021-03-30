package Tools;

import Enums.Logs;

public class CustomTools extends Tools  {

    public static boolean SafeStringInputPlusIfStatement(String yes, String no){

        while (true){
            String temp = SafeStringInput();

            if(temp.equals(yes)){
                return true;
            }
            else if(temp.equals(no)){
                return false;
            }else{
                Logs.NotValid.PrintOutLog();
            }

        }




    }

}
