package ru.givemesomecoffee.androidplayground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch
import ru.givemesomecoffee.androidplayground.data.network.BooksApi


class MainActivity : AppCompatActivity() {
    private lateinit var booksListView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        booksListView = findViewById(R.id.books_list)

        lifecycleScope.launch {
           val listResult = BooksApi.retrofitService.getPhotos()
           booksListView.adapter = BooksListAdapter(listResult.items)
        }
        booksListView.layoutManager = GridLayoutManager(this, 2)
    }
}