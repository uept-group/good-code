package tech.uept.java.good.code.codec;

import org.junit.jupiter.api.Test;

public class CipherUtilTest {

    @Test
    public void test() {
        String pwd1 = "123";// 加密后的密码:202CB962AC59075B964B07152D234B70
        System.out.println("未加密的密码:" + pwd1);
        // 将123加密
        String pwd2 = CipherUtil.generatePassword(pwd1);
        System.out.println("加密后的密码:" + pwd2);
        System.out.print("验证密码是否下确:");
        if (CipherUtil.validatePassword(pwd2, pwd1)) {
            System.out.println("正确");
        } else {
            System.out.println("错误");
        }
    }
}
