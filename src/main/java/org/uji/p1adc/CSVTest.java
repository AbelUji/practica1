package org.uji.p1adc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CSVTest {
    private CSV fichero1, fichero2;
    private Table tabla1;
    private TableWithLabels tabla2;

    @org.junit.jupiter.api.Test
    @BeforeEach
    void antesDe() throws FileNotFoundException {
        //Tabla sin etiquetas
        fichero1=new CSV();
        tabla1=fichero1.readTable("src/main/files/miles_dollars.csv");

        //Tabla con etiquetas
        fichero2=new CSV();
        tabla2=fichero2.readTableWithLabels("src/main/files/iris.csv");
    }
    @org.junit.jupiter.api.Test
    @DisplayName("Test numero de filas")
    void numeroFilas(){
        System.out.println("TEST NUMERO DE FILAS");

        //Primera prueba
        System.out.println("Caso 1: numero filas sin etiqueta");
        assertEquals(25,tabla1.getRows().size());
        System.out.println("Salida esperada: "+ 25);
        System.out.println("Salida obtenida: "+ tabla1.getRows().size());

        System.out.println("-----------------------------");

        //Segunda prueba

        System.out.println("Caso 2: numero filas con etiqueta");
        assertEquals(150,tabla2.getRows().size());
        System.out.println("Salida esperada: "+ 150);
        System.out.println("Salida obtenida: "+ tabla2.getRows().size());

    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test numero de columnas")
    void numeroColumnas() {
        //Primera prueba
        System.out.println("Caso 1: numero columnas sin etiqueta");
        assertEquals(2,tabla1.getHeader().size());
        System.out.println("Salida esperada: "+ 2);
        System.out.println("Salida obtenida: "+ tabla1.getRows().size());

        System.out.println("-----------------------------");

        //Segunda prueba
        System.out.println("Caso 2: numero columnas con etiqueta");
        assertEquals(5,tabla2.getHeader().size());
        System.out.println("Salida esperada: "+ 5);
        System.out.println("Salida obtenida: "+ tabla2.getRows().size());

        System.out.println("-----------------------------");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test nombre de etiquetas")
    void nombreEtiquetas() {
        List<String> etiquetas=new ArrayList<>();
        etiquetas.add("Miles");
        etiquetas.add("Dollars");

        //Primera prueba
        System.out.println("Caso 1: nombre etiquetas 1");
        assertEquals(etiquetas,tabla1.getHeader());
        System.out.println("Salida esperada: "+etiquetas);
        System.out.println("Salida obtenida: "+tabla1.getHeader());

        System.out.println("-----------------------------");

        //Segunda prueba

        List<String> etiquetas2=new ArrayList<>();
        etiquetas2.add("sepal length");
        etiquetas2.add("sepal width");
        etiquetas2.add("petal length");
        etiquetas2.add("petal width");
        etiquetas2.add("class");

        System.out.println("Caso 1: nombre etiquetas 2");
        assertEquals(etiquetas2,tabla2.getHeader());
        System.out.println("Salida esperada: "+etiquetas2);
        System.out.println("Salida obtenida: "+tabla2.getHeader());

        System.out.println("-----------------------------");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test numero asignado")
    void numeroAsignado() {
        assertEquals(2,tabla2.getRowAt(130).getNumberClass());
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test recuperar datos")
    void recuperarDatos() {
        List<Double> lista=new ArrayList<>();
        lista.add(4.6);
        lista.add(3.1);
        lista.add(1.5);
        lista.add(0.2);

        assertEquals(lista,tabla2.getRowAt(4).getData());
    }
}