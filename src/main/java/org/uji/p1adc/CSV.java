package org.uji.p1adc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class CSV {
    public Table readTable(String filename) throws IOException {
        Table tabla=new Table();
        Scanner lector=new Scanner(new File(filename));
        String linea = lector.nextLine();
        String [] datos=linea.split(",");
        for(String valor: datos){
            tabla.addHeader(valor);
        }

        while (lector.hasNextLine()){
            Row fila=new Row();
            linea=lector.next();
            datos=linea.split(",");
            for(String valor: datos){
                fila.addDatoFila(Double.parseDouble(valor));
            }
            tabla.addRow(fila);
        }
        return tabla;
    }
}
