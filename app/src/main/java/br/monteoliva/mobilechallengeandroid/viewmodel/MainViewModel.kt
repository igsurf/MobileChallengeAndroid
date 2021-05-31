package br.monteoliva.mobilechallengeandroid.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import br.monteoliva.mobilechallengeandroid.repository.core.RepositoryServer
import br.monteoliva.mobilechallengeandroid.repository.model.contracts.repos.Repos

class MainViewModel(private val repositoryServer: RepositoryServer) : ViewModel() {
    var repositories: MutableLiveData<Repos> = MutableLiveData()

    fun getRepository() {
        repositoryServer.getRepositories() {
            repositories.postValue(it)
        }
    }
}