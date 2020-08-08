package com.example.appuel.fragment;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.appuel.R;
import com.example.appuel.adapter.LichthiAdapter;
import com.example.appuel.databinding.FragmentLichthiBinding;
import com.example.appuel.databinding.FragmentThoikhoabieuBinding;
import com.example.appuel.modal.LichThi;
import com.example.appuel.modal.SinhVien;
import com.example.appuel.util.CheckConnection;
import com.example.appuel.util.Server;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class LichThi_Fragment extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private String mParam1;
    private String mParam2;
    Context context;
    ArrayList<LichThi> listLichthi = new ArrayList<>();
    LichthiAdapter lichthiAdapter;

    public LichThi_Fragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getActivity();
        binding = FragmentLichthiBinding.inflate(inflater, container, false);
        ActionToolbar();
        addControl();
        GetDataLichThi();
        return binding.root;
    }

    private void GetDataLichThi() {
        RequestQueue requestQueue = Volley.newRequestQueue(context);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.linkLichthi, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null) {
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            int id = jsonObject.getInt("Id");
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                           String ngaythi = jsonObject.getString("Ngaythi");
                            Date date=sdf.parse(ngaythi);
                           String giothi = jsonObject.getString("Giothi");
                            String mamonhoc = jsonObject.getString("Mamonhoc");
                            String tenmonhoc = jsonObject.getString("Tenmonhoc");
                            String phongthi = jsonObject.getString("Phongthi");
                            listLichthi.add(new LichThi(id,date,giothi,mamonhoc,tenmonhoc,phongthi));
                            lichthiAdapter.notifyDataSetChanged();
                        } catch (Exception ex) {
                            Log.d("TAG", "LOI: " + ex);
                        }
                    }
                    Log.d("TAG", "lichthi: "+listLichthi);
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                CheckConnection.showToast(context, error.toString());
            }
        });
        requestQueue.add(jsonArrayRequest);
    }

    private void addControl() {
        lichthiAdapter=new LichthiAdapter(listLichthi,context);
        binding.lvLichThi.setAdapter(lichthiAdapter);
    }

    public static LichThi_Fragment newInstance(String param1, String param2) {
        LichThi_Fragment fragment = new LichThi_Fragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    FragmentLichthiBinding binding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.notification, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    private void ActionToolbar() {
        ((AppCompatActivity) context).setSupportActionBar(binding.toolbarLichThi);
    }
}
