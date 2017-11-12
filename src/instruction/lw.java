package instruction;
/* Create by kandation */
import java.io.IOException;
import java.util.ArrayList;

public class lw {
    static String op = "010";
    register rs;
    register rt;
    short tmp;
    String offField;
    ArrayList<String> label;
    String [][] data;

    public lw(String field0, String field1, String field2, ArrayList<String> label, String[][] data){
        this.rs = new register(field0);
        this.rt = new register(field1);
        offField = field2;
        this.label = label;
        this.data = data;
    }

    public String doLw() throws IOException{
        if(offField.matches("(.*)[a-z](.*)")){
            for ( int i = 0;i<this.label.size(); i ++){
                if(offField.equals(label.get(i))) {
                    tmp = (short)i;
                    if(isNumeric(data[i][2])) {
                        Integer temOffsetInt = Integer.parseInt(data[i][2]);
                        if(checkOffsetSize(temOffsetInt)){
                            return String.valueOf(Integer.parseInt("0000000" + op + rs.CheckReg() + rt.CheckReg() + toBinary(tmp),2));
                        }else{
                            throw new IOException("Offset Size is Wrong");
                        }
                    }else {
                        return String.valueOf(Integer.parseInt("0000000" + op + rs.CheckReg() + rt.CheckReg() + toBinary(tmp),2));
                    }

                }
            }
        }else{
            // when offsetField is Numberic
            String offFieldBinary = String.valueOf(toBinary(Integer.parseInt(offField)));
            return String.valueOf(Integer.parseInt("0000000" + op + rs.CheckReg() + rt.CheckReg() + offFieldBinary,2));
        }
        return null;
    }

    public static boolean isNumeric(String str){
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

    public boolean checkOffsetSize(int ff){
        return (ff > -32768 && ff < 32767);
    }

}
