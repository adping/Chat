package com.example.jgpush.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.jgpush.R;
import com.example.jgpush.base.BaseMessage;

import java.util.List;


/**
 * Created by issuser on 2018/3/27.
 */

public class ConversationMassageAdapter extends BaseAdapter {
    private Context context;
    private List<BaseMessage> datas;
    private LayoutInflater inflater;

    public ConversationMassageAdapter(Context context, List<BaseMessage> datas) {
        this.context = context;
        this.datas = datas;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        BaseMessage message = datas.get(position);
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = inflater.inflate(R.layout.message_list_view_item, null);

            holder.leftLayout = convertView.findViewById(R.id.left_layout);
            holder.rightLayout = convertView.findViewById(R.id.right_layout);
            holder.otherNameTv = convertView.findViewById(R.id.other_name_tv);
            holder.leftTv = convertView.findViewById(R.id.left_msg);
            holder.rightTv = convertView.findViewById(R.id.right_msg);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        if (message.getType() == 0) {
            holder.rightLayout.setVisibility(View.GONE);
            holder.leftLayout.setVisibility(View.VISIBLE);
            holder.leftTv.setText(message.getCont());
            holder.otherNameTv.setText(message.getName());
        } else if (message.getType() == 1) {
            holder.leftLayout.setVisibility(View.GONE);
            holder.rightLayout.setVisibility(View.VISIBLE);
            holder.rightTv.setText(message.getCont());
        }

        return convertView;
    }

    class ViewHolder {
        RelativeLayout leftLayout, rightLayout;
        TextView otherNameTv, leftTv, rightTv;
    }
}
