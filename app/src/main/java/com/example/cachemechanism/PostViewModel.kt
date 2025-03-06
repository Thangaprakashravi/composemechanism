package com.example.cachemechanism

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class PostViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = PostRepository(application)

    private val _posts = MutableStateFlow<List<Post>>(emptyList())
    val posts = _posts.asStateFlow()

    fun loadPosts() {
        viewModelScope.launch {
            repository.getPosts().collect { fetchedPosts ->
                _posts.value = fetchedPosts
            }
        }
    }
}
