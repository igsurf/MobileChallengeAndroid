package br.monteoliva.mobilechallengeandroid.core.api

import okhttp3.OkHttpClient

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

import br.monteoliva.mobilechallengeandroid.core.Constants

object ApiRetrofit {
    operator fun invoke(okHttpClient: OkHttpClient): Retrofit{
        return Retrofit
                .Builder()
                .baseUrl(Constants.API_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}
