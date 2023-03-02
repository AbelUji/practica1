package org.uji.p1adc;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class TableWithLabels extends Table{
    private Map<String,Integer> labelsToIndex;

    public TableWithLabels(){
        labelsToIndex=new HashMap<>();
    }

    public void addRow(RowWithLabel fila){
        if (fila.getData().size()!=getHeader().size()-1){
            throw new ArrayIndexOutOfBoundsException();
        }

        getRows().add(fila);
    }

    public void addEtiqueta(String etiqueta){
        labelsToIndex.put(etiqueta,labelsToIndex.size());
    }


    public Map<String,Integer> getEtiquetas(){
        return labelsToIndex;
    }

    @Override
    public RowWithLabel getRowAt(int rowNumber){
        if (getRows().size()<rowNumber){
            throw new NoSuchElementException();
        }

        return (RowWithLabel) getRows().get(rowNumber);
    }
}
