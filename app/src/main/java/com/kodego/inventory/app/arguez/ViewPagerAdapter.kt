package com.kodego.inventory.app.arguez

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.kodego.inventory.app.arguez.databinding.ItemViewPagerBinding

class ViewPagerAdapter(val images: List<Int>): RecyclerView.Adapter<ViewPagerAdapter.ViewPagerViewHolder>() {

    inner class ViewPagerViewHolder(val binding: ItemViewPagerBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewPagerViewHolder {
        //give look to our views
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ItemViewPagerBinding.inflate(layoutInflater, parent, false)
        return ViewPagerViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewPagerViewHolder, position: Int) {
        val image = images[position]
        //apply is a shortcut to avoid repeated use of binding
        holder.binding.apply {
            imgViewPager.setImageResource(image)
        }
    }

    override fun getItemCount(): Int {
        return images.size

    }


}