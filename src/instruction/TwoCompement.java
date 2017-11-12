package instruction;

import java.io.IOException;

import static java.lang.Math.abs;

/**
 * Created by Kanda on 11/11/.
 */
public class TwoCompement {
    // NErver Use
    String rawBit32;
    public TwoCompement(String number) throws IOException{
        if (checkIsMinus(number)){
            System.out.println("fffffffff:"+toBinary(Integer.parseInt(number)));
        }else{
            System.out.println("ggggggggg:"+toBinary(Integer.parseInt(number)));
        }
    }

    private void OneCompement(){

    }

    public void show(){
        System.out.println(rawBit32);
    }

    private boolean checkIsMinus(String num) throws IOException{
        if(isNumeric(num)){
            return num.charAt(0) == '-';
        }else{
            throw new IOException("Two Complements; offset is not number");
        }

    }

    private static boolean isNumeric(String str){
        try{
            double d = Double.parseDouble(str);
        }
        catch(NumberFormatException nfe){
            return false;
        }
        return true;
    }

    public static String toBinary(int int1){
        int count;
        String tmp = Integer.toBinaryString(int1);
        count = tmp.length();
        while (count < 16) {
            tmp = "0" + tmp;
            count++;
        }
        return tmp;
    }
}
