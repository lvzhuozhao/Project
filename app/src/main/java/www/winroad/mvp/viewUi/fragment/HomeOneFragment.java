package www.winroad.mvp.viewUi.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;

import www.winroad.R;
import www.winroad.base.BaseMvpFragment;
import www.winroad.basemvp.IPresenter;
import www.winroad.mvp.presenter.HomePresenter;


public class HomeOneFragment extends BaseMvpFragment {
    @NonNull
    @Override
    protected IPresenter onLoadPresenter() {
        return new HomePresenter();
    }

    @NonNull
    @Override
    protected int getLayoutResource() {

        return R.layout.homeon_fragment;


    }

    @Override
    protected void onInitView(Bundle savedInstanceState) {

    }

    @Override
    protected void lazyLoad() {

    }
}
