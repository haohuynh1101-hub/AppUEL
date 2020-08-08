package com.example.appuel.activity.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.text.method.MetaKeyKeyListener;
import android.util.Log;
import android.view.MenuItem;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.appuel.R;
import com.example.appuel.databinding.ActivityProfilePageBinding;
import com.example.appuel.fragment.CaNhan_Fragment;
import com.example.appuel.fragment.Diem_Fragment;
import com.example.appuel.fragment.LichThi_Fragment;
import com.example.appuel.fragment.TKB_Fragment;
import com.example.appuel.modal.SinhVien;
import com.example.appuel.util.CheckConnection;
import com.example.appuel.util.LoadingDialog;
import com.example.appuel.util.Server;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class ProfilePageActivity extends AppCompatActivity {
    ActivityProfilePageBinding binding;
    LoadingDialog loadingDialog = new LoadingDialog(ProfilePageActivity.this);
    int id = 0;
    String ten = "";
    String mssv = "";
    String img = "";
    String date = "";
    String lop = "";
    String address = "";
    String email = "";
    public static ArrayList<SinhVien> listSv = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfilePageBinding.inflate(getLayoutInflater());
        setContentView(binding.root);
        loadingDialog.startLoadingDialog();
        GetDataProfile();
        addEvents();

    }

    private void GetDataProfile() {
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.linkProfile, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null) {
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            id = jsonObject.getInt("Id");
                            ten = jsonObject.getString("Ten");
                            mssv = jsonObject.getString("Mssv");
                            img = jsonObject.getString("Image");
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                            date = jsonObject.getString("Date");
                           Date d=sdf.parse(date);
                            lop = jsonObject.getString("Class");
                            address = jsonObject.getString("Address");
                            email = jsonObject.getString("Email");
                            listSv.add(new SinhVien(id, ten, mssv, img, d, lop, address, email));

                        } catch (Exception ex) {
                            Log.d("TAG", "LOI: " + ex);
                        }
                    }
                    Log.d("TAG", "onResponse: " + listSv);

                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                CheckConnection.showToast(getApplicationContext(), error.toString());
            }
        });
        requestQueue.add(jsonArrayRequest);
        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                loadingDialog.dismissDialog();
            }
        },3000);
    }

    private void addEvents() {
        binding.bottomNavigation.setOnNavigationItemSelectedListener(navListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new TKB_Fragment()).commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment selectFragment = null;
            switch (item.getItemId()) {
                case R.id.nav_TKB:
                    selectFragment = new TKB_Fragment();

                    break;
                case R.id.nav_LichThi:
                    selectFragment = new LichThi_Fragment();
                    break;
                case R.id.nav_Diem:
                    selectFragment = new Diem_Fragment();
                    break;
                case R.id.nav_CaNhan:
                    selectFragment = new CaNhan_Fragment();
                    Bundle bundle = new Bundle();
                    GoogleSignInAccount signInAccount = GoogleSignIn.getLastSignedInAccount(getApplicationContext());
                    for (int i = 0; i < listSv.size(); i++) {
                        Log.d("TAG", "onNavigationItemSelected: " + listSv.get(i).getDate());

                        if (signInAccount.getEmail().equals(listSv.get(i).getEmail())) {
                            bundle.putSerializable("profile", listSv.get(i));
                        } else {
                            bundle.putSerializable("profile", null);
                        }
                    }
                    selectFragment.setArguments(bundle);
                    break;
            }

            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, selectFragment).commit();
            return true;
        }
    };
}
