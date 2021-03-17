package br.monteoliva.mobilechallengeandroid.repository.core.modules

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

import br.monteoliva.mobilechallengeandroid.viewmodel.MainViewModel

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
}
