package com.example.appuel.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.appuel.R;
import com.example.appuel.modal.SinhVien;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SvAdapter extends BaseAdapter {
    ArrayList<SinhVien> arrSv;
    Context context;

    public SvAdapter(ArrayList<SinhVien> arrSv, Context context) {
        this.arrSv = arrSv;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrSv.size();
    }

    @Override
    public Object getItem(int position) {
        return arrSv.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public class ViewHolder {
        TextView txtTen, txtMssv;
        ImageView imgAvatar;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.fragment_canhan, null);
            viewHolder.txtTen = convertView.findViewById(R.id.txtTen);
            viewHolder.txtMssv = convertView.findViewById(R.id.txtMssv);
            viewHolder.imgAvatar=convertView.findViewById(R.id.profile_image);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        SinhVien sinhVien = (SinhVien) getItem(position);
        GoogleSignInAccount signInAccount = GoogleSignIn.getLastSignedInAccount(context);
        Log.d("TAG", "getView: "+sinhVien.getEmail());
        if (signInAccount.getEmail()==sinhVien.getEmail()){
            viewHolder.txtTen.setText(sinhVien.getTen());
            viewHolder.txtMssv.setText(sinhVien.getMssv());
            Picasso.get().load(sinhVien.getImg()).placeholder(R.drawable.noimage).error(R.drawable.error).into(viewHolder.imgAvatar);
        }

        return convertView;
    }
}
