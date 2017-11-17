package instruction;
/**
 * Created by ASUS on 11/17/2017.
 */
public class R_Type {
    static String op_add = "000" ;
    static String op_nand = "001";
    String inst;
    register rs;
    register rt;
    register rd;
    public R_Type(String inst, String field0, String field1, String field2){
        this.inst = inst;
        this.rs = new register(field0);
        this.rt = new register(field1);
        this.rd = new register(field2);
    }
    public String doAdd_oR_Nand(){
        if(inst.equals("add")){
            return String.valueOf(Integer.parseInt("0000000"+op_add+rs.CheckReg()+rt.CheckReg()+"0000000000000"+rd.CheckReg(),2));
        }else{
            return String.valueOf(Integer.parseInt("0000000"+op_nand+rs.CheckReg()+rt.CheckReg()+"0000000000000"+rd.CheckReg(),2));
        }
    }
}
