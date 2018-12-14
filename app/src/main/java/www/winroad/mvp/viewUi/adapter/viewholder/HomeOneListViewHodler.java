package www.winroad.mvp.viewUi.adapter.viewholder;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import butterknife.Bind;
import butterknife.ButterKnife;
import www.winroad.R;
import www.winroad.entity.NewsPageBean;

/**
 * @author Mr.xiao
 * Time: 2017/11/1 0001
 * Email:xhb_199409@163.com
 * Email:xhb_199409@163.com
 * Github:https://github.com/xiaohaibin/
 * Drscribe:
 */

public class HomeOneListViewHodler extends BaseViewHolder<NewsPageBean.ListBean> {
    @Bind(R.id.title)
    TextView mTitle;
    @Bind(R.id.name)
    TextView mName;


    public HomeOneListViewHodler(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public HomeOneListViewHodler(ViewGroup parent, int viewType) {
        super(parent, viewType);
        ButterKnife.bind(this, itemView);

        int ONE_ITEM = 1;
        int TWO_ITEM = 2;
        int THREE_ITEM = 3;


//        if(ONE_ITEM == viewType){
//            View v = mLayoutInflater.inflate(R.layout.homeone_recycler_layout,parent,false);
//            holder = new OneViewHolder(v);
//        }else{
//            View v = mLayoutInflater.inflate(R.layout.homeone_recycler_layout,parent,false);
//            holder = new TwoViewHolder(v);
//        }
//    }


//    @Override
//    public void setData(final NewsPageBean.ListBean data) {
//        mTitle.setText(data.getTitle());
//        mName.setText(data.getPubdate_at() + "");
//        mDate.setText(data.getDateline());
//        tvCount.setText(data.getReplies()+"评论");
//        List<String> litpic = data.getLitpic();
//        if (litpic != null && !litpic.isEmpty()) {
//            imgUrl = litpic.get(0);
//            Glide.with(getContext()).load(litpic.get(0)).into(mIv);
//        }
//        itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                WebDetailsActivity.start(getContext(), String.format(API.GET_3DM_WEB_FORUM, data.getTid()), data.getSubject(), imgUrl);
//            }
//        });
    }
}


