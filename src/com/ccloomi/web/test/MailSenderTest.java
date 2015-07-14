package com.ccloomi.web.test;

import com.ccloomi.core.component.email.MailSender;
import com.ccloomi.core.component.email.bean.Mail;
import com.ccloomi.test.BaseSpringTest;

/**© 2015-2015 CCLooMi.Inc Copyright
 * 类    名：MailSenderTest
 * 类 描 述：
 * 作    者：Chenxj
 * 邮    箱：chenios@foxmail.com
 * 日    期：2015年7月13日-下午10:46:47
 */
public class MailSenderTest extends BaseSpringTest{
	public static void main(String[] args) {
		MailSender ms=ctx.getBean("mailSender", MailSender.class);
		Mail mail=new Mail();
		mail.setSubject("Test mail.");
		mail.setTo("chenxianjun@idccapp.com");
		mail.setHtmlBody("Hello this is a test mail.");
		ms.sendMail(mail);
	}
}
