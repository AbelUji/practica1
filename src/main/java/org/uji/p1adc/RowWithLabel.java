package org.uji.p1adc;

public class RowWithLabel extends Row{
    private int numberClass;

    public RowWithLabel(){
        super();
        numberClass=0;
    }

    public void addNumberClass(int numero){
        numberClass=numero;
    }
    public int getNumberClass(){
        return numberClass;
    }


}
