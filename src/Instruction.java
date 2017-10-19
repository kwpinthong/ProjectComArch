import java.util.List;

/**
 * Created by ASUS on 10/19/2017.
 */
public class Instruction {

    String[] instruction;

    public void setInstruction(List<String> command){
        instruction = command.toArray(new String[0]);
        for(int i = 0; i < instruction.length; i++){
            System.out.println(instruction[i]);
        }
    }
}
