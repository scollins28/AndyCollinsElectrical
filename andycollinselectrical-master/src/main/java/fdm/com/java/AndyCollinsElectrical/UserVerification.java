package fdm.com.java.AndyCollinsElectrical;

public abstract class UserVerification {
	
	private static int loginAttempts = 0;
	private static boolean freezeLogin = false;
	
	
	public static int getLoginAttempts() {
		return loginAttempts;
	}
	public static void setLoginAttempts(int loginAttempts) {
		UserVerification.loginAttempts = loginAttempts;
	}
	public static boolean isFreezeLogin() {
		return freezeLogin;
	}
	public static void setFreezeLogin(boolean freezeLogin) {
		UserVerification.freezeLogin = freezeLogin;
	}
	
	
	

}
