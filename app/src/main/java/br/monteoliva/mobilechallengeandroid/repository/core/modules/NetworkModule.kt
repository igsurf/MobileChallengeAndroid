package br.monteoliva.mobilechallengeandroid.repository.core.modules

import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

import retrofit2.Retrofit

import br.monteoliva.mobilechallengeandroid.repository.api.*
import br.monteoliva.mobilechallengeandroid.repository.core.preferences.Preferences
import br.monteoliva.mobilechallengeandroid.repository.core.preferences.SharedPreferencesImpl
import br.monteoliva.mobilechallengeandroid.repository.core.RetrofitMobile
import br.monteoliva.mobilechallengeandroid.repository.core.RepositoryServer

var networkModule = module {
    single<Preferences> { SharedPreferencesImpl(androidContext()) }
    single { RetrofitMobile() }
    single {(get() as Retrofit).create(ApiService::class.java) }

    factory { RepositoryServer(get()) }
}