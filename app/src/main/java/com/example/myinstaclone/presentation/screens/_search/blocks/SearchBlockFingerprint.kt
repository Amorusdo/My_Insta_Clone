package com.example.myinstaclone.presentation.screens._search.blocks

import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myinstaclone.presentation.screens._search.items.SearchScreenBlockItem
import com.example.myinstaclone.R
import com.example.myinstaclone.databinding.BlockScreenSearchRvBinding
import com.example.myinstaclone.presentation.adaptor.BaseViewHolder
import com.example.myinstaclone.presentation.adaptor.FingerprintAdapter
import com.example.myinstaclone.presentation.adaptor.Item
import com.example.myinstaclone.presentation.adaptor.ItemFingerprint


class SearchBlockFingerprint(
    private val fingerprintsList: List<ItemFingerprint<* , *>> ,
    private val viewPool: RecyclerView.RecycledViewPool = RecyclerView.RecycledViewPool() ,
) : ItemFingerprint<BlockScreenSearchRvBinding , SearchScreenBlockItem> {

    override fun isRelativeItem(item: Item) = item is SearchScreenBlockItem

    override fun getLayoutId() =
        R.layout.block_screen_search_rv

    override fun getViewHolder(layoutInflater: LayoutInflater , parent: ViewGroup): BaseViewHolder<BlockScreenSearchRvBinding , SearchScreenBlockItem> {
        val binding = BlockScreenSearchRvBinding.inflate(layoutInflater)
        val newLayoutParams = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT)
//       newLayoutParams.setMargins(4.toDp, 8.toDp, 8.toDp, 16.toDp)
        binding.root.layoutParams = newLayoutParams
        return MainScreenCollectionsBlockViewHolder(binding, fingerprintsList, viewPool)
    }

    private val diffUtil = object : DiffUtil.ItemCallback<SearchScreenBlockItem>() {

        override fun areItemsTheSame(
            oldItem: SearchScreenBlockItem ,
            newItem: SearchScreenBlockItem ,
        ) = oldItem == newItem


        override fun areContentsTheSame(
            oldItem: SearchScreenBlockItem ,
            newItem: SearchScreenBlockItem ,
        ) = oldItem == newItem
    }

    override fun getDiffUtil() = diffUtil
}

class MainScreenCollectionsBlockViewHolder(
    binding: BlockScreenSearchRvBinding ,
    fingerprints: List<ItemFingerprint<* , *>> ,
    viewPool: RecyclerView.RecycledViewPool ,
) : BaseViewHolder<BlockScreenSearchRvBinding , SearchScreenBlockItem>(binding) {

    private val fingerprintAdapter = FingerprintAdapter(fingerprints)

    init {
        with(binding.searchVerticalRv) {
            adapter = fingerprintAdapter
            setRecycledViewPool(viewPool)
        }
    }

    override fun onBind(item: SearchScreenBlockItem) {
        super.onBind(item)
        setupViews()
    }

    private fun setupViews() = with(binding) {
        fingerprintAdapter.submitList(item.items.shuffled())
        searchVerticalRv.apply {
//            startSlideInLeftAnim()
            restoreState(item.state)
        }
    }

    override fun onViewDetached() {
        binding.searchVerticalRv.onFlingListener = null

        item.state = binding.searchVerticalRv.layoutManager?.onSaveInstanceState() ?: return
    }

    private fun RecyclerView.restoreState(parcelable: Parcelable?) {
        if (parcelable == null) return
        layoutManager?.onRestoreInstanceState(parcelable)

    }
}