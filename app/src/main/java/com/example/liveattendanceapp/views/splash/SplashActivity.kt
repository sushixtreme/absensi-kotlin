package com.example.liveattendanceapp.views.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.example.liveattendanceapp.R
import com.example.liveattendanceapp.hawkstorage.HawkStorage
import com.example.liveattendanceapp.views.login.LoginActivity
import com.example.liveattendanceapp.views.main.MainActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        afterDelayGoToLogin()
    }

    private fun afterDelayGoToLogin() {
        Handler(Looper.getMainLooper()).postDelayed({
            checkIsLogin()
        },1200)
    }

    private fun checkIsLogin() {
        val isLogin = HawkStorage.instance(this).isLogin()
        if (isLogin){
            val intent = Intent(this, MainActivity::class.java);
            startActivity(intent)
            finishAffinity()
        }else{
            val intent = Intent(this, LoginActivity::class.java);
            startActivity(intent)
            finishAffinity()
        }
    }
}