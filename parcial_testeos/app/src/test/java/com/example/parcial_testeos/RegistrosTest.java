package com.example.parcial_testeos;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RegistrosTest extends TestCase {

        private Registros registros;
        @Before
        public void SetUp(){
            registros = new Registros();
        }
        @After
        public void tearDown(){
            registros = null;
        }

        @Test
        public void testCalcularFactorial() {
            int resultado = Registros.calcularFactorial(10);
            assertEquals(3628800, resultado);
        }
        @Test
        public void testCalcularFactorial2() {
            int resultado = Registros.calcularFactorial(6);
            assertEquals(720, resultado);
        }
        @Test
        public void testCalcularFactorial3() {
            int resultado = Registros.calcularFactorial(6);
            assertEquals(700, resultado);
        }
}