package instruction.J_Type;
import instruction.register;
/**
 * Created by ASUS on 10/30/2017.
 */
public class jalr {
    String op = "101";
    register rs;
    register rt;

    public jalr(String field0, String field1){
        this.rs = new register(field0);
        this.rt = new register(field1);
    }
    public String toJalr(){
        return String.valueOf(Integer.parseInt("0000000"+op+rs.CheckReg()+rt.CheckReg()+"0000000000000000",2));
    }
}

