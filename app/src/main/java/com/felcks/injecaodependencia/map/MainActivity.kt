package com.felcks.injecaodependencia.map

import android.arch.lifecycle.Observer
import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.felcks.injecaodependencia.ObraListAdapter
import com.felcks.injecaodependencia.R
import com.felcks.injecaodependencia.common.domain.model.Obra
import com.felcks.injecaodependencia.obras_api.RestApi
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject
import android.arch.lifecycle.ViewModelProviders
import android.view.View
import android.widget.Toast
import com.felcks.injecaodependencia.common.viewmodel.Response
import com.felcks.injecaodependencia.common.viewmodel.Status

class MainActivity : AppCompatActivity() {

    @Inject
    public var viewModelFactory: ViewModelFactory? = null

    var viewModel: MainViewModel? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainViewModel::class.java)
        viewModel!!.response().observe(this, Observer<Response>  {response ->  processResponse(response)})
    }

    fun showList(list: List<Obra>){

        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = LinearLayoutManager.VERTICAL
        val mRecyclerView = rv_list
        mRecyclerView.layoutManager = layoutManager
        val adapter = ObraListAdapter(this, list)
        mRecyclerView.adapter = adapter
    }

    fun processResponse(response: Response?) {
        when (response?.status) {
            Status.LOADING -> renderLoadingState()

            Status.SUCCESS -> renderDataState(response?.data)

            Status.ERROR -> renderErrorState(response?.error)
        }
    }

    private fun renderLoadingState() {
        //greetingTextView.setVisibility(View.GONE)
        //loadingIndicator.setVisibility(View.VISIBLE)
    }

    private fun renderDataState(greeting: String?) {
//        loadingIndicator.setVisibility(View.GONE)
//        greetingTextView.setVisibility(View.VISIBLE)
//        greetingTextView.setText(greeting)
    }

    private fun renderErrorState(throwable: Throwable?) {
//        Timber.e(throwable)
//        loadingIndicator.setVisibility(View.GONE)
//        greetingTextView.setVisibility(View.GONE)
//        Toast.makeText(this, R.string.greeting_error, Toast.LENGTH_SHORT).show()
    }

    fun carregarObras(context: Context) {

//        val subscription = getObras()
//            .subscribeOn(Schedulers.io())
//            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe(
//                { retrievedObras ->
//                    showList(retrievedObras)
//                },
//                { e ->
//
//                }
//            )
//        subscriptions.add(subscription)
    }

//    fun getObras(): Observable<List<Obra>> {
//
//        return Observable.create { subscriber ->
//            val callResponse = api.getListagemObras()
//            val response = callResponse.execute()
//
//            if (response.isSuccessful) {
//
//                val obras: List<Obra> = response.body().map {
//
//                    Obra(
//                        it.id,
//                        it.situacao ?: "",
//                        it.numero_contrato ?: "",
//                        it.multipla_localizacao ?: false,
//                        it.local_formatado ?: ""
//                    )
//                }
//
//                subscriber.onNext(obras)
//                subscriber.onCompleted()
//            } else {
//                subscriber.onError(Throwable(response.message()))
//            }
//        }
//    }
}
