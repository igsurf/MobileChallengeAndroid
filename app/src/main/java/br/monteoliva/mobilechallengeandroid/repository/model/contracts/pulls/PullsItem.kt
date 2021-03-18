package br.monteoliva.mobilechallengeandroid.repository.model.contracts.pulls

import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@Parcelize
data class PullsItem(
    @SerializedName("html_url")
    val url: String? = null,
    @SerializedName("body")
    val body: String? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("state")
    val state: String? = null,
    @SerializedName("user")
    val user: User? = null) : Parcelable