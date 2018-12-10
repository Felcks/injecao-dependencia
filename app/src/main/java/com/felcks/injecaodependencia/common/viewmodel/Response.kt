package com.felcks.injecaodependencia.common.viewmodel


class Response(val status: Status,
               val data: String?,
               val error: Throwable?) {


    companion object {
        fun loading(): Response {
            return Response(Status.LOADING, null, null)
        }

        fun success(data: String): Response {
            return Response(Status.SUCCESS, data, null)
        }

        fun error(error: Throwable): Response {
            return Response(Status.ERROR, null, error)
        }
    }


}