package instruction;

/**
 * Created by ASUS on 10/23/2017.
 */
public class nand {
    static String op = "001" ;
    register rs;
    register rt;
    register rd;
    public nand(String field0,String field1,String field2){
        this.rs = new register(field0);
        this.rt = new register(field1);
        this.rd = new register(field2);
    }
    public String doNand(){
        return String.valueOf(Integer.parseInt("0000000"+op+rs.CheckReg()+rt.CheckReg()+"0000000000000"+rd.CheckReg(),2));
    }
}
