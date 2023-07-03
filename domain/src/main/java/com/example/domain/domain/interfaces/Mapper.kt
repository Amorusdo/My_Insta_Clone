package com.example.domain.domain.interfaces

interface     Mapper <From,To> {
    fun map(from:From):To
}