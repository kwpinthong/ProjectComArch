package instruction;
/**
 * Created by ASUS on 11/17/2017.
 */
public class O_Type {
    static String op_halt = "110" ;
    static String op_noop = "111" ;
    String inst;
    public String dohalt_oR_Noop(String inst){
        this.inst = inst;
        if(this.inst.equals("halt")){
            return String.valueOf(Integer.parseInt("0000000"+op_halt+"0000000000000000000000",2));
        }else{
            return String.valueOf(Integer.parseInt("0000000"+op_noop+"0000000000000000000000",2));
        }
    }
}
