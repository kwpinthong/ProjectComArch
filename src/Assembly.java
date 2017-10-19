/**
 * Created by ASUS on 10/19/2017.
 */
public class Assembly {
    String[] assembly;

    public Assembly(String file){
        assembly = file.split("\t",-1); //split each label to each array 0 - 5 (first-label,instruction,value1,value2,value3,comment)
        callFunction();                             //send to callFunction
    }

    public void callFunction(){
        if(assembly[0].equals("start")){
            System.out.println("Have Start"); //Start loop
            instruction(assembly[1]);
        }else{
            instruction(assembly[1]);
        }
    }

    public void instruction(String command){
        switch (command){
            case "add":
                //call function
                System.out.println("do add");
                break;
            case "nand":
                //call function
                System.out.println("do nand");
                break;
            case "lw" :
                //call function
                System.out.println("do lw");
                break;
            case "sw" :
                //call function
                System.out.println("do sw");
                break;
            case "beq" :
                //call function
                System.out.println("do beq");
                break;
            case "jalr" :
                //call function
                System.out.println("do jalr");
                break;
            case "halt" :
                //call function
                System.out.println("do halt");
                break;
            case "noop" :
                //call function
                System.out.println("do noop");
                break;
            default:break;
        }
    }

}
