package com.felcks.injecaodependencia

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.felcks.injecaodependencia.domain.Obra
import com.felcks.injecaodependencia.obras_api.RestApi
import kotlinx.android.synthetic.main.activity_main.*
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import rx.subscriptions.CompositeSubscription
import java.util.*

class MainActivity : AppCompatActivity() {

    val api: RestApi = RestApi()
    private var subscriptions = CompositeSubscription()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.carregarObras(this)
    }

    fun showList(list: List<Obra>){

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        val mRecyclerView = rv_list
        mRecyclerView.layoutManager = layoutManager
        val adapter = ObraListAdapter(this, list)
        mRecyclerView.adapter = adapter
    }

    fun carregarObras(context: Context) {

        val subscription = getObras()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { retrievedObras ->
                    showList(retrievedObras)
                },
                { e ->

                }
            )
        subscriptions.add(subscription)
    }

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
                        it.local_formatado ?: "")
                }

                subscriber.onNext(obras)
                subscriber.onCompleted()
            } else {
                subscriber.onError(Throwable(response.message()))
            }
        }
    }
}
