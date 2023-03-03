package org.uji.p1adc;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CSVTest {
    private CSV fichero1, fichero2, fichero3;
    private Table tabla1, tabla3;
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

        //Tabla vacia
        fichero3=new CSV();
        tabla3=fichero3.readTable("src/main/files/vacio.csv");
    }
    @org.junit.jupiter.api.Test
    @DisplayName("Test numero de filas")
    void numeroFilas(){
        System.out.println("TEST NUMERO DE FILAS");

        //Primera prueba
        System.out.println("Caso 1: fichero vacio");
        assertEquals(0,tabla3.getRows().size());
        System.out.println("Salida esperada: "+ 0);
        System.out.println("Salida obtenida: "+ tabla3.getRows().size());

        System.out.println("-----------------------------");

        //Segunda prueba
        System.out.println("Caso 2: numero filas sin etiqueta");
        assertEquals(25,tabla1.getRows().size());
        System.out.println("Salida esperada: "+ 25);
        System.out.println("Salida obtenida: "+ tabla1.getRows().size());

        System.out.println("-----------------------------");

        //Tercera prueba

        System.out.println("Caso 3: numero filas con etiqueta");
        assertEquals(150,tabla2.getRows().size());
        System.out.println("Salida esperada: "+ 150);
        System.out.println("Salida obtenida: "+ tabla2.getRows().size());

        System.out.println("-----------------------------");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test numero de columnas")
    void numeroColumnas() {
        System.out.println("TEST NUMERO DE COLUMNAS");

        //Primera prueba
        System.out.println("Caso 1: fichero vacio");
        assertEquals(0,tabla3.getHeader().size());
        System.out.println("Salida esperada: "+ 0);
        System.out.println("Salida obtenida: "+ tabla3.getHeader().size());

        System.out.println("-----------------------------");

        //Segunda prueba
        System.out.println("Caso 2: numero columnas sin etiqueta");
        assertEquals(2,tabla1.getHeader().size());
        System.out.println("Salida esperada: "+ 2);
        System.out.println("Salida obtenida: "+ tabla1.getHeader().size());

        System.out.println("-----------------------------");

        //Tercera prueba
        System.out.println("Caso 3: numero columnas con etiqueta");
        assertEquals(5,tabla2.getHeader().size());
        System.out.println("Salida esperada: "+ 5);
        System.out.println("Salida obtenida: "+ tabla2.getHeader().size());

        System.out.println("-----------------------------");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test nombre de etiquetas")
    void nombreEtiquetas() {
        System.out.println("TEST NUMERO DE COLUMNAS");

        List<String> etiquetas=Arrays.asList("Miles","Dollars");

        //Primera prueba
        System.out.println("Caso 1: fichero vacio");
        assertEquals(new ArrayList<>(),tabla3.getHeader());
        System.out.println("Salida esperada: "+new ArrayList<>());
        System.out.println("Salida obtenida: "+tabla3.getHeader());

        System.out.println("-----------------------------");

        //Segunda prueba
        System.out.println("Caso 2: nombre etiquetas 1");
        assertEquals(etiquetas,tabla1.getHeader());
        System.out.println("Salida esperada: "+etiquetas);
        System.out.println("Salida obtenida: "+tabla1.getHeader());

        System.out.println("-----------------------------");

        //Tercera prueba

        List<String> etiquetas2=Arrays.asList("sepal length","sepal width","petal length","petal width","class");

        System.out.println("Caso 3: nombre etiquetas 2");
        assertEquals(etiquetas2,tabla2.getHeader());
        System.out.println("Salida esperada: "+etiquetas2);
        System.out.println("Salida obtenida: "+tabla2.getHeader());

        System.out.println("-----------------------------");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test numero asignado")
    void numeroAsignado() {
        System.out.println("TEST NUMERO ASIGNADO");

        //Primera prueba
        System.out.println("Caso 1: Numero asignado a: "+ tabla2.getRowAt(130).getData());
        assertEquals(2,tabla2.getRowAt(130).getNumberClass());
        System.out.println("Salida esperada: "+2);
        System.out.println("Salida obtenida: "+tabla2.getRowAt(130).getNumberClass());

        System.out.println("-----------------------------");

        //Segunda prueba
        System.out.println("Caso 2: Numero asignado a: "+ tabla2.getRowAt(0).getData());
        assertEquals(0,tabla2.getRowAt(0).getNumberClass());
        System.out.println("Salida esperada: "+0);
        System.out.println("Salida obtenida: "+tabla2.getRowAt(0).getNumberClass());

        System.out.println("-----------------------------");

        //Tercera prueba
        System.out.println("Caso 3: Numero asignado a: "+ tabla2.getRowAt(33).getData());
        assertEquals(0,tabla2.getRowAt(33).getNumberClass());
        System.out.println("Salida esperada: "+0);
        System.out.println("Salida obtenida: "+tabla2.getRowAt(33).getNumberClass());

        System.out.println("-----------------------------");
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test recuperar datos")
    void recuperarDatos() {
        System.out.println("TEST RECUPERAR DATOS");
        List<Double> ej1= Arrays.asList(4.8,3.4,1.6,0.2); //12
        List<Double> ej2= Arrays.asList(6.2,2.2,4.5,1.5); //69
        List<Double> ej3= Arrays.asList(5.8,2.7,5.1,1.9); //102

        //Primera prueba
        System.out.println("Caso 1: Recuperar datos fila 12");
        assertEquals(ej1,tabla2.getRowAt(11).getData());
        System.out.println("Salida esperada: "+ej1);
        System.out.println("Salida obtenida: "+tabla2.getRowAt(11).getData());

        System.out.println("-----------------------------");

        //Segunda prueba
        System.out.println("Caso 2: Recuperar datos fila 69");
        assertEquals(ej2,tabla2.getRowAt(68).getData());
        System.out.println("Salida esperada: "+ej2);
        System.out.println("Salida obtenida: "+tabla2.getRowAt(68).getData());

        System.out.println("-----------------------------");

        //Tercera prueba
        System.out.println("Caso 3: Recuperar datos fila 102");
        assertEquals(ej3,tabla2.getRowAt(101).getData());
        System.out.println("Salida esperada: "+ej3);
        System.out.println("Salida obtenida: "+tabla2.getRowAt(101).getData());

        System.out.println("-----------------------------");
    }
}