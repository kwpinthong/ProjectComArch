/**
 * Created by ASUS on 10/19/2017.
 */
public class Assembly {
    /*
    ///////////////////////////////////////////////////////
    //List value from assembly[] to String variables
    ///////////////////////////////////////////////////////
    label   = assembly[0];
    inst    = assembly[1];
    field0  = assembly[2];
    field1  = assembly[3];
    field2  = assembly[4];
    comment = assembly[5];
    */
    String[] assembly;
    String label;
    String inst;
    String field0;
    String field1;
    String field2;
    String comment;

    public Assembly(String file){
        assembly = file.split("\t",-1); //split each label to each array 0 - 5 (first-label,instruction,value1,value2,value3,comment)
        for (int i = 0 ; i < assembly.length ; i++)System.out.println("test : Assembly No." + i +"\t" + assembly[i]);//Check if evey labels in it's place
        instruction(assembly[1]); //send to callFunction
    }

    public void instruction(String command){
        System.out.println("do : " + command);
        switch (command){
            case "add":
                //call function
                break;
            case "nand":
                //call function
                break;
            case "lw" :
                //call function
                break;
            case "sw" :
                //call function
                break;
            case "beq" :
                //call function
                inst = "100";
                break;
            case "jalr" :
                //call function
                break;
            case "halt" :
                inst="110"; //sent the halt machine code out
                //warn simulator that PC is halted
                try {
                    throw new HaltException();
                } catch (HaltException e) {
                    System.out.println("End of the line"); //Print out warning
                }
                break;
            case "noop" :
                //call function
                inst = "111";
                break;
            default:break;
        }
        System.out.println("\n");
    }
}
