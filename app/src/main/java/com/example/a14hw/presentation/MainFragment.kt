package com.example.a14hw.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.paging.LoadState
import androidx.paging.PagingData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a14hw.data.MarsPhotoDto
import com.example.a14hw.databinding.MainFragmentBinding
import com.example.a14hw.entity.MarsPhoto
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class MainFragment : Fragment() {

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by viewModels()

    private val marsPhotoPagedListAdapter = MarsPhotoPagedListAdapter { onItemClick(it) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.marsPhotoRecyclerView.layoutManager = LinearLayoutManager(
            requireContext(),
            LinearLayoutManager.VERTICAL,
            false
        )

        binding.marsPhotoRecyclerView.adapter =
            marsPhotoPagedListAdapter.withLoadStateFooter(MarsPhotosLoadStateAdapter())

        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.fetchMarsPhotosFlow().collect {
                marsPhotoPagedListAdapter.submitData(it as PagingData<MarsPhotoDto>)
            }
        }

        binding.swipeRefresher.setOnRefreshListener {
            marsPhotoPagedListAdapter.refresh()
        }

        marsPhotoPagedListAdapter.loadStateFlow.onEach {
            binding.swipeRefresher.isRefreshing = it.refresh == LoadState.Loading
        }.launchIn(lifecycleScope)
    }

    private fun onItemClick(item: MarsPhoto) {
        val extras = FragmentNavigatorExtras(

        )
        val action = MainFragmentDirections.actionMainFragmentToMarsPhotoItemFragment(item.imgSrc)
        Navigation.findNavController(binding.root).navigate(action)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}