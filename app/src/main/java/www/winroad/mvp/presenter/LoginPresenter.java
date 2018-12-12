package www.winroad.mvp.presenter;

import android.text.TextUtils;
import android.util.Log;



import rx.Subscription;
import www.winroad.basemvp.BasePresenter;
import www.winroad.data.callback.LoadTaskCallback;
import www.winroad.entity.UserInfoBean;
import www.winroad.mvp.contract.LoginContract;
import www.winroad.remote.TasksRepositoryProxy;

import static android.content.ContentValues.TAG;


public class LoginPresenter extends BasePresenter<LoginContract.loginView> implements LoginContract.loginModel {
    @Override
    public void login(String username, String pwd) {

        if (TextUtils.isEmpty(username)) {
            Log.e(TAG, "login: " + username);
            return;
        }
        if (TextUtils.isEmpty(pwd)) {
            Log.e(TAG, "login: " + pwd);
            return;
        }


        Subscription login = TasksRepositoryProxy.getInstance().login(username, pwd, new LoadTaskCallback<UserInfoBean>() {
            @Override
            public void onTaskLoaded(UserInfoBean data) {

                getView().loginSuccess(data);
            }

            @Override
            public void onDataNotAvailable(String msg) {

                getView().loginFailed(msg);
            }
        });
        addSubscription(login);
    }
}
