package br.monteoliva.mobilechallengeandroid.repository.model.contracts.pulls

import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable

@Parcelize
data class User(
    @SerializedName("avatar_url")
    val avatarUrl: String? = null,
    @SerializedName("login")
    val login: String? = null
) : Parcelable