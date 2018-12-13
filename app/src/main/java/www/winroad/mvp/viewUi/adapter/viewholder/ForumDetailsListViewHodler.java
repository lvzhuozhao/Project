package www.winroad.mvp.viewUi.adapter.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hjq.toast.ToastUtils;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;


import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import www.winroad.R;
import www.winroad.config.API;
import www.winroad.entity.NewsPageBean;

/**
 * @author Mr.xiao
 * Time: 2017/11/1 0001
 * Email:xhb_199409@163.com
 * Email:xhb_199409@163.com
 * Github:https://github.com/xiaohaibin/
 * Drscribe:
 */

public class ForumDetailsListViewHodler extends BaseViewHolder<NewsPageBean.ListBean> {
    @Bind(R.id.title)
    TextView mTitle;
    @Bind(R.id.name)
    TextView mName;


    public ForumDetailsListViewHodler(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    @Override
    public void setData(final NewsPageBean.ListBean data) {
        mTitle.setText(data.getTitle());
        mName.setText(data.getPubdate_at() + "");
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


