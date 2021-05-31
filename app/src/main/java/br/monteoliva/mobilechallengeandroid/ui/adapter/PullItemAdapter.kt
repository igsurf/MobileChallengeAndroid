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
import br.monteoliva.mobilechallengeandroid.repository.model.contracts.pulls.PullsItem
import kotlinx.coroutines.flow.callbackFlow

class PullItemAdapter(private val callback: (String?) -> Unit) : RecyclerView.Adapter<PullItemAdapter.ViewHolder>()  {
    private var list: MutableList<PullsItem> = emptyList<PullsItem>().toMutableList()

    var onLoadFinish: (() -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.pulls_item, parent, false)
        return ViewHolder(view)
    }

    fun updateList(items: MutableList<PullsItem>?) {
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

        viewHolder.apply {
            item.apply {
                pullTitle.text = title
                pullDescription.text = body
                pullUserName.text = user?.login
                pullName.text = user?.login

                Glide.with(viewHolder.itemView)
                    .load(user?.avatarUrl)
                    .centerCrop()
                    .into(pullProfileImage)

                itemView.setOnClickListener {
                    callback.invoke(url)
                }
            }
        }
    }

    private fun getItem(position: Int): PullsItem = list[position]

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val pullTitle: TextView       = itemView.findViewById(R.id.pullTitle)
        val pullDescription: TextView = itemView.findViewById(R.id.pullDescription)
        val pullUserName: TextView    = itemView.findViewById(R.id.pullUserName)
        val pullName: TextView        = itemView.findViewById(R.id.pullName)
        val pullProfileImage: CircleImageView = itemView.findViewById(R.id.pullProfileImage)
    }
}