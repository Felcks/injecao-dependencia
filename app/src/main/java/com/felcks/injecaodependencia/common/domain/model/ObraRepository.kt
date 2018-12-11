package com.felcks.injecaodependencia.common.domain.model

import com.felcks.injecaodependencia.obras_api.RestApi
import io.reactivex.Observable


class ObraRepository() {

    val api: RestApi = RestApi()

    fun getObras(): Observable<List<Obra>> {

        return Observable.create { subscriber ->

            val callResponse = api.getListagemObras()
            val response = callResponse.execute()

            if (response.isSuccessful) {

                val obras: List<Obra> = response.body().map {

                    Obra(
                        it.id,
                        it.situacao ?: "",
                        it.numero_contrato ?: "",
                        it.multipla_localizacao ?: false,
                        it.local_formatado ?: ""
                    )
                }

                subscriber.onNext(obras)
                subscriber.onComplete()
            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }
}