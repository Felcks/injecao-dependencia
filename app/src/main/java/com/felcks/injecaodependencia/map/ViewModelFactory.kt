package com.felcks.injecaodependencia.map

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.felcks.injecaodependencia.common.domain.iteractors.CarregaListaObraUseCase

class ViewModelFactory(val carregaListaObraUseCase: CarregaListaObraUseCase): ViewModelProvider.Factory{


    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java!!)) {
            return MainViewModel(carregaListaObraUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}