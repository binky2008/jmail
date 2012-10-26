package com.huwewa.mail;

import java.util.Date;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.NoSuchProviderException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 * 邮件服务类
 * 
 * @author 1643
 * 
 */
public class MailServer {

	private static MailServer install = null;

	private Transport transport = null;
	
	private Session session = null;

	/**
	 * 获取邮件服务器单例
	 * 
	 * @return
	 */
	private static MailServer getInstall() {
		if (null == install) {
			install = new MailServer();
		}

		return install;
	}

	private MailServer() {
		try {
			Properties props = new Properties();
			props.put("mail.smtp.host", MailServerSetting.STMP_HOST);
			props.put("mail.smtp.port", MailServerSetting.STMP_PORT);
			props.put("mail.smtp.auth", MailServerSetting.STMP_AUTH);
			props.put("mail.debug", MailServerSetting.DEBUG);

			session = Session.getDefaultInstance(props);
			
			transport = session.getTransport("smtp");
			transport.connect(MailServerSetting.USER_NAME, MailServerSetting.PASSWORD);
		} catch (NoSuchProviderException e) {
			e.printStackTrace();
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 发送邮件
	 * @param mail
	 * @return
	 */
	public static int send(Mail mail) {
		Transport transport = MailServer.getInstall().transport;
		Session session = MailServer.getInstall().session;
		
		MimeMessage msg = new MimeMessage(session);
		try {
			msg.setSentDate(new Date());
			InternetAddress fromAddress = new InternetAddress(mail.getFrom());//from
			msg.setFrom(fromAddress);
			InternetAddress[] toAddress = new InternetAddress[1];
			toAddress[0] = new InternetAddress(mail.getTo());//to
			msg.setRecipients(Message.RecipientType.TO, toAddress);
			msg.setSubject(mail.getSubject(), "UTF-8");
			msg.setText(mail.getBody(), "UTF-8");
			msg.saveChanges();
			transport.sendMessage(msg, msg.getAllRecipients());
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
}
