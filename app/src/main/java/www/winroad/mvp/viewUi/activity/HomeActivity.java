package www.winroad.mvp.viewUi.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.RelativeLayout;

import com.chaychan.library.BottomBarLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import www.winroad.R;
import www.winroad.base.BaseMvpActivity;
import www.winroad.mvp.presenter.HomePresenter;
import www.winroad.mvp.viewUi.fragment.HomeOneFragment;
import www.winroad.mvp.viewUi.fragment.HomeThreeFragment;
import www.winroad.mvp.viewUi.fragment.HomeTwoFragment;
import www.winroad.mvp.viewUi.fragment.HomeFourFragment;


public class HomeActivity extends BaseMvpActivity {
    @Bind(R.id.vp_content)
    ViewPager vpContent;
    @Bind(R.id.bbl)
    BottomBarLayout bbl;
    @Bind(R.id.relative)
    RelativeLayout relative;
    private List<Fragment> mFragmentList = new ArrayList<>();


    @Override
    protected HomePresenter onLoadPresenter() {
        return new HomePresenter();
    }

    @Override
    protected int getLayoutResource() {

        return R.layout.activity_home;
    }

    @Override
    protected void onInitialization(Bundle bundle) {
      //  initToolBar(mToolbar, "登录");

        relative.setPadding(0, 0, 0, getNavbarHeight());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        mFragmentList.add(new HomeOneFragment());
        mFragmentList.add(new HomeTwoFragment());
        mFragmentList.add(new HomeThreeFragment());
        mFragmentList.add(new HomeFourFragment());


        vpContent.setAdapter(new MyAdapter(getSupportFragmentManager()));
        bbl.setViewPager(vpContent);
        vpContent.setOffscreenPageLimit(4);
        bbl.setSmoothScroll(true);

        bbl.setUnread(0, 0);//设置第一个页签的未读数为20
        bbl.setUnread(0, 0);//设置第二个页签的未读数
        bbl.setUnread(0, 0);//设置第二个页签的未读数
        bbl.setUnread(0, 0);//设置第二个页签的未读数


        bbl.getBottomItem(4);
    }

    class MyAdapter extends FragmentPagerAdapter {

        public MyAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }
    }
}
