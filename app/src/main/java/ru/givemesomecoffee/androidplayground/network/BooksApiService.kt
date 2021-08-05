package ru.givemesomecoffee.androidplayground.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL =
    "https://www.googleapis.com/books/v1/"
private const val TOKEN =
    "AIzaSyDIPaE_7MbnDrPkxVPvD3flW0FElTOWRtA"


val interceptor = Interceptor { chain ->
    val request = chain.request().newBuilder().addHeader("key", TOKEN).build();
    chain.proceed(request)
}
val client: OkHttpClient = OkHttpClient.Builder().addInterceptor(interceptor).build()



private val retrofit = Retrofit.Builder()
    .addConverterFactory(ScalarsConverterFactory.create())
    .client(client)
    .baseUrl(BASE_URL)
    .build()

interface BookApiService {
    @GET("volumes")
    suspend fun getPhotos(@Query("q") author: String = "test"): String
}

object BooksApi {
    val retrofitService : BookApiService by lazy {
        retrofit.create(BookApiService::class.java) }
}


