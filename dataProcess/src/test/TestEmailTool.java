package test;

import org.junit.Test;

import tool.EmailTool;

public class TestEmailTool {

	@Test
	public void testSendEmail() {
		String recipient="1010318417@qq.com";
		String sender="tsintian@126.com";
		String host="smtp.126.com";
		String fileName=null;
		String message="The program has completed.";
		String subject="Program status report";
		boolean debug=true;
				
		EmailTool.sendEmail(recipient, sender, host, fileName, message, subject,debug);
	}

}
