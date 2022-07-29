package com.example.a14hw.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.a14hw.R
import com.example.a14hw.data.MarsPhotoDto
import com.example.a14hw.databinding.RecyclerMarsphotoItemBinding
import com.example.a14hw.entity.MarsPhoto

class MarsPhotoPagedListAdapter(
    private val onClick: (MarsPhoto) -> Unit
) :
    PagingDataAdapter<MarsPhotoDto, MarsPhotosViewHolder>(DiffUtilCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MarsPhotosViewHolder {
        val binding = RecyclerMarsphotoItemBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return MarsPhotosViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MarsPhotosViewHolder, position: Int) {
        val item = getItem(position)
        val res = holder.itemView.resources
        with(holder.binding) {
            roverName.text = res.getString(R.string.rover_name, item?.rover?.name ?: "")
            cameraName.text = res.getString(R.string.camera_name, item?.camera?.name ?: "")
            solAmount.text = res.getString(R.string.sol_amount, item?.sol ?: 0)
            earthDate.text = res.getString(R.string.earth_date, item?.earthDate ?: "")
            item?.let {
                Glide.with(image.context)
                    .load(it.imgSrc)
                    .into(image)
            }
            fullscreenButton.setOnClickListener {
                item?.let { onClick(it) }
            }
        }
    }

}

class DiffUtilCallback : DiffUtil.ItemCallback<MarsPhotoDto>() {

    override fun areItemsTheSame(oldItem: MarsPhotoDto, newItem: MarsPhotoDto): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(oldItem: MarsPhotoDto, newItem: MarsPhotoDto): Boolean =
        oldItem == newItem
}

class MarsPhotosViewHolder(val binding: RecyclerMarsphotoItemBinding) :
    RecyclerView.ViewHolder(binding.root)