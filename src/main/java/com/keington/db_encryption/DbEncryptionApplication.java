package com.keington.db_encryption;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.jasypt.util.text.BasicTextEncryptor;

/**
 * @author Xu.Huaian
 * @date 2022/6/30
 */

@EnableEncryptableProperties
public class DbEncryptionApplication {

    public static void main(String[] args) {

        String account = "root";
        String password = "123456";
        BasicTextEncryptor encryptor = new BasicTextEncryptor();
        //此处为自定义密钥，可以自行修改
        encryptor.setPassword("Keington");
        //密码进行加密
        String newAccount = encryptor.encrypt(account);
        String newPassword = encryptor.encrypt(password);
        System.out.println("加密后账号：" + newAccount);
        System.out.println("加密后密码：" + newPassword);
    }
}