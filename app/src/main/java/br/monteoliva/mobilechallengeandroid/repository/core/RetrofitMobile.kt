package br.monteoliva.mobilechallengeandroid.repository.core

import okhttp3.OkHttpClient

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitMobile {
    operator fun invoke(okHttpClient: OkHttpClient): Retrofit{
        return Retrofit
                .Builder()
                .baseUrl(Constants.API_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}
