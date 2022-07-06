package com.example.recyclerviewitemcall

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val TAG : String = "jeongmin"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addList()

    }

/* 일반 함수 */
    // 리스트에 데이터 추가
    private fun addList() {
        val list = ArrayList<UserData>()
        list.add(UserData("이정민", "01086991406"))
        list.add(UserData("이라떼", "01020170629"))

        val adapter = RecyclerUserAdapter(list)
        listUser.adapter = adapter
    }
    // permission 체크
    private fun checkPermission() {
        val status = ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE)
        if(status == PackageManager.PERMISSION_GRANTED) { // 권한 있을 경우
            Log.d(TAG, "permission granted")
        } else if(status == PackageManager.PERMISSION_DENIED){
            requestPermission()
            Log.d(TAG, "permission denied")
        }
    }
    // permission 요청
    private fun requestPermission() {
        ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE), 99)
    }

    fun onClickCall(view: View) {

    }
}