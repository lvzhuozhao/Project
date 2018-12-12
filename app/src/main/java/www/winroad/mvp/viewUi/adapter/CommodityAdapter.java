package www.winroad.mvp.viewUi.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.huijin.lonxing.R;
import com.huijin.lonxing.entity.NewsPageBean;


/**
 * Created by Administrator on 2018/5/16.
 */

public class CommodityAdapter extends BaseQuickAdapter<NewsPageBean.ListBean, BaseViewHolder> {


    public CommodityAdapter(int commodity_recycler_layout) {
        super(commodity_recycler_layout);
    }

    @Override
    protected void convert(final BaseViewHolder helper, NewsPageBean.ListBean item) {


        helper.setText(R.id.title, item.getTitle());
        //helper.setText(R.id.name, item.getAid());


//        Glide.with(mContext).load(item.getThumb()).dontAnimate().into((ImageView) helper.getView(R.id.caseds_image));


    }


}
