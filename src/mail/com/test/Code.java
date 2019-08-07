package mail.com.test;

public class Code {

	public static String getDecryptPassword(String password) {

		StringBuffer sb = new StringBuffer(password);

		return sb.reverse().toString();
	}
}
