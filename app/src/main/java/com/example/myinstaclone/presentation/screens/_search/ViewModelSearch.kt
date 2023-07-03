package com.example.myinstaclone.presentation.screens._search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.domain.models.search.SearchPostsItemDomain
import com.example.domain.domain.use_case.search.FetchSearchScreenItemUseCase
import com.example.myinstaclone.presentation.screens._search.listener.ItemClickListenerSearch
import com.example.myinstaclone.presentation.screens._search.mapper.ItemFilteredSearchScreenMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

@HiltViewModel
class ViewModelSearch @Inject constructor(
    private val filteredSearchScreenMapper: ItemFilteredSearchScreenMapper ,
    fetchSearchScreenItemUseCase: FetchSearchScreenItemUseCase ,
) : ViewModel() , ItemClickListenerSearch {

    private val searchStringFlow = MutableStateFlow(String())

    val allFilteredItemsFlow =
        fetchSearchScreenItemUseCase()
        .combine(searchStringFlow.debounce(SEARCH_DEBOUNCE))
        { items, search -> mapToAdapterModel(items, search) }
            .onStart {}
            .flowOn(Dispatchers.Default)
            .catch { exception: Throwable -> handleError(exception) }
            .stateIn(viewModelScope , SharingStarted.Lazily , null)


    private fun mapToAdapterModel(items: SearchPostsItemDomain, searchString:String) =
        filteredSearchScreenMapper.map(
            items = items ,
            searchQuery = searchString ,
            postSearchItemClickListener = this,
        )

    fun updateSearchQuery(searchString: String) = searchStringFlow.tryEmit(searchString)


    private fun handleError(exception: Throwable) {
//        emitToErrorMessageFlow(resourceProvider.fetchIdErrorMessage(exception))
    }

    companion object {
        const val SEARCH_DEBOUNCE = 300L
    }

    override fun onClick() {

    }
}