package com.example.myinstaclone.presentation.all.adapter.`null`.post


//class PostAdaptor(
//    private val listener: OnItemClickListener
//) : RecyclerView.Adapter<PostViewHolder>() {
//    var post: List<PostUi> = emptyList()
//        set(newValue) {
//            val callback = DiffCallBackPostUi(field , newValue)
//            val diffResult = DiffUtil.calculateDiff(callback)
//            diffResult.dispatchUpdatesTo(this)
//            field = newValue
//            diffResult.dispatchUpdatesTo(this)
//        }
//
//
//    override fun onCreateViewHolder(parent: ViewGroup , viewType: Int): PostViewHolder {
//        return PostViewHolder(
//            LayoutInflater.from(parent.context)
//                .inflate(R.layout.item_home_layout , parent , false)
//        )
//    }
//
//    override fun getItemCount(): Int {
//        return post.count()
//    }
//
//    @SuppressLint("SetTextI18n")
//    override fun onBindViewHolder(holder: PostViewHolder , position: Int) {
//        var count = 1
//        holder.bindPost(post[position])
//        holder.commentChat.setOnClickListener {
//            listener.onItemClick(position , id = holder.id , userName = holder.userName)
//        }
//        holder.likesEmpty.setOnClickListener {
//            count++
//            holder.likesEmpty.hideView()
//            holder.likes.showView()
//            listener.onItemClickLike(position, id =holder.id)
//            holder.likesNumber.text = "$count likes"
//        }
//        holder.likes.setOnClickListener {
//            count--
//            holder.likesEmpty.showView()
//            holder.likes.hideView()
//            listener.onItemClickLike(position, id =holder.id)
//            holder.likesNumber.text = "$count likes"
//        }
//
//    }
//
//    interface OnItemClickListener{
//        fun onItemClick(position: Int , id: String , userName: String)
//        fun onItemClickLike(position: Int, id: String){
//        }
//    }
//
//}



