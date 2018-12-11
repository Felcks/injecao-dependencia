package com.felcks.injecaodependencia

import android.annotation.SuppressLint
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.felcks.injecaodependencia.common.domain.model.Obra

class ObraListAdapter(val context: Context, val obras: List<Obra>) :
    RecyclerView.Adapter<ObraListAdapter.MyViewHolder>() {

    val mLayoutInflater: LayoutInflater
    val filterList = mutableListOf<Obra>()


    init {
        mLayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        filterList.addAll(obras)
    }

    override fun getItemCount(): Int = filterList.size

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val obra: Obra = filterList.get(position)

        holder?.tvContractName!!.text = obra.getContractName()
        holder.tvSituation.text = obra.situacao

        /* Setando a multiplicidade de locais */
        var statuslocal = obra.multiplosLocais
        if (statuslocal == true) {
            holder.tvlocais.text = "Mútiplos"
        } else {
            holder.tvlocais.text = obra.local
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {

        val view: View = mLayoutInflater.inflate(R.layout.item_obra_map, parent, false)
        val mvh = MyViewHolder(view)

        return mvh
    }

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tvContractName: TextView
        val tvDistance: TextView
        val tvConclusion: TextView
        val tvSituation: TextView
        val btnSeeWork: Button
        val llObra: LinearLayout
        val tvPrevisao: TextView
        val llObraPrevision: TextView
        val tvlocais: TextView


        init {
            tvContractName = view.findViewById(R.id.tv_contract_name) as TextView
            tvlocais = view.findViewById(R.id.tv_last_review) as TextView
            tvDistance = view.findViewById(R.id.tv_distance) as TextView
            tvConclusion = view.findViewById(R.id.tv_conclusion_prediction) as TextView
            tvSituation = view.findViewById(R.id.tv_situation) as TextView
            btnSeeWork = view.findViewById(R.id.btn_see_work) as Button
            llObra = view.findViewById(R.id.ll_obra) as LinearLayout
            llObraPrevision = view.findViewById(R.id.tv_previsao) as TextView
            tvPrevisao = view.findViewById(R.id.tv_previsao) as TextView
        }
    }

}