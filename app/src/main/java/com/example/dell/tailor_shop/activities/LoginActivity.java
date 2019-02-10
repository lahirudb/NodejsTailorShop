package com.example.dell.tailor_shop.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dell.tailor_shop.R;
import com.example.dell.tailor_shop.models.Login;
import com.example.dell.tailor_shop.models.User;
import com.example.dell.tailor_shop.models.User_Profile;
import com.example.dell.tailor_shop.services.UserService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.username)
    EditText username;
    @BindView(R.id.password)
    EditText password;
    @BindView(R.id.login_btn)
    Button login_btn;

    //static final String BASE_URL = "http://172.16.4.18:4000/";//192.168.1.4
    static final String BASE_URL = "http://192.168.254.2:4000";
//    static final String BASE_URL = "http://192.168.8.100:4000/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        //login_btn.setOnClickListener(v -> login_onClick());
        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    login_onClick();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void login_onClick() throws JSONException {
        String user = username.getText().toString();
        String pwd = password.getText().toString();
//        Map<String, String> map = new HashMap<>();
//        map.put("username", user);
//        map.put("password", pwd);

//        JSONObject item = new JSONObject();
//        item.put("username", user);
//        item.put("password", pwd);
//        System.out.println("HashMap : " + item.toString());
//        String body = item.toString();

//        HashMap<String, Object> map = new HashMap<>();
//        map.put("username", item);
        //map.put("password", pwd);
//        Gson gson = new GsonBuilder()
//                .setLenient()
//                .create();
        Login login_det = new Login();
        login_det.setUsername(user);
        login_det.setPassword(pwd);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())//gson
                .build();

        UserService userService = retrofit.create(UserService.class);
        Call<User_Profile> call = userService.userLoginChanges(login_det);
        call.enqueue(new Callback<User_Profile>() {
            @Override
            public void onResponse(Call<User_Profile> call, Response<User_Profile> response) {
                System.out.println("On Success" + response.body().toString());
                if (response.body() != null && response.code() == 200) {
                    Gson gson = new Gson();
                    String body = gson.toJson(response.body());
                    System.out.println("body : " + body);
                    //User_Profile userProfiles = gson.fromJson(response.body().toString(), User_Profile.class);
                    //String userDetails = gson.toJson(response.body());
                    //System.out.println("On Success"+ response.body());
                    Intent intent = new Intent(LoginActivity.this, DetailViewActivity.class);
                    intent.putExtra("userDetails", body);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Login Failed..!!!", Toast.LENGTH_LONG).show();
                }

            }

            @Override
            public void onFailure(Call<User_Profile> call, Throwable t) {
                System.out.println("On Failure");
                t.printStackTrace();
            }
        });
    }
}


