package br.monteoliva.mobilechallengeandroid.repository.api

import br.monteoliva.mobilechallengeandroid.repository.model.contracts.pulls.PullsItem
import retrofit2.Call
import retrofit2.http.GET

import br.monteoliva.mobilechallengeandroid.repository.model.contracts.repos.Repos
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("/search/repositories?")
    fun getRepositories(@Query("q") q: String,
                        @Query("sort") sort: String,
                        @Query("page") page: Int) : Call<Repos>

    @GET("/repos/{owner}/{repo}/pulls")
    fun getPulls(@Path("owner") owner: String,
                 @Path("repo") repo : String) : Call<MutableList<PullsItem>>
}