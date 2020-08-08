package com.example.appuel.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.appuel.R;
import com.example.appuel.activity.activities.ProfilePageActivity;
import com.example.appuel.databinding.FragmentThoikhoabieuBinding;
import com.example.appuel.fragment.TKB_Fragment;
import com.example.appuel.modal.ThoiKhoaBieu;

import java.util.ArrayList;

public class TkbAdapter extends BaseAdapter {
    ArrayList<ThoiKhoaBieu> arrTKB;
    Context context;

    public TkbAdapter(ArrayList<ThoiKhoaBieu> arrTKB, Context context) {
        this.arrTKB = arrTKB;
        this.context = context;

    }

    @Override
    public int getCount() {
        return arrTKB.size();
    }

    @Override
    public Object getItem(int position) {
        return arrTKB.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder {
        TextView txtTenmonhoc, txtNgayhoc;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.row_tkb, null);
            viewHolder.txtTenmonhoc = convertView.findViewById(R.id.txtTenmonhoc);
            viewHolder.txtNgayhoc = convertView.findViewById(R.id.txtNgayhoc);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        ThoiKhoaBieu thoiKhoaBieu = (ThoiKhoaBieu) getItem(position);

        viewHolder.txtTenmonhoc.setText(thoiKhoaBieu.getTenmonhoc());
        viewHolder.txtNgayhoc.setText("Tiết "+thoiKhoaBieu.getThoigian()+", "+"Phòng "+thoiKhoaBieu.getPhong());

        return convertView;
    }


}
