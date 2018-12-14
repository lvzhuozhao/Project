package www.winroad.mvp.contract;


import www.winroad.basemvp.IModel;
import www.winroad.basemvp.IPresenter;
import www.winroad.basemvp.IView;
import www.winroad.entity.NewsPageBean;

public interface HomeOneContrcat {

    interface HomeOneModel extends IModel {
        void news(String mid);
    }

    interface View extends IView {

        void gethomeOneSuccess(NewsPageBean data);

        void gethomeOneFailed(String msg);

        void  showLoading();

        void  hideLoading();
    }

}
