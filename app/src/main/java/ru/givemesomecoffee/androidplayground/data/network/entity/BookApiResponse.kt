package ru.givemesomecoffee.androidplayground.data.network.entity

class BookApiResponse(val items: List<Item>)

data class Item(
    val id : String,
    val volumeInfo: ApiVolumeInfo
)

data class ApiVolumeInfo(
    val title: String,
    val authors: List<String>?,
    val imageLinks: ImageLinks?
)

data class ImageLinks(val smallThumbnail: String, val thumbnail: String)