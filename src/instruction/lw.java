package instruction;
import java.util.ArrayList;

public class lw {
    static String op = "100";
    register rs;
    register rt;
    short tmp;
    String offField;
    ArrayList<String> label;
    String [][] data;

    public lw(String field0, String field1, String field2, ArrayList<String> label,String[][] data){
        this.rs = new register(field0);
        this.rt = new register(field1);
        offField = field2;
        this.label = label;
        this.data = data;
    }

    public String doLw(){
        if(offField.matches("(.*)[a-z](.*)")){
            for ( int i = 0;i<this.label.size(); i ++){
                if(offField.equals(label.get(i))) {
                    tmp = (short)i;
                    return String.valueOf(Integer.parseInt("0000000" + op + rs.CheckReg() + rt.CheckReg() + toBinary(tmp), 2));
                }
            }
            return offField;

        }else{
            // when offsetField is Numberic
            String offFieldBinary = String.valueOf(toBinary(Integer.parseInt(offField)));
            return String.valueOf(Integer.parseInt("0000000" + op + rs.CheckReg() + rt.CheckReg() + offFieldBinary, 2));
        }

        /*if(offField.matches("(.*)[a-z](.*)")){
            for ( int i = 0;i<this.label.size(); i ++){
                if(offField.equals(label.get(i))) {
                    tmp = (short)i;
                    tmp -= PC + 1;
                    return String.valueOf(Integer.parseInt("0000000" + op + rs.CheckReg() + rt.CheckReg() + toBinary(tmp), 2));
                }
            }
            return offField;
        }
        else return String.valueOf(Integer.parseInt("0000000"+op+rs.CheckReg()+rt.CheckReg()+toBinary(Integer.parseInt(offField)),2));*/

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

}
