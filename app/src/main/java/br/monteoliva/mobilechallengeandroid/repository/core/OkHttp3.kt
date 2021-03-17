package br.monteoliva.mobilechallengeandroid.repository.core

import br.monteoliva.mobilechallengeandroid.repository.core.ServiceInterceptor
import okhttp3.OkHttpClient

object OkHttp3 {
    operator fun invoke(interceptor: ServiceInterceptor): OkHttpClient{
        return OkHttpClient()
            .newBuilder()
            .addInterceptor(interceptor)
            .build()
    }
}
