package com.example.a14hw.data

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

private const val BASE_URL = "https://api.nasa.gov"
private const val API_KEY = "e6KQgqK0koulWmV6aLgR68gniQ0eU0aoEhUh7mr8"

object RetrofitInstance {
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val searchAPI: SearchAPI = retrofit.create(SearchAPI::class.java)
}

interface SearchAPI {
    @GET("/mars-photos/api/v1/rovers/curiosity/photos")
    suspend fun getMarsPhotosFromAPI(
        @Query("sol") sol: Int = 200,
        @Query("api_key") apiKey: String = API_KEY,
        @Query("page") page: Int = 1
    ): MarsPhotosDto
}



