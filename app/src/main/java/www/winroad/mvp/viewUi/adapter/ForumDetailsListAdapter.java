package www.winroad.mvp.viewUi.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.hjq.toast.ToastUtils;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import www.winroad.R;
import www.winroad.entity.NewsPageBean;
import www.winroad.mvp.viewUi.adapter.viewholder.ForumDetailsListViewHodler;





public class ForumDetailsListAdapter extends RecyclerArrayAdapter<NewsPageBean.ListBean> {

    private LayoutInflater mLayoutInflater;

    public ForumDetailsListAdapter(Context context) {
        super(context);

        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {


        return new ForumDetailsListViewHodler(mLayoutInflater.inflate(R.layout.commodity_recycler_layout, parent, false));


    }
}
