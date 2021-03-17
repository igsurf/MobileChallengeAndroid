package br.monteoliva.mobilechallengeandroid.view

import android.os.Bundle
import android.view.KeyEvent
import androidx.annotation.IdRes
import androidx.annotation.LayoutRes
import androidx.annotation.StringRes
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

import br.monteoliva.mobilechallengeandroid.core.extensions.leftToRight
import br.monteoliva.mobilechallengeandroid.core.extensions.rightToLeft
import br.monteoliva.mobilechallengeandroid.core.extensions.topToBottom
import br.monteoliva.mobilechallengeandroid.core.extensions.bottomToTop

abstract class BaseActivity(@LayoutRes private val resource: Int) : AppCompatActivity() {
    private var actionBar: ActionBar? = null
    private var mToolbar: Toolbar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(resource)
        initViews()
        initViewModel()
    }

    fun setupToolBar(@IdRes resource: Int) {
        mToolbar = findViewById(resource)
        setSupportActionBar(mToolbar)
        actionBar = supportActionBar
    }

    fun setActionBarHome()       { actionBar?.setHomeButtonEnabled(true) }
    fun setActionBarHomeButton() { actionBar?.setDisplayHomeAsUpEnabled(true) }

    fun setActionBarNotHome()       { actionBar?.setHomeButtonEnabled(false) }
    fun setActionBarNotHomeButton() { actionBar?.setDisplayHomeAsUpEnabled(false) }

    fun setActionBarTitle(title: String)         { actionBar?.title = title }
    fun setActionBarTitle(@StringRes title: Int) { actionBar?.title = getString(title) }

    fun setActionBarSubTitle(title: String)         { actionBar?.subtitle = title }
    fun setActionBarSubTitle(@StringRes title: Int) { actionBar?.subtitle = getString(title) }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        return if (keyCode == KeyEvent.KEYCODE_BACK) {
            back()
            true
        }
        else {
            super.onKeyDown(keyCode, event)
        }
    }

    fun animLeftToRight() { this.leftToRight() }
    fun animRightToLeft() { this.rightToLeft() }
    fun animTopToBottom() { this.topToBottom() }
    fun animBottomToTop() { this.bottomToTop() }

    abstract fun initViews()
    abstract fun initViewModel()
    abstract fun back()
}