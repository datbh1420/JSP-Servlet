package dat.registration;

import java.io.Serializable;


public class InsertRegistrationError implements Serializable{
    private String usernameLengthErr;
    private String passwordLengthErr;
    private String confirmNotMath;
    private String fullnameLengthErr;
    private String usernameIsExistErr;

    public String getUsernameLengthErr() {
        return usernameLengthErr;
    }

    public void setUsernameLengthErr(String usernameLengthErr) {
        this.usernameLengthErr = usernameLengthErr;
    }

    public String getPasswordLengthErr() {
        return passwordLengthErr;
    }

    public void setPasswordLengthErr(String passwordLengthErr) {
        this.passwordLengthErr = passwordLengthErr;
    }

    public String getConfirmNotMath() {
        return confirmNotMath;
    }

    public void setConfirmNotMath(String confirmNotMath) {
        this.confirmNotMath = confirmNotMath;
    }

    public String getFullnameLengthErr() {
        return fullnameLengthErr;
    }

    public void setFullnameLengthErr(String fullnameLengthErr) {
        this.fullnameLengthErr = fullnameLengthErr;
    }

    public String getUsernameIsExistErr() {
        return usernameIsExistErr;
    }

    public void setUsernameIsExistErr(String usernameIsExistErr) {
        this.usernameIsExistErr = usernameIsExistErr;
    }
    
    
}
