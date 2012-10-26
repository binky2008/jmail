package com.huwewa.test;

import com.huwewa.mail.Mail;
import com.huwewa.mail.MailServer;
import com.huwewa.mail.MailServerSetting;

public class Main {
    public static void main(String[] args) {
        String subject = "密码找回";
        String body = "亲爱的会员，您好，您在提交找回密码的请求。以下是您的帐户及密码信息：用户名：aa，密码：8523该密码是临时密码，请您尽快修改密码，感谢使用本系统此为自动发送邮件，请勿直接回复！"
                + "请使用以下链接找回密码 : ";

        Mail mail = new Mail(MailServerSetting.USER_NAME, "bj4312@163.com", subject, body);
        MailServer.send(mail);
    }
}
