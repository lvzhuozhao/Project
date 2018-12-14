package www.winroad.mvp.presenter;

import android.text.TextUtils;

import rx.Subscription;
import www.winroad.basemvp.BasePresenter;
import www.winroad.data.callback.LoadTaskCallback;
import www.winroad.entity.NewsPageBean;
import www.winroad.mvp.contract.HomeOneContrcat;
import www.winroad.mvp.contract.NewsContrcat;
import www.winroad.remote.TasksRepositoryProxy;

public class HomeOnePresenter extends BasePresenter<HomeOneContrcat.View> implements HomeOneContrcat.HomeOneModel {


    @Override
    public void news(String mid) {



        if (getView() == null) {
            return;
        }


            Subscription subscription = TasksRepositoryProxy.getInstance().getNews(mid, new LoadTaskCallback<NewsPageBean>() {

                @Override
                public void onTaskLoaded(NewsPageBean data) {


                    getView().gethomeOneSuccess(data);


                }

                @Override
                public void onDataNotAvailable(String msg) {

                    getView().gethomeOneFailed(TextUtils.isEmpty(msg) ? "服务器请求失败，请重试" : msg);

                }

                @Override
                public void onStart() {
                    getView().showLoading();
                }


                @Override
                public void onCompleted() {
                    getView().hideLoading();

                }
            });

            addSubscription(subscription);



    }


}
