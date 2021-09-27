package ru.givemesomecoffee.androidplayground

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.givemesomecoffee.androidplayground.data.network.entity.Item
import java.util.zip.Inflater

class BooksListAdapter(private val books: List<Item>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        parent.context

        return BooksListViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as BooksListViewHolder).bind(books[position])
    }

    override fun getItemCount(): Int {
        return books.size
    }
}


