package com.temanrendy.architecture.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.temanrendy.architecture.R
import com.temanrendy.architecture.model.User
import kotlinx.android.synthetic.main.item_list.view.*

class UserAdapter (private val list: ArrayList<User>): RecyclerView.Adapter<UserAdapter.UserViewHolder>(){
    inner class UserViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        fun bind(user: User){
            with(itemView){
                val text = "id: ${user.id}\n" +
                "email: ${user.email}\n" +
                "first_name: ${user.first_name}\n" +
                "last_name: ${user.last_name}\n" +
                "avatar: ${user.avatar}"

                tvResponse.text = text
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserAdapter.UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserAdapter.UserViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

}