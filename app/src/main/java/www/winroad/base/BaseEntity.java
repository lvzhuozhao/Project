package www.winroad.base;

public class BaseEntity {

    private int code = 0;
    private String msg = "";

    private boolean isSuccess;

    public boolean isSuccess() {
        return code == 1;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
