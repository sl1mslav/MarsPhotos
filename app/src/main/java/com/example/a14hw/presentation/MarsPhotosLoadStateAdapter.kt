package com.example.a14hw.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.paging.LoadStateAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.a14hw.databinding.BottomLoadStateBinding

class MarsPhotosLoadStateAdapter : LoadStateAdapter<MarsPhotoLoadStateViewHolder>() {

    override fun onBindViewHolder(holder: MarsPhotoLoadStateViewHolder, loadState: LoadState) = Unit

    override fun onCreateViewHolder(
        parent: ViewGroup,
        loadState: LoadState
    ): MarsPhotoLoadStateViewHolder {
        val binding =
            BottomLoadStateBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MarsPhotoLoadStateViewHolder(binding)
    }
}

class MarsPhotoLoadStateViewHolder(binding: BottomLoadStateBinding) :
    RecyclerView.ViewHolder(binding.root)