package com.felcks.injecaodependencia.obras_api

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface IRestApi {

    @GET("obra-indireta")
    fun getListagemObras(@Header("Authorization") auth: String): Call<List<ObraListagemDataResponse>>

}