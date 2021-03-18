package br.monteoliva.mobilechallengeandroid.repository.model.contracts.repos

import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import android.os.Parcelable
import br.monteoliva.mobilechallengeandroid.repository.model.contracts.repos.Item
import com.google.gson.annotations.Expose


@Parcelize
data class Repos(@SerializedName("total_count")        @Expose var totalCount: Int? = null,
                 @SerializedName("incomplete_results") @Expose var incompleteResults: Boolean? = null,
                 @SerializedName("items")              @Expose var items: MutableList<Item>? = null
) : Parcelable