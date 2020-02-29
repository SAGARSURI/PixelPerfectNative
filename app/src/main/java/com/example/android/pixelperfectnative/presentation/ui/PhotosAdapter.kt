package com.example.android.pixelperfectnative.presentation.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.android.pixelperfectnative.databinding.PhotoItemBinding
import com.example.android.pixelperfectnative.framework.data.Photo
import com.example.android.pixelperfectnative.presentation.utils.load

class PhotosAdapter(private val photosList: MutableList<Photo> = mutableListOf()) :
    RecyclerView.Adapter<PhotosAdapter.PhotosViewHolder>() {

    var itemAction: ((String) -> Unit)? = null

    fun updatePhotoList(updateList: List<Photo>) {
        photosList.clear()
        photosList.addAll(updateList)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotosViewHolder {
        val binding = PhotoItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotosViewHolder(binding)
    }

    override fun getItemCount(): Int = photosList.size

    override fun onBindViewHolder(holder: PhotosViewHolder, position: Int) {
        holder.bind(photosList[position])
    }

    inner class PhotosViewHolder(private val binding: PhotoItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        init {
            binding.imageShare.setOnClickListener {
                itemAction?.invoke(photosList[adapterPosition].profileUrl)
            }
        }
        fun bind(photo: Photo) {
            binding.image.load(photo.photoUrl)
            binding.textUserName.text = photo.authorName
            binding.imageProfile.load(photo.profileUrl, round = true)
        }
    }
}
