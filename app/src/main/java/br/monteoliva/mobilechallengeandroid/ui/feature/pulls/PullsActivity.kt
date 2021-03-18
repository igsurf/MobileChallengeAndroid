package br.monteoliva.mobilechallengeandroid.ui.feature.pulls

import android.content.Intent
import android.net.Uri
import java.text.MessageFormat

import androidx.recyclerview.widget.LinearLayoutManager

import kotlinx.android.synthetic.main.activity_pulls.*
import kotlinx.android.synthetic.main.app_bar.*

import org.koin.androidx.viewmodel.ext.android.viewModel

import br.monteoliva.mobilechallengeandroid.R
import br.monteoliva.mobilechallengeandroid.repository.core.extensions.getDividerItemDecoration
import br.monteoliva.mobilechallengeandroid.repository.core.extensions.gone
import br.monteoliva.mobilechallengeandroid.repository.core.extensions.visible
import br.monteoliva.mobilechallengeandroid.repository.model.contracts.pulls.PullsItem
import br.monteoliva.mobilechallengeandroid.ui.adapter.PullItemAdapter
import br.monteoliva.mobilechallengeandroid.ui.feature.BaseActivity
import br.monteoliva.mobilechallengeandroid.viewmodel.PullsViewModel

class PullsActivity : BaseActivity(R.layout.activity_pulls) {
    private val pullsViewModel: PullsViewModel by viewModel()
    private var itemAdapter: PullItemAdapter? = null

    private var owner: String  = ""
    private var repo: String = ""
    private var totalOpen: Int = 0
    private var totalClose: Int = 0


    override fun initViews() {
        intent?.extras?.let {
            owner = it.getString(OWNER, "")
            repo  = it.getString(REPO, "")
        }

        setupToolBar(R.id.toolbar)
        setActionBarTitle("")
        setActionBarHomeButton()
        toolbar_title.text = repo
    }

    override fun initViewModel() {
        pullsViewModel.apply {
            loadList(owner, repo)
            pullsList.observe(this@PullsActivity, {
                loadRows(it)
            })
        }
    }

    private fun loadRows(list: MutableList<PullsItem>) {
        list.forEach() {
            when (it.state) {
                "open" -> totalOpen += 1
                "close" -> totalClose += 1
            }
        }

        pullOpened.text = MessageFormat.format(getString(R.string.title_opened), totalOpen.toString())
        pullClosed.text = MessageFormat.format(getString(R.string.title_closed), totalClose.toString())

        itemAdapter = PullItemAdapter { url ->
            url?.let { goBrowserGitHub(it) }
        }.apply {
            onLoadFinish = { setLoading(false) }
            updateList(list)
        }

        rvPulls.apply {
            setHasFixedSize(true)
            adapter = itemAdapter
            layoutManager = LinearLayoutManager(this@PullsActivity, LinearLayoutManager.VERTICAL, false)
            this.getDividerItemDecoration(baseContext)
        }
    }

    fun setLoading(hasShow: Boolean) {
        progressBarPulls.apply {
            if (hasShow) { this.visible() } else { this.gone() }
        }
    }

    private fun goBrowserGitHub(url: String) {
        Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(url)
            startActivity(this)
            animBottomToTop()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        back()
        return true
    }

    override fun back() {
        finish()
        animRightToLeft()
    }

    companion object {
        const val OWNER = "owner"
        const val REPO = "repo"
    }
}