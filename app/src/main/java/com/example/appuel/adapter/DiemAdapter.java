package com.example.appuel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

import com.example.appuel.R;
import com.example.appuel.modal.Diem;

import java.util.ArrayList;

public class DiemAdapter extends BaseAdapter {
    ArrayList<Diem> arrDiem;
    Context context;

    public DiemAdapter(ArrayList<Diem> arrDiem, Context context) {
        this.arrDiem = arrDiem;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrDiem.size();
    }

    @Override
    public Object getItem(int position) {
        return arrDiem.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder {
        Button btnTitleDiem;
        TableLayout tblDiem;
        TextView txtMahocphan, txtTenhocphan, txtTc, txtGk, txtCk, txtTb, txtQt;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.table_diem, null);
            viewHolder.btnTitleDiem = convertView.findViewById(R.id.btnTitleDiem);
            viewHolder.tblDiem = convertView.findViewById(R.id.tblDiem);
            viewHolder.txtMahocphan = convertView.findViewById(R.id.txtMahocphan);
            viewHolder.txtTenhocphan = convertView.findViewById(R.id.txtTenhocphan);
            viewHolder.txtTc = convertView.findViewById(R.id.txtTC);
            viewHolder.txtGk = convertView.findViewById(R.id.txtGK);
            viewHolder.txtQt = convertView.findViewById(R.id.txtQT);
            viewHolder.txtCk = convertView.findViewById(R.id.txtCK);
            viewHolder.txtTb = convertView.findViewById(R.id.txtTB);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Diem diem= (Diem) getItem(position);
        return convertView;
    }
}
