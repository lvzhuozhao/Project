package www.winroad.base;

public interface OnPermissionResponseListener {
    void onSuccess(String[] permissions);
    void onFail();
}
