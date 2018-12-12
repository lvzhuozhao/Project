package www.winroad.utils;

import android.content.Context;
import android.graphics.Color;

import com.zyao89.view.zloading.ZLoadingDialog;

import static com.zyao89.view.zloading.Z_TYPE.PAC_MAN;

public class Dolas {

    private static ZLoadingDialog dialog;

    public static void Doals(Context context) {
        dialog = new ZLoadingDialog(context);
        dialog.setLoadingBuilder(PAC_MAN)//设置类型
                .setLoadingColor(Color.YELLOW)//颜色
                .setHintText("Loading...")
                .setHintTextSize(13) // 设置字体大小 dp
                .setHintTextColor(Color.GRAY)  // 设置字体颜色
                .setDurationTime(0.5) // 设置动画时间百分比 - 0.5倍
                .setDialogBackgroundColor(Color.parseColor("#CC111111")) // 设置背景色，默认白色
                .show();
    }

    public static void DoalsDimess(Context context) {

        dialog.dismiss();

    }
}
