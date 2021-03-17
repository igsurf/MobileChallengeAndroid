package br.monteoliva.mobilechallengeandroid.core.extensions

import androidx.appcompat.app.AppCompatActivity

import br.monteoliva.mobilechallengeandroid.R

/**
 * Classe de Animacao de Activity
 *
 * @author Claudio Monteoliva
 * @version 1.0
 * @copyright 2021 Monteoliva Developer
 */
fun AppCompatActivity.leftToRight() {
    overridePendingTransition(R.anim.lefttoright, R.anim.stable)
}

fun AppCompatActivity.rightToLeft() {
    overridePendingTransition(R.anim.righttoleft, R.anim.stable)
}

fun AppCompatActivity.topToBottom() {
    overridePendingTransition(R.anim.toptobottom, R.anim.stable)
}

fun AppCompatActivity.bottomToTop() {
    overridePendingTransition(R.anim.bottomtotop, R.anim.stable)
}