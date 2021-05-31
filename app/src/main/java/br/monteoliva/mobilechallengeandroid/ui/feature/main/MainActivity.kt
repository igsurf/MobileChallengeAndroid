package br.monteoliva.mobilechallengeandroid.ui.feature.main

import android.content.Intent
import androidx.recyclerview.widget.LinearLayoutManager

import org.koin.androidx.viewmodel.ext.android.viewModel

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar.*

import br.monteoliva.mobilechallengeandroid.R
import br.monteoliva.mobilechallengeandroid.repository.core.extensions.getDividerItemDecoration
import br.monteoliva.mobilechallengeandroid.repository.core.extensions.gone
import br.monteoliva.mobilechallengeandroid.repository.core.extensions.visible
import br.monteoliva.mobilechallengeandroid.repository.model.contracts.repos.Item
import br.monteoliva.mobilechallengeandroid.ui.adapter.ReposItemAdapter
import br.monteoliva.mobilechallengeandroid.ui.feature.BaseActivity
import br.monteoliva.mobilechallengeandroid.ui.feature.pulls.PullsActivity
import br.monteoliva.mobilechallengeandroid.viewmodel.MainViewModel

class MainActivity : BaseActivity(R.layout.activity_main) {
    private val mainViewModel: MainViewModel by viewModel()
    private var itemAdapter: ReposItemAdapter? = null

    private var numPage: Int = 1

    override fun initViews() {
        setupToolBar(R.id.toolbar)
        setActionBarTitle("")
        toolbar_title.text = getString(R.string.title_main)
    }

    override fun initViewModel() {
        mainViewModel.getRepository()
        mainViewModel.repositories.observe(this, {
            it.items?.let { list-> loadRows(list) }
        })
    }

    private fun loadRows(list: MutableList<Item>) {
        itemAdapter = ReposItemAdapter { owner, repo ->
            loadPullRequest(owner, repo)
        }.apply {
            onLoadFinish = { setLoading(false) }
            updateList(list)
        }

        rvRepos.apply {
            setHasFixedSize(true)
            adapter = itemAdapter
            layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
            this.getDividerItemDecoration(baseContext)
        }
    }

    fun setLoading(hasShow: Boolean) {
        progressBar.apply {
            if (hasShow) { this.visible() } else { this.gone() }
        }
    }

    private fun loadPullRequest(owner: String?, repo: String?) {
        Intent(this, PullsActivity::class.java).apply {
            putExtra(PullsActivity.OWNER, owner)
            putExtra(PullsActivity.REPO, repo)
            startActivity(this)
            animLeftToRight()
        }
    }

    override fun back() { finishAffinity() }
}