package www.winroad.utils;

import android.text.TextUtils;
import android.util.Log;

public class L {



    //大型打印使用，Log默认是有字数限制的，如有需要打印更长的文本可以使用此方法
    public void bigLog(String msg) {
        Log.i(">>>bigLog", "BIGLOG.start=================================");
        if (TextUtils.isEmpty(msg)) return;

        int strLength = msg.length();
        int start = 0;
        int end = 2000;
        for (int i = 0; i < 100; i++) {
            //剩下的文本还是大于规定长度则继续重复截取并输出
            if (strLength > end) {
                Log.v(">>>", msg.substring(start, end));
                start = end;
                end = end + 2000;
            } else {
                Log.v(">>>", msg.substring(start, strLength));
                break;
            }
        }
        Log.i(">>>bigLog", "BIGLOG.end=================================");
    }
}
