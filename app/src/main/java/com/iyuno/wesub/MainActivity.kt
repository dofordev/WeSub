package com.iyuno.wesub

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import kotlin.system.exitProcess


class MainActivity : AppCompatActivity() {
    private val TAG = MainActivity::class.java.simpleName
    private lateinit var context: Context
    private var keepSplashOnScreen = true

    //splash 대기 시간
    private val delay = 300L

    //뒤로가기 연속 클릭 대기 시간
    private var backPressedWait: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()
        super.onCreate(savedInstanceState)
        Log.i(TAG, "onCreate")
        setContentView(R.layout.activity_main)
        context = this
        splashScreen.setKeepOnScreenCondition { keepSplashOnScreen }
        Handler(Looper.getMainLooper()).postDelayed({
            keepSplashOnScreen = false
                                                    }, delay)

    }


    override fun onBackPressed() {
        if (System.currentTimeMillis() - backPressedWait >= 2000) {
            backPressedWait = System.currentTimeMillis()
            Toast.makeText(context, Constants.appCloseWaitText, Toast.LENGTH_SHORT).show()
        } else {
            finishAffinity()
            exitProcess(0)
        }
    }
}