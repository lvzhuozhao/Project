package www.winroad.mvp.viewUi.adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import www.winroad.R;
import www.winroad.entity.NewsPageBean;
import www.winroad.mvp.viewUi.adapter.viewholder.ForumDetailsListViewHodler;
import www.winroad.mvp.viewUi.adapter.viewholder.HomeOneListViewHodler;


public class HomeOneAdapter extends RecyclerArrayAdapter<NewsPageBean.ListBean> {

    private LayoutInflater mLayoutInflater;

    public HomeOneAdapter(Context context) {
        super(context);

        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {


        return new HomeOneListViewHodler(parent,viewType);


        //return new ForumDetailsListViewHodler(mLayoutInflater.inflate(R.layout.homeone_recycler_layout, parent, false));


    }
}
