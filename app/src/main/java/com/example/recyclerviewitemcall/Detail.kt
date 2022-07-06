package com.example.recyclerviewitemcall

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_detail.*

class Detail : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        tvNumber.text = "${intent.getStringExtra("number")}"
    }

    fun onClickCall(view: View) {
        val intent = Intent(Intent.ACTION_CALL, Uri.parse("tel:${intent.getStringExtra("number")}"))
        startActivity(intent)
    }

}