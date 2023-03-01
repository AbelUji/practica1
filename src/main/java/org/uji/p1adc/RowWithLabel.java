package org.uji.p1adc;

public class RowWithLabel extends Row{
    int numberClass;

    public RowWithLabel(){
        super();
        numberClass=-1;
    }

    public void addNumberClass(int numero){
        numberClass=numero;
    }
    public int getNumberClass(){
        return numberClass;
    }


}
