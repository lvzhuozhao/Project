package www.winroad.utils;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.telephony.TelephonyManager;
import android.util.Log;

import com.hjq.toast.ToastUtils;

import www.winroad.StaticUtil;
import www.winroad.config.Constants;

/**
 * Created by handagou on 2018/12/13.
 */

public class NetWork {

    private static ConnectivityManager manager;

    /**
     * 网络为连接时，设置网络
     */
    public static void setNetWork(final Context context) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("网络连接提示").setMessage("网络不可用，如果继续，请设置网络");
        builder.setPositiveButton("设置", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = null;
                /**
                 * 判断手机系统的版本！如果 API 大于 10 就是 3.0+
                 * 因为 3.0 以上的版本的设置和 3.0 以下的设置不一样，调用的方法不同
                 */
                if (Build.VERSION.SDK_INT > 10){
                    intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                }else {
                    intent = new Intent();
                    ComponentName componentName = new ComponentName(
                            "com.android.settings",
                            "com.android.settings.WirelessSettings"
                    );
                    intent.setComponent(componentName);
                    intent.setAction("android.intent.action.VIEW");
                }
                //启动打开 Wi-Fi 设置页面
                context.startActivity(intent);
            }
        });

        builder.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                return;
            }
        });

        builder.create();
        builder.show();
    }




    /**
     * 获取网络类型
     * @param context Context
     * @return true 表示网络可用
     */
    public static int getNetWorkType(Context context) {
        ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = manager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            String type = networkInfo.getTypeName();

            if (type.equalsIgnoreCase("WIFI")) {
                return StaticUtil.NETTYPE_WIFI;//Wi-Fi网络
            } else if (type.equalsIgnoreCase("MOBILE")) {
                NetworkInfo mobileInfo = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
                if (mobileInfo != null) {
                    switch (mobileInfo.getType()) {
                        case ConnectivityManager.TYPE_MOBILE:// 手机网络
                            switch (mobileInfo.getSubtype()) {
                                //--------------------Added in API level 1---------------------
                                //(3G)联通  ~ 400-7000 kbps
                                case TelephonyManager.NETWORK_TYPE_UMTS:
                                    //(2.5G) 移动和联通  ~ 100 kbps
                                case TelephonyManager.NETWORK_TYPE_GPRS:
                                    //(2.75G) 2.5G 到 3G 的过渡  移动和联通 ~ 50-100 kbps
                                case TelephonyManager.NETWORK_TYPE_EDGE:
                                    //-----------------Added in API level 4---------------------
                                    //( 3G )电信   ~ 400-1000 kbps
                                case TelephonyManager.NETWORK_TYPE_EVDO_0:
                                    //(2G 电信)  ~ 14-64 kbps
                                case TelephonyManager.NETWORK_TYPE_CDMA:
                                    //(3.5G) 属于3G过渡   ~ 600-1400 kbps
                                case TelephonyManager.NETWORK_TYPE_EVDO_A:
                                    //( 2G )  ~ 50-100 kbps
                                case TelephonyManager.NETWORK_TYPE_1xRTT:
                                    //---------------------Added in API level 5--------------------
                                    //(3.5G )  ~ 2-14 Mbps
                                case TelephonyManager.NETWORK_TYPE_HSDPA:
                                    //( 3.5G )  ~ 1-23 Mbps
                                case TelephonyManager.NETWORK_TYPE_HSUPA:
                                    //( 3G ) 联通  ~ 700-1700 kbps
                                case TelephonyManager.NETWORK_TYPE_HSPA:
                                    //---------------------Added in API level 8---------------------
                                    //(2G )  ~25 kbps
                                case TelephonyManager.NETWORK_TYPE_IDEN:
                                    return StaticUtil.NETTYPE_2G;
                                //---------------------Added in API level 9---------------------
                                //3G-3.5G  ~ 5 Mbps
                                case TelephonyManager.NETWORK_TYPE_EVDO_B:
                                    //---------------------Added in API level 11--------------------
                                    //(4G) ~ 10+ Mbps
                                case TelephonyManager.NETWORK_TYPE_LTE:
                                    return StaticUtil.NETTYPE_4G;
                                //3G(3G到4G的升级产物)  ~ 1-2 Mbps
                                case TelephonyManager.NETWORK_TYPE_EHRPD:
                                    //--------------------Added in API level 13-------------------
                                    //( 3G )  ~ 10-20 Mbps
                                case TelephonyManager.NETWORK_TYPE_HSPAP:
                                    return StaticUtil.NETTYPE_3G;
                                //无网络
                                default:
                                    return StaticUtil.NETTYPE_NONE;
                            }
                    }
                }
            }
        }
        return StaticUtil.NETTYPE_NONE;
    }


    /**
     * 网络已经连接，判断是 Wi-Fi 还是移动网络（2G、3G、4G）
     * @return
     */
    public static void isNetworkAvailable(Context context) {
        NetworkInfo.State gprs = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState();
        NetworkInfo.State wifi = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState();
        if (gprs == NetworkInfo.State.CONNECTED || gprs == NetworkInfo.State.CONNECTING){
            Log.e("GPRS","移动网络已打开！");
        }
        if (wifi == NetworkInfo.State.CONNECTED || wifi == NetworkInfo.State.CONNECTING){
            Log.e("WIFI","Wi-Fi已打开！");
        }

        //获取网络类型
        switch (getNetWorkType(context)){
            case StaticUtil.NETTYPE_2G:
                ToastUtils.show("当前网络是2G网络");
                break;
            case StaticUtil.NETTYPE_3G:
                ToastUtils.show("当前网络是3G网络");
                break;
            case StaticUtil.NETTYPE_4G:
                ToastUtils.show("当前网络是4G网络");
                break;
            case StaticUtil.NETTYPE_WIFI:
                ToastUtils.show("当前网络是wifi");
                break;
        }

    }

    /**
     * 检测网络是否连接
     * @return
     */
    public static boolean checkNetWorkState(Context context){
        boolean flag = false;
        //得到网络连接信息
        manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        //判断网络是否连接
        if (manager.getActiveNetworkInfo() != null){
            flag = manager.getActiveNetworkInfo().isAvailable();
        }
        if (flag){
            //判断网络类型
            isNetworkAvailable(context);
        }
        return flag;
    }

}
