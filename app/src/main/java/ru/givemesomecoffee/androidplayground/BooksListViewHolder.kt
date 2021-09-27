package ru.givemesomecoffee.androidplayground

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.givemesomecoffee.androidplayground.data.network.entity.Item

class BooksListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: Item){
itemView.findViewById<TextView>(R.id.textView).text = item.volumeInfo.title
    }
}