package www.winroad.basemvp;

/**
 * Author：xiaohaibin
 * Time：2017/9/12
 * Emil：xhb_199409@163.com
 * Github：https://github.com/xiaohaibin/
 * Describe：
 */
public interface IPresenter<V extends IView> {

    void attachView(V mvpView);

    void onStart();

    void detachView();

    boolean isViewBind();

}
