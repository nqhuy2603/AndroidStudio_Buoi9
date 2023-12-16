package com.nguyenquochuy.thuchanh09_nguyenquochuy_2100009561;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends BaseAdapter {
    Context context;
    List<Course> dskh = new ArrayList<>();
    public MyAdapter(Context context, List<Course> dskh) {
        this.context = context;
        this.dskh = dskh;
    }
    @Override
    public int getCount() {
        if ((dskh.size()>0) && (! dskh.isEmpty()))
            return dskh.size();
        return 0;
    }
    @Override
    public Object getItem(int position) {
        return null;
    }
    @Override
    public long getItemId(int position) {
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView==null)
            convertView = LayoutInflater.from(context).inflate(R.layout.giaodien_listview,
                    parent, false);
        TextView tv1 = convertView.findViewById(R.id.tvID);
        TextView tv2 = convertView.findViewById(R.id.tvCourseName);
        TextView tv3 = convertView.findViewById(R.id.tvCourseDuration);
        TextView tv4 = convertView.findViewById(R.id.tvCourseTracks);
        TextView tv5 = convertView.findViewById(R.id.tvCourseDes);
        tv1.setText(String.valueOf(dskh.get(position).getId()));
        tv2.setText(dskh.get(position).getCourse_name().toString());
        tv3.setText(dskh.get(position).getCourse_duration().toString());
        tv4.setText(dskh.get(position).getCourse_tracks().toString());
        tv5.setText(dskh.get(position).getCourse_description().toString());
        return convertView;
    }

}
