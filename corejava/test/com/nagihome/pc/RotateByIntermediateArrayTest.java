package com.nagihome.pc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.stream.IntStream;

@RunWith(JUnit4.class)
public class RotateByIntermediateArrayTest {

    @Test
    public void testRotateBy3() {
        int[] result = RotateByIntermediateArray.rotate(IntStream.rangeClosed(1, 79).toArray(), 3);
    }
}
