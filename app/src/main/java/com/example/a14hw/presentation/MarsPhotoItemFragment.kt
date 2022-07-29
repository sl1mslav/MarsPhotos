package com.example.a14hw.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.a14hw.databinding.FragmentMarsPhotoItemBinding

class MarsPhotoItemFragment : Fragment() {

    private val args: MarsPhotoItemFragmentArgs by navArgs()

    private var _binding: FragmentMarsPhotoItemBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMarsPhotoItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Glide.with(binding.fullscreenImage.context)
            .load(args.recyclerItemPhotoUrl).into(binding.fullscreenImage)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}