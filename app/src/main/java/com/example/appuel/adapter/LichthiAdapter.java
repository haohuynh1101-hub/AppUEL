package com.example.appuel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.appuel.R;
import com.example.appuel.modal.LichThi;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class LichthiAdapter extends BaseAdapter {
    ArrayList<LichThi> arrLichthi;
    Context context;

    public LichthiAdapter(ArrayList<LichThi> arrLichthi, Context context) {
        this.arrLichthi = arrLichthi;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrLichthi.size();
    }

    @Override
    public Object getItem(int position) {
        return arrLichthi.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder {
        TextView txtNgayThi, txtTime;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row_lichthi, null);
            viewHolder.txtNgayThi = convertView.findViewById(R.id.txtNgayThi);
            viewHolder.txtTime = convertView.findViewById(R.id.txtTime);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        LichThi lichThi = (LichThi) getItem(position);
        Date day=lichThi.getNgaythi();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        String date=simpleDateFormat.format(day);
        viewHolder.txtNgayThi.setText(date);
        viewHolder.txtTime.setText(" Giờ "+lichThi.getGiothi()+": "+" "+lichThi.getMamonhoc()+" ("+lichThi.getTenmonhoc()+")"+" Phòng"+lichThi.getPhongthi());
        return convertView;
    }
}
