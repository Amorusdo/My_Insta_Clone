package com.example.myinstaclone.presentation.screens._home.blocks

import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myinstaclone.R
import com.example.myinstaclone.databinding.BlockScreenHomeRvBinding
import com.example.myinstaclone.presentation.adaptor.BaseViewHolder
import com.example.myinstaclone.presentation.adaptor.FingerprintAdapter
import com.example.myinstaclone.presentation.adaptor.Item
import com.example.myinstaclone.presentation.adaptor.ItemFingerprint
import com.example.myinstaclone.presentation.screens._home.items.HomeScreenPostBlockItem


class PostBlockFingerprint(
    private val fingerprintsList: List<ItemFingerprint<* , *>> ,
    private val viewPool: RecyclerView.RecycledViewPool = RecyclerView.RecycledViewPool() ,
) : ItemFingerprint<BlockScreenHomeRvBinding , HomeScreenPostBlockItem> {

    override fun isRelativeItem(item: Item) = item is HomeScreenPostBlockItem

    override fun getLayoutId() = R.layout.block_screen_home_rv

    override fun getViewHolder(
        layoutInflater: LayoutInflater ,
        parent: ViewGroup ,
    ): BaseViewHolder<BlockScreenHomeRvBinding , HomeScreenPostBlockItem> {
        val binding = BlockScreenHomeRvBinding.inflate(layoutInflater)
        val newLayoutParams = FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT ,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
//        newLayoutParams.setMargins(4.toDp, 8.toDp, 8.toDp, 16.toDp)
        binding.root.layoutParams = newLayoutParams
        return MainScreenCollectionsBlockViewHolder(binding , fingerprintsList , viewPool)
    }

    private val diffUtil = object : DiffUtil.ItemCallback<HomeScreenPostBlockItem>() {

        override fun areItemsTheSame(
            oldItem: HomeScreenPostBlockItem ,
            newItem: HomeScreenPostBlockItem ,
        ) = oldItem == newItem


        override fun areContentsTheSame(
            oldItem: HomeScreenPostBlockItem ,
            newItem: HomeScreenPostBlockItem ,
        ) = oldItem == newItem
    }

    override fun getDiffUtil() = diffUtil
}

class MainScreenCollectionsBlockViewHolder(
    binding: BlockScreenHomeRvBinding ,
    fingerprints: List<ItemFingerprint<* , *>> ,
    viewPool: RecyclerView.RecycledViewPool ,
) : BaseViewHolder<BlockScreenHomeRvBinding , HomeScreenPostBlockItem>(binding) {

    private val fingerprintAdapter = FingerprintAdapter(fingerprints)

    init {
        with(binding.verticalRecyclerView) {
            adapter = fingerprintAdapter
            setRecycledViewPool(viewPool)
        }
    }

    override fun onBind(item: HomeScreenPostBlockItem) {
        super.onBind(item)
        setupViews()
    }

    private fun setupViews() = with(binding) {
        fingerprintAdapter.submitList(item.items.reversed())
        verticalRecyclerView.apply {
//            startSlideInLeftAnim()
            restoreState(item.state)
        }
    }

    override fun onViewDetached() {
        binding.verticalRecyclerView.onFlingListener = null
        item.state = binding.verticalRecyclerView.layoutManager?.onSaveInstanceState() ?: return
    }

    private fun RecyclerView.restoreState(parcelable: Parcelable?) {
        if (parcelable == null) return
        layoutManager?.onRestoreInstanceState(parcelable)
    }
}