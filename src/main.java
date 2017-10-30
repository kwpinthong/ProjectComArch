/**
 * Created by ASUS on 10/18/2017.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {

    public static void main(String[] args) throws Exception {
        //----Read file and input each line in array-list----//
        Scanner assemblyLine = new Scanner(new File("example.txt"));
        List<String> line = new ArrayList<>();
        while (assemblyLine.hasNextLine()){line.add(assemblyLine.nextLine());}
        String[] temp = line.toArray(new String[0]); //Add every lines form array-list to array
        //---------------------------------------------------//
        //----------Create 2D Array to keep data-------------//
        final int nCols = 6;
        String[][] data = new String[temp.length][nCols];
        for(int i = 0; i < temp.length ; i++){
            for(int j = 0; j < nCols ; j++){
                data[i] = temp[i].split("\t",-1);
            }
        }
        //----------------------------------------------------/
        assembly assembly = new assembly(data,temp.length,nCols);
        assembly.initLable();
        assembly.working();
    }

}