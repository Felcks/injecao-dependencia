package com.felcks.injecaodependencia.common.domain.iteractors

import com.felcks.injecaodependencia.common.domain.model.Obra
import com.felcks.injecaodependencia.obras_api.RestApi
import io.reactivex.Observable

interface CarregaObrasUseCase {

    fun executa(): Observable<List<Obra>>
}