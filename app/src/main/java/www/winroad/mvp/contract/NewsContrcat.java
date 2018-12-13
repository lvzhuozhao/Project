package www.winroad.mvp.contract;


import www.winroad.basemvp.IModel;
import www.winroad.basemvp.IView;
import www.winroad.entity.NewsPageBean;

public interface NewsContrcat {

    interface newsModel extends IModel {
        void news(String mid);
    }

    interface newsView extends IView {

        void getNewListSuccess(NewsPageBean data);

        void getNewListFailed(String msg);

        void  showLoading();

        void  hideLoading();
    }

}
