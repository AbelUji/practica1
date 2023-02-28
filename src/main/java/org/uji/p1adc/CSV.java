package org.uji.p1adc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class CSV {
    public Table readTable(String filename) throws IOException {
        Table tabla=new Table();
        BufferedReader br = new BufferedReader(new FileReader("files/iris.csv"));
        String line = br.readLine();
        while (null!=line) {
            String [] fields = line.split(",");
            System.out.println(Arrays.toString(fields));
            line = br.readLine();
        }
        br.close();
        return tabla;
    }
}
