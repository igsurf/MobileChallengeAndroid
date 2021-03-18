package br.monteoliva.mobilechallengeandroid.ui.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

import com.bumptech.glide.Glide

import de.hdodenhof.circleimageview.CircleImageView

import br.monteoliva.mobilechallengeandroid.repository.model.contracts.repos.Item
import br.monteoliva.mobilechallengeandroid.R
import br.monteoliva.mobilechallengeandroid.repository.core.extensions.roundOffDecimal
import kotlinx.coroutines.flow.callbackFlow

class ReposItemAdapter(private val callback: (String?, String?) -> Unit) : RecyclerView.Adapter<ReposItemAdapter.ViewHolder>()  {
    private var list: MutableList<Item> = emptyList<Item>().toMutableList()

    var onLoadFinish: (() -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.repository_item, parent, false)
        return ViewHolder(view)
    }

    fun updateList(items: MutableList<Item>?) {
        items?.let {
            list = it
            notifyDataSetChanged()
            onLoadFinish?.invoke()
        }
    }

    override fun getItemCount(): Int = list.size
    override fun getItemId(position: Int): Long = 0

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val item = getItem(position)
        var stars = 0.00
        var forks = 0.00

        viewHolder.apply {
            item.apply {
                stargazersCount?.let { stars = it.toDouble() / 1000 }
                forksCount?.let      { forks = it.toDouble() / 1000 }

                repoTitle.text = name
                repoDescription.text = description
                repoFork.text  = forks.roundOffDecimal() + "k"
                repoStars.text = stars.roundOffDecimal() + "k"
                repoUserName.text = owner?.login
                repoName.text = owner?.login

                Glide.with(viewHolder.itemView)
                    .load(owner?.avatarUrl)
                    .centerCrop()
                    .into(profile_image)

                itemView.setOnClickListener {
                    callback.invoke(owner?.login, name)
                }
            }
        }
    }

    private fun getItem(position: Int): Item = list[position]

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val repoTitle: TextView       = itemView.findViewById(R.id.repoTitle)
        val repoDescription: TextView = itemView.findViewById(R.id.repoDescription)
        val repoFork: TextView        = itemView.findViewById(R.id.repoFork)
        val repoStars: TextView       = itemView.findViewById(R.id.repoStars)
        val repoUserName: TextView    = itemView.findViewById(R.id.repoUserName)
        val repoName: TextView        = itemView.findViewById(R.id.repoName)
        val profile_image: CircleImageView = itemView.findViewById(R.id.profile_image)
    }
}