package com.huwewa.mail;

/**
 * 邮件实体
 * @author 1643
 *
 */
public class Mail {
	
	private String from;//来自
	
	private String to;//发往
	
	private String subject;//邮件主题
	
	private String body;//邮件内容
	
	public Mail() {}

	/**
	 * 
	 * @param from 来自
	 * @param to 发往
	 * @param subject 邮件主题
	 * @param body 邮件内容
	 */
	public Mail(String from, String to, String subject, String body) {
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.body = body;
	}
	
	/**
	 * 来自
	 * @return
	 */
	public String getFrom() {
		return from;
	}

	/**
	 * 来自
	 * @param from
	 */
	public void setFrom(String from) {
		this.from = from;
	}

	/**
	 * 发往
	 * @return
	 */
	public String getTo() {
		return to;
	}

	/**
	 * 发往
	 * @param to
	 */
	public void setTo(String to) {
		this.to = to;
	}

	/**
	 * 邮件主题
	 * @return
	 */
	public String getSubject() {
		return subject;
	}

	/**
	 * 邮件主题
	 * @param subject
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}

	/**
	 * 邮件内容
	 * @return
	 */
	public String getBody() {
		return body;
	}

	/**
	 * 邮件内容
	 * @param body
	 */
	public void setBody(String body) {
		this.body = body;
	}

}
