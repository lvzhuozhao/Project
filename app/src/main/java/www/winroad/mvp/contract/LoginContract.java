package www.winroad.mvp.contract;


import www.winroad.basemvp.IModel;
import www.winroad.basemvp.IView;
import www.winroad.entity.UserInfoBean;

/**
 * Author：xiaohaibin
 * Time：2017/9/16
 * Emil：xhb_199409@163.com
 * Github：https://github.com/xiaohaibin/
 * Describe：
 */
public interface LoginContract {

    interface loginModel extends IModel {

        void login(String username, String pwd);
    }

    interface loginView extends IView {

        void loginSuccess(UserInfoBean infoEntity);

        void loginFailed(String msg);

        void showLoading();

        void hideLoading();

    }

}
