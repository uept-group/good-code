package tech.uept.java.good.code.codec;

import org.junit.jupiter.api.Test;

public class MD5Test {

    @Test
    public void test() {
        String abcd = MD5.MD5Encode("abcd");
        System.out.println(abcd);
    }
}
