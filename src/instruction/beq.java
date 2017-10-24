package instruction;

public class beq {
    static String op = "100";
    register rs;
    register rt;

    public beq (String field0,String field1)
    {
        this.rs = new register(field0);
        this.rt = new register(field1);
    }
}
