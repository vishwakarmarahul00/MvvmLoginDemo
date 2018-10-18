package com.mvvmlogindemo;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Handler;
import android.view.View;


public class LoginViewModel extends ViewModel {
    public MutableLiveData<String> errorPass = new MutableLiveData<>();
    public MutableLiveData<String> errorEmailId = new MutableLiveData<>();
    public MutableLiveData<String> emailId = new MutableLiveData<>();
    public MutableLiveData<String> pass = new MutableLiveData<>();
    public MutableLiveData<Integer> busy;

    public MutableLiveData<Integer> getBusy() {

        if (busy == null) {
            busy = new MutableLiveData<>();
            busy.setValue(View.INVISIBLE);
        }

        return busy;
    }


    public LoginViewModel() {
    }

    private MutableLiveData<Users> userMutableLiveData;

    LiveData<Users> getUser() {
        if (userMutableLiveData == null) {
            userMutableLiveData = new MutableLiveData<>();
        }

        return userMutableLiveData;
    }


    public void onLoginClicked() {

        getBusy().setValue(View.VISIBLE);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                Users user = new Users(emailId.getValue(), pass.getValue());

                if (!user.isEmailValid()) {
                    errorEmailId.setValue("Enter a valid email id");
                } else {
                    errorEmailId.setValue(null);
                }

                if (!user.isPasswordGreaterthenfive())
                    errorPass.setValue("Password Length should be greater than 5");
                else {
                    errorPass.setValue(null);
                }

                userMutableLiveData.setValue(user);
                busy.setValue(View.INVISIBLE);

            }
        }, 3000);
    }
}