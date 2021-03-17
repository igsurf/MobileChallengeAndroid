package br.monteoliva.mobilechallengeandroid.repository.core

import br.monteoliva.mobilechallengeandroid.repository.api.ApiService


class RepositoryServer(private val apiService: ApiService) {
//    fun getBalance(callback: (Balance) -> Unit) {
//        apiService.getBalance().apply {
//            enqueue(object: Callback<Balance> {
//                override fun onResponse(call: Call<Balance>, response: Response<Balance>) {
//                    response.body()?.let { callback.invoke(it) }
//                }
//
//                override fun onFailure(call: Call<Balance>, t: Throwable) {}
//            })
//        }
//    }
//
//    fun getStatements(offset: Int, callback: (Statements) -> Unit) {
//        apiService.getStatement(10, offset).apply {
//            enqueue(object: Callback<Statements> {
//                override fun onResponse(call: Call<Statements>, response: Response<Statements>) {
//                    response.body()?.let { callback.invoke(it) }
//                }
//
//                override fun onFailure(call: Call<Statements>, t: Throwable) {}
//            })
//        }
//    }
//
//    fun getDetail(id: String, callback: (Detail) -> Unit) {
//        apiService.getDetail(id).apply {
//            enqueue(object: Callback<Detail> {
//                override fun onResponse(call: Call<Detail>, response: Response<Detail>) {
//                    response.body()?.let { callback.invoke(it) }
//                }
//
//                override fun onFailure(call: Call<Detail>, t: Throwable) {}
//            })
//        }
//    }
}