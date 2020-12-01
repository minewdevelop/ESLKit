package com.minew.esldemo;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.minew.esl.tag.ble.bean.TagInfo;

import java.util.List;


public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.TagHolder> {


    private List<TagInfo> mData;

    @Override
    public TagHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TagHolder viewHolder = null;
        viewHolder = new TagHolder(View.inflate(parent.getContext(), R.layout.item, null));
        return viewHolder;
    }

    public interface OnItemClickListener {
        void onItemClick(View view, TagInfo tagInfo, int position);
    }

    private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @Override
    public void onBindViewHolder(final TagHolder holder, int position) {
        holder.setDataAndUi(mData.get(position));

        /*// 如果设置了回调，则设置点击事件
        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getAdapterPosition();
                    mOnItemClickListener.onItemClick(holder.itemView, mData.get(pos), pos);
                }
            });
        }*/
    }

    @Override
    public int getItemCount() {
        if (mData != null) {
            return mData.size();
        }
        return 0;
    }

    public void setData(List<TagInfo> data) {
        mData = data;
        notifyDataSetChanged();
    }

    public class TagHolder extends RecyclerView.ViewHolder {

        TextView data;

        public TagHolder(View itemView) {
            super(itemView);
            data = (TextView) itemView.findViewById(R.id.data);
        }

        public void setDataAndUi(TagInfo tagInfo) {
            data.setText(tagInfo.getAddress());
        }

    }
}
