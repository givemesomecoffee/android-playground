package ru.givemesomecoffee.androidplayground

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch
import ru.givemesomecoffee.androidplayground.data.network.BooksApi

//robo commit1
//1
//wsd
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lifecycleScope.launch {
            val listResult = BooksApi.retrofitService.getPhotos()
            findViewById<TextView>(R.id.text).text = listResult.toString()
        }
    }
}