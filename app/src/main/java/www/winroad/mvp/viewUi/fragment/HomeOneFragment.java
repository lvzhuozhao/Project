package www.winroad.mvp.viewUi.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.kongzue.titlebar.TitleBar;

import butterknife.Bind;
import butterknife.ButterKnife;
import www.winroad.R;
import www.winroad.base.BaseMvpFragment;
import www.winroad.basemvp.IPresenter;
import www.winroad.entity.NewsPageBean;
import www.winroad.mvp.contract.HomeOneContrcat;
import www.winroad.mvp.presenter.HomeOnePresenter;
import www.winroad.mvp.presenter.HomePresenter;
import www.winroad.mvp.viewUi.adapter.ForumDetailsListAdapter;
import www.winroad.mvp.viewUi.adapter.HomeOneAdapter;


public class HomeOneFragment extends BaseMvpFragment<HomeOnePresenter> implements HomeOneContrcat.View,SwipeRefreshLayout.OnRefreshListener,RecyclerArrayAdapter.OnLoadMoreListener {
    @Bind(R.id.titleBar)
    TitleBar titleBar;
    @Bind(R.id.relative_search)
    RelativeLayout relativeSearch;
    @Bind(R.id.linear_icon)
    LinearLayout linearIcon;
    @Bind(R.id.Recycler)
    EasyRecyclerView mRecycler;
    private HomeOneAdapter homeOneAdapter;

    @NonNull
    @Override
    protected HomeOnePresenter onLoadPresenter() {
        return new HomeOnePresenter();
    }

    @NonNull
    @Override
    protected int getLayoutResource() {
        return R.layout.homeon_fragment;
    }

    @Override
    protected void onInitView(Bundle savedInstanceState) {

        mRecycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecycler.setRefreshingColor(Color.rgb(204, 204, 204), Color.rgb(204, 204, 204), Color.rgb(204, 204, 204));
        mRecycler.setRefreshListener(this);
        mRecycler.setEmptyView(R.layout.empty_view);
        homeOneAdapter = new HomeOneAdapter(getActivity());
        homeOneAdapter.setMore(R.layout.view_more, this);
        homeOneAdapter.setNoMore(R.layout.view_nomore);
        homeOneAdapter.setError(R.layout.view_error, new RecyclerArrayAdapter.OnErrorListener() {

            @Override
            public void onErrorShow() {
                homeOneAdapter.resumeMore();
            }

            @Override
            public void onErrorClick() {
                homeOneAdapter.resumeMore();
            }
        });

        mRecycler.setAdapter(homeOneAdapter);



    }

    @Override
    protected void lazyLoad() {

    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }


    @Override
    public void gethomeOneSuccess(NewsPageBean data) {

    }

    @Override
    public void gethomeOneFailed(String msg) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void onRefresh() {

    }

    @Override
    public void onLoadMore() {

    }
}
