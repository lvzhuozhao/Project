package www.winroad.mvp.presenter;

import android.text.TextUtils;


import com.hjq.toast.ToastUtils;

import rx.Subscription;
import www.winroad.StaticUtil;
import www.winroad.basemvp.BasePresenter;
import www.winroad.data.callback.LoadTaskCallback;
import www.winroad.entity.NewsPageBean;
import www.winroad.mvp.contract.NewsContrcat;
import www.winroad.remote.TasksRepositoryProxy;
import www.winroad.utils.NetWork;

public class NewsPresenter extends BasePresenter<NewsContrcat.newsView> implements NewsContrcat.newsModel {


    @Override
    public void news(String mid) {



        if (getView() == null) {
            return;
        }


            Subscription subscription = TasksRepositoryProxy.getInstance().getNews(mid, new LoadTaskCallback<NewsPageBean>() {

                @Override
                public void onTaskLoaded(NewsPageBean data) {


                    getView().getNewListSuccess(data);


                }

                @Override
                public void onDataNotAvailable(String msg) {

                    getView().getNewListFailed(TextUtils.isEmpty(msg) ? "服务器请求失败，请重试" : msg);

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
