package com.example.appuel.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Toast;
import android.widget.Toolbar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.appuel.R;
import com.example.appuel.activity.activities.LoginPageActivity;
import com.example.appuel.activity.activities.NotificationActivity;
import com.example.appuel.activity.activities.ProfilePageActivity;
import com.example.appuel.adapter.TkbAdapter;
import com.example.appuel.databinding.FragmentThoikhoabieuBinding;
import com.example.appuel.modal.ThoiKhoaBieu;
import com.example.appuel.util.CheckConnection;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class TKB_Fragment extends Fragment {

    public static FragmentThoikhoabieuBinding binding;

    Context context;
     ArrayList<ThoiKhoaBieu> listTKB = new ArrayList<>();
     ArrayList<ThoiKhoaBieu>list=new ArrayList<>();
    TkbAdapter tkbAdapter;
    ThoiKhoaBieu thoiKhoaBieu;

    public TKB_Fragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getActivity();
        binding = FragmentThoikhoabieuBinding.inflate(inflater, container, false);
        ActionToolbar();
        addControls();
        addEvents();
        return binding.root;
    }

    private void addControls() {
        tkbAdapter = new TkbAdapter(listTKB, context);
        binding.lvTKB.setAdapter(tkbAdapter);
        listTKB.add( new ThoiKhoaBieu(1, "kỹ thuật lập trình", "123", "A.401", 5));
        listTKB.add( new ThoiKhoaBieu(2, "tin học cơ sở", "123", "A.401", 5));
        listTKB.add(new ThoiKhoaBieu(3, "lý thuyết xác suất", "123", "A.401", 5));
        listTKB.add( new ThoiKhoaBieu(4, "toán cao cấp", "123", "A.401", 6));
        listTKB.add(new ThoiKhoaBieu(5, "kinh tế vĩ mô", "123", "A.401", 6));
    }

    private void addEvents() {
        binding.calTKB.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
//                listTKB.clear();
//                for (int i = 0; i < listTKB.size(); i++) {
//                    if (listTKB.get(i).getNgayhoc() == dayOfMonth) {
//                       listTKB.add(listTKB.get(i));
//                    }
//                }
//                tkbAdapter.notifyDataSetChanged();
            }
        });


    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.notification, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menuthongbao:
                Intent intent = new Intent(context, NotificationActivity.class);
                startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    private void ActionToolbar() {
        ((AppCompatActivity) context).setSupportActionBar(binding.toolbarTKB);
    }
}
