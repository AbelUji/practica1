package org.uji.p1adc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KNNTest {
    private List<Double> lista1, lista2, lista3,lista4,lista5;
    CSV fichero;
    TableWithLabels tabla;

    @BeforeEach
    void antesDe() throws FileNotFoundException {
        fichero=new CSV();
        tabla=fichero.readTableWithLabels("src/main/files/iris.csv");
        lista1= Arrays.asList(3.2,4.0,1.2,3.3);
        lista2= Arrays.asList(1.2,6.0,0.2,2.7);
        lista3= Arrays.asList(5.9,3.0,5.1,1.8);
        lista4= Arrays.asList(0.0,0.0,0.0,0.0);
    }

    @Test
    void estimate() {
        System.out.println("TEST ESTIMACION");
        KNN medir=new KNN();
        medir.train(tabla);
        int resultado=medir.estimate(lista1);

        //Primera prueba
        System.out.println("Caso 1: Estimacion de: " + lista1);
        assertEquals(0,resultado);
        System.out.println("Salida esperada: "+0);
        System.out.println("Salida obtenida: "+resultado);

        System.out.println("-----------------------------");

        //Segunda prueba
        System.out.println("Caso 2: Estimacion de: " + lista3);
        resultado=medir.estimate(lista3);
        assertEquals(2,resultado);
        System.out.println("Salida esperada: "+2);
        System.out.println("Salida obtenida: "+resultado);

        System.out.println("-----------------------------");

        //Tercera prueba
        System.out.println("Caso 3: Estimacion de: " + lista4);
        resultado=medir.estimate(lista4);
        assertEquals(0,resultado);
        System.out.println("Salida esperada: "+0);
        System.out.println("Salida obtenida: "+resultado);

        System.out.println("-----------------------------");
    }

    @Test
    void calcularDistancia() {
        System.out.println("TEST CALCULAR DISTANCIA");
        KNN medir=new KNN();
        medir.train(tabla);

        //Primera prueba
        System.out.println("Caso 1: Calcular distanciade "+tabla.getRowAt(70).getData()+" con: " + lista1);
        double resultado=medir.calcularDistancia(lista1,tabla.getRowAt(70).getData());
        assertEquals(4.81,resultado,0.01);
        System.out.println("Salida esperada: "+4.81);
        System.out.println("Salida obtenida: "+Math.round(resultado*100d)/100d);

        System.out.println("-----------------------------");

        //Segunda prueba
        System.out.println("Caso 2: Calcular distancia de "+tabla.getRowAt(149).getData()+" con: " + lista2);
        resultado=medir.calcularDistancia(lista2,tabla.getRowAt(149).getData());
        assertEquals(7.48,resultado,0.01);
        System.out.println("Salida esperada: "+7.48);
        System.out.println("Salida obtenida: "+Math.round(resultado*100d)/100d);

        System.out.println("-----------------------------");

        //Tercera prueba
        System.out.println("Caso 3: Calcular distancia de "+tabla.getRowAt(0).getData()+" con: " + lista4);
        resultado=medir.calcularDistancia(lista4,tabla.getRowAt(0).getData());
        assertEquals(6.35,resultado,0.01);
        System.out.println("Salida esperada: "+6.35);
        System.out.println("Salida obtenida: "+Math.round(resultado*100d)/100d);

        System.out.println("-----------------------------");
    }
}