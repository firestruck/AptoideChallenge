package com.dmanlancers.aptoide.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.dmanlancers.aptoide.R
import com.dmanlancers.aptoide.databinding.TopRecyclerItemBinding

import com.dmanlancers.aptoide.domain.model.ListValues


internal class TopRecyclerAdapter(
    private var appsList: List<ListValues>,
    private var clickListener: ListAction

) : RecyclerView.Adapter<TopRecyclerAdapter.ViewHolder>() {


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = TopRecyclerItemBinding.inflate(layoutInflater, parent, false)

        return ViewHolder(binding, clickListener)
    }


    override fun getItemCount(): Int {
        return appsList.size
    }


    override fun onBindViewHolder(
        holder: ViewHolder,
        position: Int

    ) {

        holder.onBind(appsList, position)

    }


    inner class ViewHolder(
        var binding: TopRecyclerItemBinding,
        var clickListener: ListAction
    ) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(appsList: List<ListValues>, position: Int) {
            val name = appsList[position].name
            val ratingValue = if (appsList[position].rating.toFloat() == 0F) {
                "--"
            } else {
                appsList[position].rating
            }
            val image = appsList[position].graphic
            binding.txtAppName.text = name
            binding.txtRatingValue.text = ratingValue



            Glide.with(itemView.context)
                .load(image)
                .centerCrop()
                .error(R.drawable.ic_broken_image)
                .transition(DrawableTransitionOptions.withCrossFade())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(binding.topIvRecycle)

            itemView.setOnClickListener {
                clickListener.onClick(position)
            }

        }
    }


}