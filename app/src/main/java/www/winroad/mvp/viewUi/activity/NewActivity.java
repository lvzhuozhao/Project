package www.winroad.mvp.viewUi.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;

import com.hjq.toast.ToastUtils;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.ldoublem.loadingviewlib.LVCircular;

import butterknife.Bind;
import www.winroad.R;
import www.winroad.base.BaseMvpActivity;
import www.winroad.entity.NewsPageBean;
import www.winroad.mvp.contract.NewsContrcat;
import www.winroad.mvp.presenter.NewsPresenter;
import www.winroad.mvp.viewUi.adapter.ForumDetailsListAdapter;
import www.winroad.utils.NetWork;


public class NewActivity extends BaseMvpActivity<NewsPresenter> implements NewsContrcat.newsView, SwipeRefreshLayout.OnRefreshListener, RecyclerArrayAdapter.OnLoadMoreListener {

    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.rv_list)
    EasyRecyclerView mRecyclerView;
    @Bind(R.id.linear)
    LinearLayout linear;

    private int currentPage;
    private ForumDetailsListAdapter forumDetailsListAdapter;
    private SwipeRefreshLayout swipeRefreshLayout;


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
        initToolBar(toolbar, "新闻");


        initView();

    }

    private void initView() {

        LVCircular mLVCircular = new LVCircular(this);
        mLVCircular.setViewColor(Color.rgb(204, 204, 204));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.setRefreshingColor(Color.rgb(204, 204, 204), Color.rgb(204, 204, 204), Color.rgb(204, 204, 204));
        mRecyclerView.setRefreshListener(this);
        mRecyclerView.setEmptyView(R.layout.empty_view);
        forumDetailsListAdapter = new ForumDetailsListAdapter(getApplicationContext());
        forumDetailsListAdapter.setMore(R.layout.view_more, this);
        forumDetailsListAdapter.setNoMore(R.layout.view_nomore);
        forumDetailsListAdapter.setError(R.layout.view_error, new RecyclerArrayAdapter.OnErrorListener() {

            @Override
            public void onErrorShow() {
                forumDetailsListAdapter.resumeMore();
            }

            @Override
            public void onErrorClick() {
                forumDetailsListAdapter.resumeMore();
            }
        });
        swipeRefreshLayout = new SwipeRefreshLayout(this);
        swipeRefreshLayout.setColorSchemeResources(R.color.color_1c1c1c, R.color.color_888888);
        mRecyclerView.setAdapter(forumDetailsListAdapter);


    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onRefresh();

    }

    @Override
    public void getNewListSuccess(NewsPageBean data) {


        if (data != null) {
            forumDetailsListAdapter.addAll(data.getList());
        } else {
            mRecyclerView.showEmpty();
        }
        if (forumDetailsListAdapter.getCount() == 0) {
            mRecyclerView.showEmpty();

        }
        if (currentpage == 1) {
            forumDetailsListAdapter.clear();
            forumDetailsListAdapter.addAll(data.getList());
        }

        if (data.getTotal() <= pageSize) {
            forumDetailsListAdapter.stopMore();
        }

    }


    @Override
    public void getNewListFailed(String msg) {
        mRecyclerView.showEmpty();
        forumDetailsListAdapter.pauseMore();
    }

    @Override
    public void showLoading() {
        if (currentPage == 1) {
            mRecyclerView.setRefreshing(true);
        }
    }

    @Override
    public void hideLoading() {
        if (currentPage == 1) {
            mRecyclerView.setRefreshing(false);

        }
    }


    @Override
    public void onRefresh() {
        getData();
    }

    @Override
    public void onLoadMore() {
        currentpage++;
        getData();
    }

    private void getData() {


        currentPage = 2;

        mPresenter.news(String.valueOf(currentPage));


    }
}
