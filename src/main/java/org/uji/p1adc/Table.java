package org.uji.p1adc;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class Table {
    private List<String> header;
    private List<Row> rows;

    public Table(){
        super();
        header=new ArrayList<>();
        rows=new ArrayList<>();
    }
    public Row getRowAt(int rowNumber){
        if (rows.size()<rowNumber){
            throw new NoSuchElementException();
        }

        return rows.get(rowNumber-1);
    }

    public void addHeader(String cabecera){
        header.add(cabecera);
    }

    public void addRow(Row fila){
        if (fila.getData().size()!=header.size()){
            throw new ArrayIndexOutOfBoundsException();
        }

        rows.add(fila);
    }
}
