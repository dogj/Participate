package com.example.administrator.participate.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.participate.R;
import com.example.administrator.participate.model.ListItem;

import java.util.List;

/**
 * Created by Administrator on 2017/1/9.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> implements View.OnClickListener {

    public List<ListItem> listData;
    private LayoutInflater inflater;
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;
    public Adapter(List<ListItem> listData, Context c){

        this.inflater= LayoutInflater.from(c);
        this.listData= listData;

    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.list_item,parent,false);
        view.setOnClickListener(this);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ListItem item =listData.get(position);
//        String[] a={"哈哈","呵呵","嘻嘻"};
        holder.itemView.setTag(item.getRecord());
        holder.title.setText(item.getTitles());
        holder.icon.setImageResource(item.getImageResId());
        holder.level.setText(item.getLevel());
        holder.record.setText(item.getRecord());
        holder.sign.setText(item.getSign());

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView title;
        public ImageView icon;
        public View container;
        TextView level;
        TextView record;
        TextView sign;

        public MyViewHolder(View itemView) {
            super(itemView);
            title=(TextView)itemView.findViewById(R.id.lbl_item_text);
            icon = (ImageView)itemView.findViewById(R.id.im_item_icon);
            level = (TextView) itemView.findViewById(R.id.lbl_item_text2);
            record = (TextView) itemView.findViewById(R.id.lbl_item_text3);
            sign = (TextView) itemView.findViewById(R.id.lbl_item_text4);

            container=itemView.findViewById(R.id.cont_item_root);


        }
    }

    public void additem(List<ListItem> newdata){

        newdata.addAll(listData);
        listData.removeAll(listData);
        listData.addAll(newdata);
    }


    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取数据
            mOnItemClickListener.onItemClick(v,(String)v.getTag());
        }
    }

    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }

    public  interface OnRecyclerViewItemClickListener {
        void onItemClick(View view, String data);
    }
}
