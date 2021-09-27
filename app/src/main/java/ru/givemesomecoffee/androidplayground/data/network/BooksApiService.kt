package ru.givemesomecoffee.androidplayground.data.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

import retrofit2.http.GET
import retrofit2.http.Query
import ru.givemesomecoffee.androidplayground.data.network.entity.BookApiResponse

private const val BASE_URL =
    "https://www.googleapis.com/books/v1/"
private const val TOKEN =
    "AIzaSyDIPaE_7MbnDrPkxVPvD3flW0FElTOWRtA"

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()
val interceptor = Interceptor { chain ->
    val request = chain.request().newBuilder().addHeader("key", TOKEN).build()
    chain.proceed(request)
}
val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .client(client)
    .baseUrl(BASE_URL)
    .build()


//"123"
    //"humann commit"
interface BookApiService {
    @GET("volumes")
    suspend fun getPhotos(@Query("q") categories: String = "fiction"): BookApiResponse
}

object BooksApi {
    val retrofitService : BookApiService by lazy {
        retrofit.create(BookApiService::class.java) }
}


