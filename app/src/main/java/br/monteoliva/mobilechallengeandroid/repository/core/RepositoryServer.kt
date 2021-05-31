package br.monteoliva.mobilechallengeandroid.repository.core

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

import br.monteoliva.mobilechallengeandroid.repository.api.ApiService
import br.monteoliva.mobilechallengeandroid.repository.model.contracts.pulls.PullsItem
import br.monteoliva.mobilechallengeandroid.repository.model.contracts.repos.Repos

class RepositoryServer(private val apiService: ApiService) {
    fun getRepositories(callback: (Repos) -> Unit) {
        apiService.getRepositories("language:Java", "stars", 1).apply {
            enqueue(object: Callback<Repos> {
                override fun onResponse(call: Call<Repos>, response: Response<Repos>) {
                    response.body()?.let { callback.invoke(it) }
                }

                override fun onFailure(call: Call<Repos>, t: Throwable) {
                }
            })
        }
    }

    fun getPulls(owner: String, repo: String, callback: (MutableList<PullsItem>) -> Unit) {
        apiService.getPulls(owner, repo).apply {
            enqueue(object: Callback<MutableList<PullsItem>> {
                override fun onResponse(call: Call<MutableList<PullsItem>>, response: Response<MutableList<PullsItem>>) {
                    response.body()?.let { callback.invoke(it) }
                }

                override fun onFailure(call: Call<MutableList<PullsItem>>, t: Throwable) {
                }
            })
        }
    }


}