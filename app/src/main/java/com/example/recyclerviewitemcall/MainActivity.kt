package com.example.recyclerviewitemcall

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
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
}