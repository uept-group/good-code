package tech.uept.java.good.code.codec;

import java.util.HashMap;
import java.util.Map;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

/**
 * 
 * jwt可以生成永久的token或者时间有限的token 这些取决于众多的参数。
 * 
 * https://www.cnblogs.com/lizm166/p/7844110.html
 * https://zhuanlan.zhihu.com/p/27370773
 * 
 * @author xhrg
 *
 */
public class JwtToken {
    private static String MY_SECRET = "mysecret";// 自己的加盐部分

    public static String createToken() throws Exception {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("alg", "HS256");
        map.put("typ", "JWT");
        String token = JWT.create().withHeader(map)// header
                .withClaim("name", "zwz")// payload
                .withClaim("age", "18").sign(Algorithm.HMAC256(MY_SECRET));// 加密
        return token;
    }

    public static void verifyToken(String token, String key) throws Exception {
        JWTVerifier verifier = JWT.require(Algorithm.HMAC256(key)).build();
        DecodedJWT jwt = verifier.verify(token);
        Map<String, Claim> claims = jwt.getClaims();
        System.out.println(claims.get("name").asString());
    }

    public static void main(String[] args) throws Exception {
        String str = createToken();
        System.out.println(str);
        verifyToken(str, MY_SECRET);

    }
}