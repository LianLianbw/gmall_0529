package com.atguigu.gmall.payment.config;

public class GmallAlipayConfig {

    public static String app_id = "2016092200568607"; //沙箱的id

    public static String merchant_private_key = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDLjJwmaPSX/z3Sc1GZkhnSRhsIt5HUbd3adiHKwu4tqZiDJE8CJuPJ6OCr5qmM8Gj1euD2Y2wuwZv478cuMypbqLCFZIg3tYRmCCFu0OiWTHOcSlecOsqe0XC40WuDZurmWn3WRHG2WIsu0NQ9lB283BLbjW2plZgUzqj9xRE29kxus6PkcqvflcApTYJEPO0bGEc6FQW79FUiG0HygRA75tOtYGrXX/+qoPYgDh0jxConrkpDVO6GoNvYb2bNghoXx+2Rq7Xq1f+7o0EusiefTbNYgFu2Hr0busN8BMLOBERZcZy1o48IJl41XCd2HEBPI7ycH2eTSW6cyNcrv8BpAgMBAAECggEBAKakaTpw9r5xspVW39lQaV9jEcLjNrqpb9XonOW5DPHJRRkoYp6qZBbrVvSlFO5T7Dn87awJ3Ymx7BWziGfkb6s2wb2TfonNS6WUxnpJAgH6eTPdETjQUQ4Q/a3xlYmwemM4doky472bY+diBECdwHLb4XxpnvwVgrqWLngEHIHXUDBGk0Ke+1mibakWGN3qjB96dTuE5qbUAs5b+L9mCUlurZiRlNYqkpy3WuluFapBAyBV0A+OcRf77C8oPR4zg1/KmLgXTepfH5HzVly/pqsOp2ojo93ZWZXFdnxh6x++c4AAFGGf1kALSFOrnx60yriSumCB43p8ssw3O6M0jjkCgYEA9M1dxsc1OQkBhkERZ9gx6nq735xb6mJiGBSRDsDthZ4wncm0tjuNNGZjt8ZErvvO1a3Ys2wBuHitQZmmkaWPHIPwDidFYjYHekk7RDtn6RVnYV2A5JNZq/7YIo/GjKVlPUXPxavbt+ZugKsD8ocxKpDrSh+jC3E1TMce1SKdj58CgYEA1Nwr7RU2qfaHXbkThzeqlPPxKU2JJ4IsBQbAVuybqLJrX1FFjfZWiSidDaQ0e9kfm1VAwrO4F7nba7NiQfV+iz24oLK+A53Xmyua6mO4nfiY7WNLNIVs2RUt6y8sTWpo+1i97A/gmDLb5/dIjZec/aakr0bE4kgTl3ZS1ja/EvcCgYBTo0Kx4mfNt8T8kIiY2SWcvhgoOuywdLKdFZHF36aHK1fi4QJL7Ka+y2iwZh4bRs8Q9FeAXZts4lYXfp6JTm5JyM4gl8w91MXTQufr1PwYh4aNnnumHK3bdLN1g3fLn8qqF4r4N1JXT3Rbo5Iyr3vd1it9ZLe49hHGzJU9Lpl0cwKBgAlO/5TEorlYEJ9mopX9NzaAXIGD5IWXybkGjI7AliYQd2WZtkL5DNu+rO+VyL3JxvoSBlz9YwWWmSPiml9sDvaj4lkUt/6MfotIouOxLLer0XRALV/Enff4VyO70mIoTyL+xH94SkgdoURJqiCXCsSE7xrDK4UBxemPwRuhFUYNAoGAWqh0nzWO1uTaG51YstidB1Y4eL0BSWk68piBB+nl2oxX9AIe5pLvab20zWH56Kvo4T8WDtM/RFCxyJMXrDvwRsqe1VWyxmE5ayb8RLrQLQMDvVGb72Wpgc6Cj+w1NCobX06yw3UxPeGZSqMGJC2duXakcpOwEWadNPYYkbYdkc4=";

    public static String alipay_public_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDIgHnOn7LLILlKETd6BFRJ0GqgS2Y3mn1wMQmyh9zEyWlz5p1zrahRahbXAfCfSqshSNfqOmAQzSHRVjCqjsAw1jyqrXaPdKBmr90DIpIxmIyKXv4GGAkPyJ/6FTFY99uhpiq0qadD/uSzQsefWo0aTvP/65zi3eof7TcZ32oWpwIDAQAB";

    // http://lfy.natapp4.cc  本机的8888
    public static String notify_url = "http://lfy.natapp4.cc/" //隧道,要自己去买
            + "/updateOrderStatus";//支付成功后异步的一个通知调用

    //去订单列表
    public static String return_url = "http://lfy.natapp4.cc/orderList";//支付成功后需要跳到的用户页面

    public static String sign_type = "RSA";//非对称加密算法

    public static String charset = "utf-8";

    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
}
