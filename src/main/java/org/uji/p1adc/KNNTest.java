package org.uji.p1adc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class KNNTest {
    private List<Double> lista1, lista2, lista3;
    CSV fichero;
    TableWithLabels tabla;

    @BeforeEach
    void antesDe() throws FileNotFoundException {
        fichero=new CSV();
        tabla=fichero.readTableWithLabels("src/main/files/iris.csv");
        lista1= Arrays.asList(3.2,4.0,1.2,3.3);
        lista2= Arrays.asList(1.2,6.0,0.2,2.7);
        lista3= Arrays.asList(5.9,3.0,5.1,1.8);
    }

    @Test
    void estimate() {
        KNN medir=new KNN();
        medir.train(tabla);
        int resultado=medir.estimate(lista1);
        assertEquals(0,resultado);

        resultado=medir.estimate(lista3);
        assertEquals(0,resultado);
    }

    @Test
    void calcularDistancia() {
        KNN medir=new KNN();
        medir.train(tabla);
        assertEquals(3.88, medir.calcularDistancia(lista1,tabla.getRowAt(20).getData()),0.001);
    }
}