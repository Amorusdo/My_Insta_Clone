package com.example.myinstaclone.presentation.screens._home.mapper

import com.example.domain.domain.interfaces.Mapper
import com.example.domain.domain.models.user_post.PostDomain
import com.example.domain.domain.models.user_registration.HomeScreenItemDomain
import com.example.domain.domain.models.user_registration.UserSignInDomain
import com.example.myinstaclone.presentation.adaptor.Item
import com.example.myinstaclone.presentation.adaptor.lisener.UsersItemClickListener
import com.example.myinstaclone.presentation.models.user_image.ImageUi
import com.example.myinstaclone.presentation.models.user_post.PostUi
import com.example.myinstaclone.presentation.models.user_registration.HomeScreenItemUi
import com.example.myinstaclone.presentation.models.user_registration.UserSignInUi
import com.example.myinstaclone.presentation.screens._home.items.HomeScreenPostBlockItem
import com.example.myinstaclone.presentation.screens._home.items.HorizontalItemAdapterModel
import com.example.myinstaclone.presentation.screens._home.items.PostItemAdapterModel
import com.example.myinstaclone.presentation.screens._home.items.UserBlockItem
import com.example.myinstaclone.presentation.screens._home.listener.ItemClickListener
import javax.inject.Inject

class ItemHomeScreenMapperImpl @Inject constructor(
    private val postDomainToPostUiMapper: Mapper<PostDomain , PostUi> ,
    private val userSignInToUiMapper: Mapper<UserSignInDomain , UserSignInUi>
) : ItemFilteredHomeScreenMapper {

    override fun map(
        items: HomeScreenItemDomain ,
        searchQuery: String ,
        postItemClickListener: ItemClickListener ,
        usersItemClickListener: UsersItemClickListener
    ): Triple<List<Item> , List<Item> , List<Item>> {

        val filteredPostsList = items.posts.map(postDomainToPostUiMapper::map)
            .map {
                PostItemAdapterModel(
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
                    listener = postItemClickListener
                )
            }

        val filteredUserList = items.users.map(userSignInToUiMapper::map)
            .map {
                HorizontalItemAdapterModel(
                    users = UserSignInUi(
                        id = it.id ,
                        userFullName = it.userFullName ,
                        userEmail = it.userEmail ,
                        userAge = it.userAge ,
                        userGender = it.userGender ,
                        phoneNumber = it.phoneNumber ,
                        userBio = it.userBio ,
                        userFollower = it.userFollower ,
                        userFollowing = it.userFollowing ,
                        userCountPosts = it.userCountPosts ,
                        userAvatar = ImageUi(
                            type = it.userAvatar.type ,
                            imageUrl = it.userAvatar.imageUrl
                        ) ,
                        userId = it.userId
                    ) ,
                    listener = usersItemClickListener
                )
            }

        val allItems = mutableListOf<Item>()

        val postItemForPager = HomeScreenPostBlockItem(filteredPostsList)
        if (postItemForPager.items.isNotEmpty()) allItems.addAll(
            listOf(postItemForPager)
        )
        val userItem = UserBlockItem(filteredUserList)
        if (userItem.items.isNotEmpty()) allItems.addAll(
            listOf(userItem)
        )
        return Triple(allItems , emptyList() , emptyList())
    }

}


