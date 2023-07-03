package com.example.myinstaclone.presentation.screens._search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.example.myinstaclone.R
import com.example.myinstaclone.databinding.FragmentSearchBinding
import com.example.myinstaclone.presentation.adaptor.FingerprintAdapter
import com.example.myinstaclone.presentation.adaptor.Item
import com.example.myinstaclone.presentation.extantions.launchWhenViewStarted
import com.example.myinstaclone.presentation.extantions.setupTextSize
import com.example.myinstaclone.presentation.screens._search.blocks.SearchBlockFingerprint
import com.example.myinstaclone.presentation.screens._search.fingerprints.SearchFingerprint
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.filterNotNull

@AndroidEntryPoint
class SearchFragment : Fragment() , SearchView.OnQueryTextListener {
    private val binding by lazy { FragmentSearchBinding.inflate(layoutInflater) }
    private val viewModelSearch by viewModels<ViewModelSearch>()

    private val genericAdapter = FingerprintAdapter(
        listOf(
            SearchBlockFingerprint(
                listOf(SearchFingerprint()) ,
                RecyclerView.RecycledViewPool() ,
            )
        )
    )

    override fun onCreateView(
        inflater: LayoutInflater , container: ViewGroup? ,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View , savedInstanceState: Bundle?) {
        super.onViewCreated(view , savedInstanceState)
        observeData()
        binding.rvMyImages.adapter = genericAdapter

    }

    private fun observeData() = with(viewModelSearch) {
        launchWhenViewStarted {
            allFilteredItemsFlow.filterNotNull().observe(::populateModels)
            binding.searchView.setupTextSize()
            binding.searchView.setOnQueryTextListener(this@SearchFragment)
            val hint = getString(R.string.search)
            binding.searchView.queryHint = hint
        }
    }

    private fun populateModels(items: Triple<List<Item> , List<Item> , List<Item>>) {
        genericAdapter.submitList(items.first)

    }

    override fun onQueryTextSubmit(searchString: String?): Boolean {
        if (searchString != null) viewModelSearch.updateSearchQuery(searchString = searchString)
        return false
    }

    override fun onQueryTextChange(searchString: String?): Boolean {
        if (searchString != null) viewModelSearch.updateSearchQuery(searchString = searchString)
        return false
    }
}