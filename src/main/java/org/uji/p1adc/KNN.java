package org.uji.p1adc;

import java.util.List;

public class KNN {
    private TableWithLabels tabla;
    public void train(TableWithLabels data){
        tabla=data;
    }

    public Integer estimate(List<Double> data){
        double dist_min=-1;
        int numero_clase=-1;
        List<Row> lista= tabla.getRows();

        for (int i=0; i< lista.size();i++){
            RowWithLabel fila= (RowWithLabel) tabla.getRows().get(i);
            double num_euclidea=calcularDistancia(fila.getData(),data);
            if (num_euclidea<dist_min || dist_min==-1){
                dist_min=num_euclidea;
                numero_clase=tabla.getRowAt(i).getNumberClass();
            }
        }
        return numero_clase;
    }

    public double calcularDistancia(List<Double> dato1,List<Double> dato2){
        double suma=0;
        for (int i=0;i<dato1.size();i++){
            suma+=Math.pow((dato1.get(i)-dato2.get(i)),2);
        }
        return Math.sqrt(suma);
    }
}
