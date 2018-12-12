package www.winroad.mvp.viewUi.activity;

import android.os.Bundle;
import android.widget.Toast;


import com.jaeger.library.StatusBarUtil;

import butterknife.ButterKnife;
import www.winroad.R;
import www.winroad.base.BaseMvpActivity;
import www.winroad.entity.UserInfoBean;
import www.winroad.mvp.contract.LoginContract;
import www.winroad.mvp.presenter.LoginPresenter;

public class MainActivity extends BaseMvpActivity<LoginPresenter> implements LoginContract.loginView {




    @Override
    protected LoginPresenter onLoadPresenter() {
        return new LoginPresenter();
    }

    @Override
    protected int getLayoutResource() {
        StatusBarUtil.setColor(this, getResources().getColor(R.color.red));
        return R.layout.activity_main;

    }

    @Override
    protected void onInitialization(Bundle bundle) {
        //initToolBar(mToolbar, "登录");
     }


    @Override
    public void loginSuccess(UserInfoBean infoEntity) {

        Toast.makeText(getApplicationContext(), "MVP登录成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void loginFailed(String msg) {
        Toast.makeText(getApplicationContext(), "MVP登录失败", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {


    }

    @Override
    public void hideLoading() {


    }

//
//    @OnClick({R.id.ed_account, R.id.ed_pwd, R.id.btn})
//    public void onViewClicked(View view) {
//        switch (view.getId()) {
//            case R.id.ed_account:
//
//                break;
//            case R.id.ed_pwd:
//                break;
//            case R.id.btn:
//                mPresenter.login(edAccount.getText().toString(), edPwd.getText().toString());
//                break;
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
}
