package com.nagihome.pc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.stream.IntStream;

@RunWith(JUnit4.class)
public class RotateArrayByItSelfTest {

    @Test
    public void testRotateBy3() {
        int[] result = RotateArrayByItSelf.rotate(IntStream.rangeClosed(1, 6).toArray(), 3);
    }

}
