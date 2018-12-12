package www.winroad.mvp.viewUi.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Toast;


import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;

import butterknife.Bind;
import butterknife.OnClick;
import www.winroad.R;
import www.winroad.base.BaseMvpActivity;
import www.winroad.entity.NewsPageBean;
import www.winroad.mvp.contract.NewsContrcat;
import www.winroad.mvp.presenter.NewsPresenter;
import www.winroad.mvp.viewUi.adapter.CommodityAdapter;
import www.winroad.utils.Dolas;


public class NewActivity extends BaseMvpActivity<NewsPresenter> implements NewsContrcat.newsView {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.recyle)
    RecyclerView recyle;
    private CommodityAdapter commodityAdapter;
    private LinearLayoutManager layoutManager;
    private RefreshLayout mRefreshLayout;
    private int currentPage;


    @Override
    protected NewsPresenter onLoadPresenter() {
        return new NewsPresenter();
    }

    @Override
    protected int getLayoutResource() {
        return R.layout.activity_new;
    }

    @Override
    protected void onInitialization(Bundle bundle) {
        Log.e(">>>>NewListFailed", "");
        initToolBar(toolbar, "新闻");

        initView();

    }

    private void initView() {

        mRefreshLayout = findViewById(R.id.refreshLayout);


    }


    @Override
    public void getNewListSuccess(NewsPageBean data) {


        LoadMore();
    }


    @Override
    public void getNewListFailed(String msg) {
        Log.e(">>>>getNewListFailed", msg);

    }

    @Override
    public void showLoading() {
        Dolas.Doals(NewActivity.this);
        if (currentPage == 1) {
            mRefreshLayout.setEnableRefresh(true);

        }
    }

    @Override
    public void hideLoading() {
        Dolas.DoalsDimess(NewActivity.this);


        if (currentPage == 1) {

            mRefreshLayout.setEnableRefresh(false);

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPresenter.news(1);
        Refresh();

        Log.i(">>>", "onCreate: ");


    }

    public void Refresh() {

        mRefreshLayout.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败

                currentPage = 1;
                mPresenter.news(1);
            }
        });

    }

    public void LoadMore() {

        mRefreshLayout.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore(RefreshLayout refreshlayout) {
                refreshlayout.finishLoadMore(2000/*,false*/);//传入false表示加载失败
                currentPage++;
                mPresenter.news(currentPage);
            }
        });
    }


}
