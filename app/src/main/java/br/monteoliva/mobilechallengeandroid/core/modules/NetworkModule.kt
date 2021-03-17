package br.monteoliva.mobilechallengeandroid.core.modules

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

import retrofit2.Retrofit

import br.monteoliva.mobilechallengeandroid.core.api.*
import br.monteoliva.mobilechallengeandroid.core.preferences.Preferences
import br.monteoliva.mobilechallengeandroid.core.preferences.SharedPreferencesImpl

var networkModule = module {
    single<Preferences> { SharedPreferencesImpl(androidContext()) }
    single { ApiRetrofit(get()) }
    single {(get() as Retrofit).create(ApiService::class.java) }

    factory { ApiOkHttp3(get()) }
    factory { ApiServiceInterceptor() }
    factory { ApiRepositoryServer(get()) }
}