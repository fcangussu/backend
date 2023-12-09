package org.example;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;
import static org.junit.jupiter.api.Assertions.*;

class CalculadoraTest {

    private Calculadora calculadora;

    @BeforeEach
    void setup(){
        calculadora = new Calculadora();
    }
    @Test
    void deveSomar() {
        int resultado = calculadora.somar(4,2);
        assertThat(resultado).isEqualTo(6);
    }
    @Test
    void deveSubtrair() {
        int resultado = calculadora.subtrair(4,2);
        assertEquals(2,resultado);
    }
    @Test
    void deveMultiplicar() {
        var resultado = calculadora.multiplicar(4,2);
        assertEquals(8,resultado);
    }
    @Test
    void deveDividir() {
        var resultado = calculadora.dividir(4,2);
        assertEquals(2,resultado);
    }
    @Test
    void deveDividir_gerarExecaoQuandoDividirPorZero() {

        Throwable exception = catchThrowable(()->calculadora.dividir(4,0));
        assertThat(exception).isInstanceOf(ArithmeticException.class)
                        .hasMessage("/ by zero");
    }
    @Test
    void deveDividir_gerarExecaoQuandoDividirPorZeroB() {
        assertThrows(ArithmeticException.class, () -> {
            calculadora.dividir(4,0);
        });
    }
    @Test
    void exemplo(){
        boolean resultado = true;
        assertTrue(resultado);
    }

}
