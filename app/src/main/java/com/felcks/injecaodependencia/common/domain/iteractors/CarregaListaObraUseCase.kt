package com.felcks.injecaodependencia.common.domain.iteractors

import com.felcks.injecaodependencia.common.domain.model.Obra
import com.felcks.injecaodependencia.common.domain.model.ObraRepository
import io.reactivex.Observable
import javax.inject.Inject

class CarregaListaObraUseCase @Inject constructor(val obraRepository: ObraRepository): CarregaObrasUseCase {

    override fun executa(): Observable<List<Obra>> {
        return obraRepository.getObras()
    }
}