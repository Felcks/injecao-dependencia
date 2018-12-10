package com.felcks.injecaodependencia.domain

import java.util.*

data class Obra(val id: Int,
                var situacao: String,
                val contrato: String,
                val multiplosLocais: Boolean,
                var local: String){

    fun getContractName(): String {
        return "Contrato ${this.contrato}"
    }
}