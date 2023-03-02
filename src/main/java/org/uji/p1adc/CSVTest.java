package org.uji.p1adc;

import org.junit.jupiter.api.DisplayName;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class CSVTest {

    @org.junit.jupiter.api.Test
    @DisplayName("Test numero de filas")
    void numeroFilas() throws FileNotFoundException {
        System.out.println("TEST NUMERO DE FILAS");
        //Tabla sin etiquetas
        CSV fichero1=new CSV();
        Table tabla1=fichero1.readTable("src/main/files/miles_dollars.csv");

        //Tabla con etiquetas
        CSV fichero2=new CSV();
        TableWithLabels tabla2=fichero2.readTableWithLabels("src/main/files/iris.csv");

        //Primera prueba

        System.out.println("Caso X: nº filas sin etiqueta");
        assertEquals(25,tabla1.getRows().size());
        System.out.println("Salida esperada: "+ 25);
        System.out.println("Salida obtenida: "+ tabla1.getRows().size());

    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test numero de columnas")
    void numeroColumnas() {
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test nombre de etiquetas")
    void nombreEtiquetas() {
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test numero asignado")
    void numeroAsignado() {
    }

    @org.junit.jupiter.api.Test
    @DisplayName("Test recuperar datos")
    void recuperarDatos() {
    }
}