package br.monteoliva.mobilechallengeandroid.core.api

import okhttp3.OkHttpClient

object ApiOkHttp3 {
    operator fun invoke(interceptor: ApiServiceInterceptor): OkHttpClient{
        return OkHttpClient()
            .newBuilder()
            .addInterceptor(interceptor)
            .build()
    }
}
