package com.felcks.injecaodependencia.map

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.felcks.injecaodependencia.common.domain.iteractors.CarregaListaObraUseCase
import com.felcks.injecaodependencia.common.viewmodel.Response
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class MainViewModel(val carregaListaObraUseCase: CarregaListaObraUseCase): ViewModel() {

    val disposables = CompositeDisposable()
    var response = MutableLiveData<Response>()

    override fun onCleared() {
        disposables.clear()
    }

    fun carregarListaObras() {
        carregarObras(carregaListaObraUseCase)
    }

    fun response(): MutableLiveData<Response> {
        return response
    }

    fun carregarObras(carregaListaObraUseCase: CarregaListaObraUseCase) {

        disposables.add(carregaListaObraUseCase.executa()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { _r -> response.setValue(Response.loading()) }
            .subscribe(
                { result -> response.setValue(Response.success(result)) },
                { throwable -> response.setValue(Response.error(throwable)) }
            )
        )
    }
}