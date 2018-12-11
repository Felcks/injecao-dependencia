package com.felcks.injecaodependencia.map

import com.felcks.injecaodependencia.common.domain.iteractors.CarregaListaObraUseCase
import com.felcks.injecaodependencia.common.domain.model.ObraRepository
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @Provides
    fun provideLobbyGreetingRepository(): ObraRepository {
        return ObraRepository()
    }

    @Provides
    fun provideLobbyViewModelFactory(carregaListaObraUseCase: CarregaListaObraUseCase): ViewModelFactory {
        return ViewModelFactory(carregaListaObraUseCase)
    }
}