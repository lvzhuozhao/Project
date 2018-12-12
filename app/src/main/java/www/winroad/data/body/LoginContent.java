package www.winroad.data.body;



public class LoginContent {


    private String username;
    private String passwd;
    private long time;
    private String sign;

    public LoginContent(String username, String passwd) {
        this.passwd=passwd;
        this.username = username;
        this.time=System.currentTimeMillis();
        this.sign=sign;
    }
}
