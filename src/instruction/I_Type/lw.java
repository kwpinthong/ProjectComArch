package instruction.I_Type;
/* Create by kandation */
import instruction.register;

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
        // ตรวจสอบว่า offset feild เป็นตัวเลข หรือ lable
        if(offField.matches("(.*)[a-z](.*)")){
            // กรณีที่ เป็น label
            // วนหา address ของ offset field
            int lableCouter = 0;
            for ( int i = 0;i<this.label.size(); i ++){
                // ถ้ามีตรงกันในลิส์
                if(offField.equals(label.get(i))) {
                    tmp = (short)i;
                    //ตรวจว่ามันเป็นตัวเลขหรือไม่
                    if(isNumeric(data[i][2])) {
                        // ถ้าตามเลเบิลไปเป็นตัวเลข ให้ทำการแปลงเป็นฐานสอง
                        Integer temOffsetInt = Integer.parseInt(data[i][2]);
                        if(checkOffsetSize(temOffsetInt)){
                            return String.valueOf(Integer.parseInt("0000000" + op + rs.CheckReg() + rt.CheckReg() + toBinary(tmp),2));
                        }else{
                            throw new IOException("Error: Offset Size is Wrong");
                        }
                    }else {
                        return String.valueOf(Integer.parseInt("0000000" + op + rs.CheckReg() + rt.CheckReg() + toBinary(tmp),2));
                    }
                }
            }
            if(lableCouter >= this.label.size()){
                // ถ้าไม่เจอ label แสดงว่า ลาเบลผิด หรือ ไม่มีจริง แสดง เออเรอ
                throw new IOException("Error: Label is Undefinded");
            }
        }else{
            // when offsetField is Numberic
            int intOffsetField = Integer.parseInt(offField);
            String offFieldBinary = String.valueOf(toBinary(intOffsetField));
            if(checkOffsetSize(intOffsetField)){
                return String.valueOf(Integer.parseInt("0000000" + op + rs.CheckReg() + rt.CheckReg() + offFieldBinary,2));
            }else{
                throw new IOException("Error: Offset Size is Wrong");
            }

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

    public boolean checkOffsetSize(int ff){
        return (ff > -32768 && ff < 32767);
    }

}
