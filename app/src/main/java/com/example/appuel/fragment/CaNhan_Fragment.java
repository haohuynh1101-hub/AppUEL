package com.example.appuel.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

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
import com.example.appuel.activity.activities.LoginPageActivity;
import com.example.appuel.activity.activities.ProfilePageActivity;
import com.example.appuel.adapter.SvAdapter;
import com.example.appuel.databinding.FragmentCanhanBinding;
import com.example.appuel.databinding.FragmentLichthiBinding;
import com.example.appuel.databinding.FragmentThoikhoabieuBinding;
import com.example.appuel.modal.SinhVien;
import com.example.appuel.util.CheckConnection;
import com.example.appuel.util.Server;
import com.firebase.ui.auth.AuthUI;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CaNhan_Fragment extends Fragment {
    Context context;
    public CaNhan_Fragment() {
        // Required empty public constructor
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        context = getActivity();
        binding = FragmentCanhanBinding.inflate(inflater, container, false);
        ActionToolbar();
        if (CheckConnection.haveNetworkConnection(context)) {
            Bundle bundle = getArguments();
            SinhVien sinhVien = (SinhVien) bundle.getSerializable("profile");
            Log.d("TAG", "onCreateView: " + sinhVien);
            if (sinhVien != null) {
                binding.txtTen.setText(sinhVien.getTen());
                binding.txtMssv.setText(sinhVien.getMssv());
                binding.txtEmail.setText(sinhVien.getEmail());
                binding.txtClass.setText(sinhVien.getLop());
                binding.txtAddress.setText(sinhVien.getAddress());
                Date day = sinhVien.getDate();

                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                String date = simpleDateFormat.format(day);
                binding.txtBirthday.setText(date);
                Picasso.get().load(sinhVien.getImg()).placeholder(R.drawable.noimage).error(R.drawable.error).into(binding.profileImage);
            } else {
                binding.rootImgProfile.setVisibility(View.INVISIBLE);
                binding.rootProfile.setVisibility(View.INVISIBLE);
            }

            binding.btnOut.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AuthUI.getInstance().signOut(context).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task) {
                            Intent intent = new Intent(context, LoginPageActivity.class);
                            startActivity(intent);
                        }
                    });
                }
            });
        } else {
            CheckConnection.showToast(context, "Bạn hãy kiểm tra lại kết nối");
            getActivity().finish();
        }
        // Picasso.get().load(R.drawable.uel).placeholder(R.drawable.noimage).error(R.drawable.error).into(binding.imgSchool);
        return binding.root;
    }




    FragmentCanhanBinding binding;

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

    private void ActionToolbar() {
        ((AppCompatActivity) context).setSupportActionBar(binding.toolbarCaNhan);
    }
}
