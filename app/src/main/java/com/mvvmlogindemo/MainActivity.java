package com.mvvmlogindemo;


import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;
import com.mvvmlogindemo.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        LoginViewModel loginVM = ViewModelProviders.of(this).get(LoginViewModel.class);
        binding.setLoginViewModel(loginVM);
        binding.setLifecycleOwner(this);

        loginVM.getUser().observe(this, new Observer() {
            @Override
            public void onChanged(@Nullable Object obj) {
                if (obj != null) {
                    Users user = (Users) obj;
                    if (user.getEmail().length() > 0 || user.getPass().length() > 0)
                        Toast.makeText(getApplicationContext(), "email : " + user.getEmail() + " password " + user.getPass(), Toast.LENGTH_SHORT).show();

                }
            }
        });

    }
}

