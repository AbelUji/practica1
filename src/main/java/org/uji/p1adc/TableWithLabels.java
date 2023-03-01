package org.uji.p1adc;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class TableWithLabels extends Table{
    private Map<String,Integer> labelsToIndex;
    private static int num_clases;

    public TableWithLabels(){
        num_clases=0;
        labelsToIndex=new HashMap<>();
    }

    public void addRow(RowWithLabel fila){
        if (fila.getData().size()!=getHeader().size()){
            throw new ArrayIndexOutOfBoundsException();
        }

        getRows().add(fila);
    }

    public void addEtiqueta(String etiqueta){
        labelsToIndex.put(etiqueta,num_clases++);
    }

    public int getNumClass(){
        return num_clases;
    }

    public Map<String,Integer> getEtiquetas(){
        return labelsToIndex;
    }
    public RowWithLabel getRowAt(int rowNumber){
        if (getRows().size()<rowNumber){
            throw new NoSuchElementException();
        }

        return null;
    }
}
