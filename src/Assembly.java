import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;

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
    List<String> firstLabel = new ArrayList<>();

    private void split(String file){
        //Only do split each label to each array 0 - 5 (first-label,instruction,value1,value2,value3,comment)
        assembly = file.split("\t",-1);
    }

    public void SplitForKeep(String file){
        split(file);
        KeepFirstLabel(assembly);
    }

    private void KeepFirstLabel(String[] assembly){
        if(assembly[0].isEmpty()){
            // if first label is empty don't keep it
            return;
        }else{
            firstLabel.addAll(Arrays.asList(assembly));
        }
    }

    public void printListFirstLabel(){System.out.println(firstLabel);}

    public void DoProcess(String file){
        split(file);
        setAssembly();
        instruction(assembly[1]);
    }

    public void CheckLabel(String label){
        if(firstLabel.contains(label)){
            System.out.println("Have "+label);
        }else{return;}
    }

    public void setAssembly(){
        this.label = assembly[0];
        this.inst = assembly[1];
        this.field0 = assembly[2];
        this.field1 = assembly[3];
        this.field2 = assembly[4];
        this.comment = assembly[5];
    }

    public void instruction(String command){
        System.out.println("do : " + command);
        switch (command){
            case "add":
                //call function
                CheckLabel(field1);
                CheckLabel(field2);
                //System.out.println(field2);
                //Add add = new Add(field0,field1,field2);
                //add.doAdd();
                //inst = "000";
                break;
            case "nand":
                //call function
                //inst = "001";
                break;
            case "lw" :
                //call function
                break;
            case "sw" :
                //call function
                break;
            case "beq" :
                //call function
                //inst = "100";
                break;
            case "jalr" :
                //call function
                break;
            case "halt" :
                //call function
                break;
            case "noop" :
                //call function
                //inst = "111";
                break;
            default:break;
        }
        System.out.println("\n");
    }
}
