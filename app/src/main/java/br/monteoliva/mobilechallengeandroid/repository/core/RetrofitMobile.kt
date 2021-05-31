package br.monteoliva.mobilechallengeandroid.repository.core

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitMobile {
    operator fun invoke(): Retrofit{
        return Retrofit
                .Builder()
                .baseUrl(Constants.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}
