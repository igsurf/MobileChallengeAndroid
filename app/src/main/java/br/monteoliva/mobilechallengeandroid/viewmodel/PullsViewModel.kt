package br.monteoliva.mobilechallengeandroid.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import br.monteoliva.mobilechallengeandroid.repository.core.RepositoryServer
import br.monteoliva.mobilechallengeandroid.repository.model.contracts.pulls.PullsItem

class PullsViewModel(private val repositoryServer: RepositoryServer) : ViewModel() {
    var pullsList: MutableLiveData<MutableList<PullsItem>> = MutableLiveData()

    fun loadList(owner: String, repo: String) {
        repositoryServer.getPulls(owner, repo) {
            pullsList.postValue(it)
        }
    }
}