package com.example.myinstaclone.presentation.all.adapter.`null`.post

//class PostViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
//    private val avatar: ImageView = view.findViewById(R.id.postFotoProfile)
//    private val image: ImageView = view.findViewById(R.id.postImage)
//    private val des = view.findViewById<TextView>(R.id.postDescriptionText)
//    private val userNameS = view.findViewById<TextView>(R.id.postNameUser)
//    private val nameProfileForComment = view.findViewById<TextView>(R.id.postNameProfileForComment)
//    private val imageComment: ImageView = view.findViewById(R.id.postImageComment)
//    val commentChat: ImageView = view.findViewById(R.id.postChatIcon)
//    val likesEmpty : ImageView = view.findViewById(R.id.postLikeIconEmpty)
//    val likes : ImageView = view.findViewById(R.id.postLikeIcon)
//    val likesNumber = view.findViewById<TextView>(R.id.postLikes)
//    private val likest: TextView = view.findViewById(R.id.postLikes)
//    var id = ""
//    var userName = ""
//
//
//    @SuppressLint("SetTextI18n")
//    fun bindPost(posts: PostUi) {
//        userName = posts.postHolderName.toString()
//        id = posts.objectsId.toString()
//        Picasso.get().load(posts.postImage?.imageUrl).into(image)
//        if (posts.avatarName?.imageUrl.isNullOrEmpty()) {
//        } else {
//            Picasso.get().load(posts.avatarName?.imageUrl).into(avatar)
//            Picasso.get().load(posts.avatarName?.imageUrl).into(imageComment)
//        }
//        des.text = posts.description
//        userNameS.text = posts.postHolderName
//        nameProfileForComment.text = posts.postHolderName
//        if (posts.likes == 0) {
//            likest.visibility = View.GONE
//        } else {
//            likest.visibility = View.VISIBLE
//            likest.text = "${posts.likes} likes"
//        }
//        nameProfileForComment.setCaptionText(posts.postHolderName)
//    }
//
//    private fun TextView.setCaptionText(username: String?) {
//        val span = SpannableString(username)
//        span.setSpan(
//            StyleSpan(Typeface.BOLD) ,
//            0 ,
//            span.length ,
//            Spannable.SPAN_EXCLUSIVE_EXCLUSIVE
//        )
//        span.setSpan(object : ClickableSpan() {
//            override fun onClick(item: View) {
//                makeToast("User is clicked" , context)
//            }
//
//            override fun updateDrawState(ds: TextPaint) {}
//        } , 0 , span.length , Spannable.SPAN_EXCLUSIVE_EXCLUSIVE)
//        text = SpannableStringBuilder().append(span)
//        movementMethod = LinkMovementMethod.getInstance()
//
//
//    }
//
//
//
//}



