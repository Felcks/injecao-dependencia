package com.felcks.injecaodependencia

import com.felcks.injecaodependencia.domain.Obra
import com.felcks.injecaodependencia.obras_api.RestApi

class CarregaObrasUseCase(val api: RestApi) {

    interface Callback {
        fun listaObras(list: List<Obra>)
    }

    fun getListaObras(callback: Callback){


    }

}