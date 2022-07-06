package com.example.recyclerviewitemcall

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_list.view.*

class RecyclerUserAdapter(private val items: ArrayList<com.example.recyclerviewitemcall.UserData>) : RecyclerView.Adapter<RecyclerUserAdapter.ViewHolder>() {

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: RecyclerUserAdapter.ViewHolder, position: Int) {

        val item = items[position]
        val listener = View.OnClickListener { it ->
            Toast.makeText(it.context, "Clicked -> name : ${item.name}\nnumber : ${item.number}", Toast.LENGTH_SHORT).show()
            val intentDetail = Intent(holder.itemView?.context, Detail::class.java)
            intentDetail.putExtra("number", item.number) // detail 로 번호 전달
            ContextCompat.startActivity(holder.itemView.context, intentDetail, null)
        }

        holder.apply {
            bind(listener, item)
            itemView.tag = item
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return RecyclerUserAdapter.ViewHolder(inflatedView)
    }

    // 각 항목에 필요한 기능을 구현
    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        private var view: View = v

        fun bind(listener: View.OnClickListener, item: com.example.recyclerviewitemcall.UserData) {
            view.txtUserName.text = item.name
            view.txtUserNumber.text = item.number
            view.setOnClickListener(listener)
        }
    }

}