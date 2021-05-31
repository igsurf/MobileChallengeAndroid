package br.monteoliva.mobilechallengeandroid.repository.core.modules

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

import br.monteoliva.mobilechallengeandroid.viewmodel.MainViewModel
import br.monteoliva.mobilechallengeandroid.viewmodel.PullsViewModel

val viewModelModule = module {
    viewModel { MainViewModel(get()) }
    viewModel { PullsViewModel(get()) }
}
