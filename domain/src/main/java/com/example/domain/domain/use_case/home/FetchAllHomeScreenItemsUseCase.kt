package com.example.domain.domain.use_case.home

import com.example.domain.domain.models.user_registration.HomeScreenItemDomain
import kotlinx.coroutines.flow.Flow

interface FetchAllHomeScreenItemsUseCase {
    operator fun invoke(): Flow<HomeScreenItemDomain>

}