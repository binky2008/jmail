package com.huwewa.mail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 邮件服务器配置
 * @author 1643
 *
 */
public class MailServerSetting {

    /**
     * stmp 服务器
     */
    public static String STMP_HOST;

    /**
     * stmp 端口
     */
    public static int STMP_PORT;

    /**
     * 是否进行认证
     */
    public static boolean STMP_AUTH;

    /**
     * 是否是debug模式
     */
    public static boolean DEBUG;

    /**
     * 用户名
     */
    public static String USER_NAME;

    /**
     * 使用的协议
     */
    public static String PROTOCOL;

    /**
     * 密码
     */
    public static String PASSWORD;

    static {
        Properties pro = new Properties();
        try {
            pro.load(new FileInputStream(new File(MailServerSetting.class.getResource("/").getPath()
                    + "/mailServer.properties")));
            STMP_HOST = pro.getProperty("mail.smtp.host");
            STMP_PORT = Integer.parseInt(pro.getProperty("mail.smtp.port"));
            STMP_AUTH = Boolean.parseBoolean(pro.getProperty("mail.smtp.auth"));
            DEBUG = Boolean.parseBoolean(pro.getProperty("mail.debug"));
            USER_NAME = pro.getProperty("mail.userName");
            PASSWORD = pro.getProperty("mail.password");
            PROTOCOL = pro.getProperty("mail.transport.protocol");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
