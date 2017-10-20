import java.util.*;

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
        KeepFirstLabel(assembly);//Keep and use it for check
    }

    private void KeepFirstLabel(String[] assembly){
        if(assembly[0].isEmpty()){return;}  //if first label is empty don't keep it
        else{                               //Keep only line which has first label (include start)
            firstLabel.addAll(Arrays.asList(assembly));
        }
    }

    public void printListFirstLabel(){System.out.println("ArrayList of Firstlabel[for checking]: "+"\n"+firstLabel);}

    public void DoProcess(String file){
        //Program Working here
        split(file);
        setAssembly();
        instruction(assembly[1]);
    }

    public boolean HaveFirstLabel(String label){
        //Check if the line of each instruction have the labels that must go to
        if(firstLabel.contains(label)){
            //System.out.println("Have "+label);
            return true;
        }else{
            return false;
        }
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
                if(HaveFirstLabel(field2)){
                    //System.out.println("yes");
                    int temp = firstLabel.indexOf(field2);
                    if(firstLabel.get(temp+1).equals(".fill")){
                        //System.out.println("yes yes");
                        field2 = fill(temp+2,field2);
                    }
                }
                //System.out.println(field2);
                Add add = new Add(field0,field1,field2);
                add.doAdd();
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

    private String fill(int temp,String field){
        field = firstLabel.get(temp);
        //System.out.println(field);
        return field;
    }

}
