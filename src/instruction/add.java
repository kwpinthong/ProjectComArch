package instruction;

/**
 * Created by ASUS on 10/23/2017.
 */
public class add {
    static String op = "000" ;
    String rs;
    String rt;
    String rd;
    public add(String field0,String field1,String field2){
        this.rs = field0;
        this.rt = field1;
        this.rd = field2;
    }

    /*private static String dec2bin(int dec){
        switch(dec) {
            case 0:
                return "000";
            case 1:
                return "001";
            case 2:
                return "010";
            case 3:
                return "011";
            case 4:
                return "100";
            case 5:
                return "101";
            case 6:
                return "110";
            case 7:
                return "111";
            default:
                return "Wrong number of rs or rt";
        }
    }*/

    public String doAdd(){
        return String.valueOf(Integer.parseInt(op+rs+rt+"0000000000000"+rd,2));
    }
}
