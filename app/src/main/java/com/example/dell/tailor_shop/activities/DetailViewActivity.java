package com.example.dell.tailor_shop.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.dell.tailor_shop.R;
import com.example.dell.tailor_shop.models.User_Profile;
import com.google.gson.Gson;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailViewActivity extends AppCompatActivity {
    @BindView(R.id.name)
    TextView name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        ButterKnife.bind(this);
//        Bundle extras = getIntent().getExtras();
//        if (extras != null) {
//            String userDetails = extras.getString("userDetails");
        String userDetails = getIntent().getStringExtra("userDetails");
        System.out.println("Get Object" + userDetails);
        User_Profile response = new Gson().fromJson(userDetails, User_Profile.class);
//            for (User_Profile s : response) {
                name.setText(response.getUser().getUsername());
//
//            }

//        }

    }
}
