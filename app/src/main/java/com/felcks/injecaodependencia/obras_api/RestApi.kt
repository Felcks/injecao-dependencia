package com.felcks.injecaodependencia.obras_api

import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

class RestApi {

    val auth = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VybmFtZSI6ImZpc2NhbDEiLCJpYXQiOjE1NDAxNzQzNjF9.Tl2a_aAhOraKTmsEgCkLwLnTqh09n-_RsVgNS09ti0A"

    private val api : IRestApi

    init{

        val client: OkHttpClient = OkHttpClient.Builder()
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()


        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.obras.dev.sigelu.com//v1/")
            .addConverterFactory(MoshiConverterFactory.create().asLenient())
            .client(client)
            .build()


        api = retrofit.create(IRestApi::class.java)
    }

    fun getListagemObras() : Call<List<ObraListagemDataResponse>> {
        return api.getListagemObras(auth)
    }


}