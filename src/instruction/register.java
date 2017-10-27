package instruction;

public class register {
    String r;
    String tmp;

    public register (String r)
    {
        this.r = r;
    }

    public String CheckReg()
    {
        switch(r) {
            case "0":
                tmp = "000";
                break;
            case "1":
                tmp = "001";
                break;
            case "2":
                tmp = "010";
                break;
            case "3":
                tmp = "011";
                break;
            case "4":
                tmp = "100";
                break;
            case "5":
                tmp = "101";
                break;
            case "6":
                tmp = "110";
                break;
            case "7":
                tmp = "111";
                break;
            default:
                tmp = "Error on Register";
        }

        return tmp;
    }
}
