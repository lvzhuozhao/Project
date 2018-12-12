package www.winroad.mvp.contract;

import www.winroad.basemvp.IModel;
import www.winroad.basemvp.IView;

/**
 * Author：xiaohaibin
 * Time：2017/9/16
 * Emil：xhb_199409@163.com
 * Github：https://github.com/xiaohaibin/
 * Describe：
 */
public interface HomeContract {

    interface homeModel extends IModel {

        void homemodel();
    }

    interface homeView extends IView {

        void homeSuccess();

        void homeFailed(String msg);

        void showLoading();

        void hideLoading();

    }

}
