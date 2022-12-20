package com.main.tests;

import org.junit.jupiter.api.Test;

import static junit.framework.Assert.assertEquals;

public class TestMath {
    /**
     * Расчёт суммы двух чисел
     *
     * @param a первое число
     * @param b второе число
     * @return сумма чисел
     */
    public int sum(int a, int b){
        return a+b;
    }
    /**
     * Произведение двух чисел
     *
     * @param a первое число
     * @param b второе число
     * @return произведение двух чисел
     */
    public int multiply(int a, int b){
        return a*b;
    }
    /**
     * Инкрементированное число
     *
     * @param a число
     * @return инкрементированное число
     */
    public int increment(int a){
        return ++a;
    }

    /**
     * Тест корректного суммирования
     */
    @Test
    public void testSum(){
        assertEquals(10, sum(2,8));
    }
    /**
     * Тест корректного произведения двух чисел
     */
    @Test
    public void testMultiply(){
        assertEquals(12, multiply(6,2));
    }
    /**
     * Тест корректного инкрементирования числа
     */
    @Test
    public void testIncrement(){
        assertEquals(7, increment(6));
    }
}
