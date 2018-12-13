package www.winroad.mvp.viewUi.fragment;

import android.os.Bundle;

import www.winroad.R;
import www.winroad.base.BaseMvpActivity;
import www.winroad.base.BaseMvpFragment;
import www.winroad.basemvp.IPresenter;

public class HomeTwoFragment extends BaseMvpFragment {
    @Override
    protected IPresenter onLoadPresenter() {
        return null;
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.hometwo_fragment;
    }

    @Override
    protected void onInitView(Bundle savedInstanceState) {

    }


}
