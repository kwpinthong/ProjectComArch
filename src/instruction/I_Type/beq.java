package instruction.I_Type;

import instruction.register;
import java.util.ArrayList;

public class beq {
    static String op = "100";
    register rs;
    register rt;
    short tmp;
    int PC;
    String offField;
    ArrayList<String> label;

    public beq (String field0, String field1, String field2, ArrayList<String> label, int PC)
    {
        this.rs = new register(field0);
        this.rt = new register(field1);
        offField = field2;
        this.PC = PC;
        this.label = label;
    }

    public String doBeq () {
        if(label.contains(offField)) { //offField.matches("(.*)[a-z][A-Z](.*)")
            for ( int i = 0;i<this.label.size(); i ++) {
                if(offField.equals(label.get(i))) {
                    tmp = (short)i;
                    tmp -= PC + 1;
                    return String.valueOf(Integer.parseInt("0000000" + op + rs.CheckReg() + rt.CheckReg() + toBinary(tmp), 2));
                }
            }
            return offField;
        }else{
            if(!isNumber(offField)){
                System.out.println("Error: Undefine Label");
                System.exit(1);
            }
            return String.valueOf(Integer.parseInt("0000000"+op+rs.CheckReg()+rt.CheckReg()+toBinary(Integer.parseInt(offField)),2));
        }
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
    public static String toBinary(short int1){
        short count ;
        String tmp = Integer.toBinaryString(0xFFFF & int1);
        count = (short)tmp.length();
        while (count < 16) {
            tmp = "0" + tmp;
            count++;
        }
        return tmp;
    }
    private boolean isNumber(String field0){
        try{
            int temp = Integer.parseInt(field0);
        }catch (NumberFormatException nfe){
            return false;
        }
        return true;
    }
}

