/**
 * Created by ASUS on 10/18/2017.
 */

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        //----Read file and input each line in array-list----//
        Scanner assemblyLine = new Scanner(new File("example.txt"));
        List<String> line = new ArrayList<>();
        while (assemblyLine.hasNextLine()){line.add(assemblyLine.nextLine());}
        //---------------------------------------------------//
        String[] temp = line.toArray(new String[0]);   //Add every lines form array-list to array
        for(int i = 0; i < temp.length; i++){
            Assembly assembly = new Assembly(temp[i]); //Working for each lines
        }
    }
}