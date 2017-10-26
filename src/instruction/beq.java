package instruction;

import java.util.ArrayList;

public class beq {
    static String op = "100";
    register rs;
    register rt;
    int sum;
    String offField;


    public beq (String field0, String field1, String field2, ArrayList<String> label)
    {
        this.rs = new register(field0);
        this.rt = new register(field1);
        offField = field2;

    }

    public String doBeq ()
    {

        if(offField.matches("(.*)[a-z](.*)"))
        {
            return offField;
        }
        else return String.valueOf(Integer.parseInt("0000000"+op+rs.CheckReg()+rt.CheckReg()+toBinary(Integer.parseInt(offField)),2));
    }
    public static String toBinary(int int1){
        int count;
        String tmp = Integer.toBinaryString(int1);
        count = tmp.length();
        System.out.println(tmp);
        while (count < 16) {
            tmp = "0" + tmp;
            count++;
        }
        return tmp;
    }


}

