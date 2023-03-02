package org.uji.p1adc;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class CSV {
    public Table readTable(String filename) throws FileNotFoundException {
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

    public TableWithLabels readTableWithLabels(String filename) throws FileNotFoundException {
        TableWithLabels tabla=new TableWithLabels();

        Scanner lector=new Scanner(new File(filename));
        String linea = lector.nextLine();
        String [] datos=linea.split(",");

        for(String valor: datos){
            tabla.addHeader(valor);
        }

        while (lector.hasNextLine()){
            RowWithLabel fila=new RowWithLabel();
            linea=lector.next();
            datos=linea.split(",");
            for(int i=0;i<datos.length-1;i++){
                fila.addDatoFila(Double.parseDouble(datos[i]));
            }

            if (!tabla.getEtiquetas().containsKey(datos[datos.length-1])){
                tabla.addEtiqueta(datos[datos.length-1]);
            }
            fila.addNumberClass(tabla.getEtiquetas().get(datos[datos.length-1]));
            tabla.addRow(fila);
        }
        return tabla;
    }
}
