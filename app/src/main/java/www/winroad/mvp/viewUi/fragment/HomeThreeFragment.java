package www.winroad.mvp.viewUi.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;

import www.winroad.R;
import www.winroad.base.BaseMvpFragment;
import www.winroad.basemvp.IPresenter;

public class HomeThreeFragment  extends BaseMvpFragment {
    @NonNull
    @Override
    protected IPresenter onLoadPresenter() {
        return null;
    }

    @NonNull
    @Override
    protected int getLayoutResource() {
        return R.layout.homethree_fragment;
    }

    @Override
    protected void onInitView(Bundle savedInstanceState) {

    }
}
