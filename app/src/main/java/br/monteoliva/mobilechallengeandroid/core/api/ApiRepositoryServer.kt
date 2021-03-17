package br.monteoliva.mobilechallengeandroid.core.api

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ApiRepositoryServer(private val apiService: ApiService) {
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