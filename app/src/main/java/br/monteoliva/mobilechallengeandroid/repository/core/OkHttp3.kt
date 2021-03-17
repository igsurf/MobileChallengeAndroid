package br.monteoliva.mobilechallengeandroid.repository.core

import okhttp3.OkHttpClient

object OkHttp3 {
    operator fun invoke(interceptor: MicroServiceInterceptor): OkHttpClient{
        return OkHttpClient()
            .newBuilder()
            .addInterceptor(interceptor)
            .build()
    }
}
