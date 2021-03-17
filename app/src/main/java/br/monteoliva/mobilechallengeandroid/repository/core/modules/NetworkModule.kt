package br.monteoliva.mobilechallengeandroid.repository.core.modules

import br.monteoliva.mobilechallengeandroid.repository.core.RepositoryServer
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

import retrofit2.Retrofit

import br.monteoliva.mobilechallengeandroid.repository.api.*
import br.monteoliva.mobilechallengeandroid.repository.core.preferences.Preferences
import br.monteoliva.mobilechallengeandroid.repository.core.preferences.SharedPreferencesImpl
import br.monteoliva.mobilechallengeandroid.repository.core.RetrofitMobile
import br.monteoliva.mobilechallengeandroid.repository.core.OkHttp3
import br.monteoliva.mobilechallengeandroid.repository.core.MicroServiceInterceptor

var networkModule = module {
    single<Preferences> { SharedPreferencesImpl(androidContext()) }
    single { RetrofitMobile(get()) }
    single {(get() as Retrofit).create(ApiService::class.java) }

    factory { OkHttp3(get()) }
    factory { MicroServiceInterceptor() }
    factory { RepositoryServer(get()) }
}