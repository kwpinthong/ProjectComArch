package instruction;

/**
 * Created by ASUS on 10/23/2017.
 */
public class nand {
    static String op = "001" ;
    String rs;
    String rt;
    String rd;
    public nand(String field0,String field1,String field2){
        this.rs = field0;
        this.rt = field1;
        this.rd = field2;
    }
    public String doNand(){
        return String.valueOf(Integer.parseInt(op+rs+rt+"0000000000000"+rd,2));
    }
}
