package instruction;

/**
 * Created by miztscyther on 27/10/2560.
 */
public class jalr {
    static String op = "101" ;
    register rs;
    register rt;

    public jalr(String field0, String field1, String field2){
    this.rs = new register(field0);
    this.rt = new register(field2);
    }
    public String tojalr(){
        return String.valueOf(Integer.parseInt("0000000"+op+rs.CheckReg()+rt.CheckReg()+"0000000000000000000",2));
    }
}
