/**
 * Created by ASUS on 10/18/2017.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class main {
    public static File file = new File("example.txt");
    //public static File file = new File("example2.txt");
    //public static File file = new File("mycombtest.txt");
    //public static File file = new File("combine.txt");
    public static void main(String[] args) throws IOException {
        //----Read file and input each line in array-list----//
        Scanner assemblyLine = new Scanner(file);
        List<String> line = new ArrayList<>();
        while (assemblyLine.hasNextLine()){line.add(assemblyLine.nextLine());}
        String[] temp = line.toArray(new String[0]); //Add every lines from arrayList to array
        //---------------------------------------------------//
        //----------Create 2D Array to keep data-------------//
        final int nCols = 6;
        String[][] data = new String[temp.length][nCols];
        for(int i = 0; i < temp.length ; i++){
            for(int j = 0; j < nCols ; j++){
                data[i] = temp[i].split("\\s+");
            }
        }
        //----------------------------------------------------/
        assembler assembler = new assembler(data,temp.length,nCols);
        assembler.working();
    }
}