package security.services;

import jdk.jshell.execution.Util;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import security.util.MathUtil;

public class _7DevideTest {
    @Test
    public void testShouldThrowExceptionWhenDenominatorIsZero(){
        Assertions.assertThrows(ArithmeticException.class,()-> MathUtil.devide(4,0));

    }
}
