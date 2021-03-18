package br.monteoliva.mobilechallengeandroid.repository.core.extensions

import java.text.DecimalFormat
import java.text.DecimalFormatSymbols
import java.util.*
import java.math.RoundingMode

import android.content.Context
import android.view.View
import androidx.annotation.ColorInt
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView

import br.monteoliva.mobilechallengeandroid.R

fun RecyclerView.getDividerItemDecoration(baseContext: Context) {
    this.addItemDecoration(
        DividerItemDecoration(baseContext, DividerItemDecoration.VERTICAL).apply {
            ContextCompat.getDrawable(baseContext, R.drawable.diviser)?.let { setDrawable(it) }
        }
    )
}

fun Double.roundOffDecimal(): String {
    val df = DecimalFormat("##.#", DecimalFormatSymbols(Locale.US))
    df.roundingMode = RoundingMode.FLOOR
    return df.format(this)
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}

fun Toolbar.setNavigationIconColor(@ColorInt color: Int) = navigationIcon?.mutate()?.let {
    it.setTint(color)
    this.navigationIcon = it
}