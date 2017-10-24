package instruction;

/**
 * Created by ASUS on 10/23/2017.
 */
public class add {
    static String op = "000" ;
    register rs;
    register rt;
    register rd;

    public add(String field0,String field1,String field2){
<<<<<<< HEAD
        this.rs = dec2bin(Integer.valueOf(field0));
        this.rt = dec2bin(Integer.valueOf(field1));
        this.rd = dec2bin(Integer.valueOf(field2));
    }

    private static String dec2bin(int dec){
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
    }
=======
        this.rs = new register(field0);
        this.rt = new register(field1);
        this.rd = new register(field2);
    }

>>>>>>> refs/remotes/origin/master

    public String doAdd(){
        return String.valueOf(Integer.parseInt("0000000"+op+rs.CheckReg()+rt.CheckReg()+"0000000000000"+rd.CheckReg(),2));
    }
}
