package com.example.myinstaclone.presentation.screens._home.blocks

import android.os.Parcelable
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myinstaclone.R
import com.example.myinstaclone.databinding.BlockScreenUserRvBinding
import com.example.myinstaclone.presentation.adaptor.BaseViewHolder
import com.example.myinstaclone.presentation.adaptor.FingerprintAdapter
import com.example.myinstaclone.presentation.adaptor.Item
import com.example.myinstaclone.presentation.adaptor.ItemFingerprint
import com.example.myinstaclone.presentation.screens._home.items.UserBlockItem

class UserBlockFingerprint(
    private val fingerprintsList: List<ItemFingerprint<* , *>> ,
    private val viewPool: RecyclerView.RecycledViewPool = RecyclerView.RecycledViewPool() ,
) : ItemFingerprint<BlockScreenUserRvBinding , UserBlockItem> {

    override fun isRelativeItem(item: Item) = item is UserBlockItem

    override fun getLayoutId() = R.layout.block_screen_user_rv

    override fun getViewHolder(
        layoutInflater: LayoutInflater ,
        parent: ViewGroup ,
    ): BaseViewHolder<BlockScreenUserRvBinding , UserBlockItem> {
        val binding = BlockScreenUserRvBinding.inflate(layoutInflater)
        val newLayoutParams = FrameLayout.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT ,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )
//        newLayoutParams.setMargins(4.toDp, 8.toDp, 8.toDp, 16.toDp)
        binding.root.layoutParams = newLayoutParams
        return MainScreennCollectionsBlockViewHolder(binding , fingerprintsList , viewPool)
    }


    private val diffUtil = object : DiffUtil.ItemCallback<UserBlockItem>() {

        override fun areItemsTheSame(
            oldItem: UserBlockItem ,
            newItem: UserBlockItem ,
        ) = oldItem == newItem


        override fun areContentsTheSame(
            oldItem: UserBlockItem ,
            newItem: UserBlockItem ,
        ) = oldItem == newItem

    }

    override fun getDiffUtil() = diffUtil

}

class MainScreennCollectionsBlockViewHolder(
    binding: BlockScreenUserRvBinding ,
    fingerprints: List<ItemFingerprint<* , *>> ,
    viewPool: RecyclerView.RecycledViewPool ,
) : BaseViewHolder<BlockScreenUserRvBinding , UserBlockItem>(binding) {

    private val fingerprintAdapter = FingerprintAdapter(fingerprints)

    init {
        with(binding.verticalRecyclerView) {
            adapter = fingerprintAdapter
            setRecycledViewPool(viewPool)
        }
    }

    override fun onBind(item: UserBlockItem) {
        super.onBind(item)
        setupViews()
    }

    private fun setupViews() = with(binding) {
        fingerprintAdapter.submitList(item.items)
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