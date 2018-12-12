package www.winroad.mvp.viewUi.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.Toast;

import com.chaychan.library.BottomBarLayout;

import com.jaeger.library.StatusBarUtil;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import www.winroad.R;
import www.winroad.base.BaseMvpActivity;
import www.winroad.mvp.presenter.HomePresenter;
import www.winroad.mvp.viewUi.fragment.AdsFragment;
import www.winroad.mvp.viewUi.fragment.PersonalFragment;


public class HomeActivity extends BaseMvpActivity {
    @Bind(R.id.vp_content)
    ViewPager vpContent;
    @Bind(R.id.bbl)
    BottomBarLayout bbl;
    private List<Fragment> mFragmentList = new ArrayList<>();


    @Override
    protected HomePresenter onLoadPresenter() {
        return new HomePresenter();
    }

    @Override
    protected int getLayoutResource() {
        StatusBarUtil.setColor(this, getResources().getColor(R.color.red));

        return R.layout.activity_home;
    }

    @Override
    protected void onInitialization(Bundle bundle) {
         //initToolBar(mToolbar, "登录");

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);




        AdsFragment adsFragment=new AdsFragment();

        PersonalFragment personalFragment=new PersonalFragment();

        mFragmentList.add(adsFragment);
        mFragmentList.add(personalFragment);


        vpContent.setAdapter(new MyAdapter(getSupportFragmentManager()));
        bbl.setViewPager(vpContent);
        vpContent.setOffscreenPageLimit(2);

        bbl.setUnread(0, 0);//设置第一个页签的未读数为20
        bbl.setUnread(0, 0);//设置第二个页签的未读数



        bbl.getBottomItem(2);
        Toast.makeText(getApplicationContext(), "首页展示成功", Toast.LENGTH_SHORT).show();
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
