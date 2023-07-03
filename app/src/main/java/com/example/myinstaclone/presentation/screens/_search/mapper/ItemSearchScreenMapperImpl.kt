package com.example.myinstaclone.presentation.screens._search.mapper


import com.example.domain.domain.interfaces.Mapper
import com.example.domain.domain.models.search.SearchPostsItemDomain
import com.example.domain.domain.models.user_post.PostDomain
import com.example.myinstaclone.presentation.adaptor.Item
import com.example.myinstaclone.presentation.models.user_image.ImageUi
import com.example.myinstaclone.presentation.models.user_post.PostUi
import com.example.myinstaclone.presentation.screens._search.items.PostSearchItemAdapterModel
import com.example.myinstaclone.presentation.screens._search.items.SearchScreenBlockItem
import com.example.myinstaclone.presentation.screens._search.listener.ItemClickListenerSearch
import javax.inject.Inject

class ItemSearchScreenMapperImpl @Inject constructor(
    private val postDomainToPostUiMapper: Mapper<PostDomain , PostUi> ,
) : ItemFilteredSearchScreenMapper {

    override fun map(
        items: SearchPostsItemDomain ,
        searchQuery: String ,
        postSearchItemClickListener: ItemClickListenerSearch ,
    ): Triple<List<Item> , List<Item> , List<Item>> {

        val filteredPostsSearchList = items.posts.map(postDomainToPostUiMapper::map)
            .filter { applyFilterForAllNasheeds(post = it , searchQuery = searchQuery) }
            .map {
                PostSearchItemAdapterModel(
                    posts = PostUi(
                        objectsId = it.objectsId ,
                        postImage = ImageUi(
                            imageUrl = it.postImage?.imageUrl ,
                            imageName = it.postImage?.imageName
                        ) ,
                        description = it.description ,
                        postId = it.postId ,
                        avatarName = ImageUi(
                            imageUrl = it.avatarName?.imageUrl ,
                            imageName = it.avatarName?.imageName
                        ) ,
                        userImagePost = it.userImagePost ,
                        postHolderName = it.postHolderName ,
                        likes = it.likes ,
                    ) ,
                    listener = postSearchItemClickListener
                )
            }


        val allItems = mutableListOf<Item>()

        val postItemForPager = SearchScreenBlockItem(filteredPostsSearchList)
        if (postItemForPager.items.isNotEmpty()) allItems.addAll(
            listOf(postItemForPager)
        )

        return Triple(allItems , emptyList() , emptyList())
    }

    private fun applyFilterForAllNasheeds(post: PostUi , searchQuery: String) =
        if (searchQuery.isEmpty()) post.description != String()
        else post.description.contains(searchQuery , ignoreCase = true)
}


