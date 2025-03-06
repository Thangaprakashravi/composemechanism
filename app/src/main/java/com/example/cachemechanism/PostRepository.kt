package com.example.cachemechanism

import android.content.Context
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class PostRepository(context: Context) {
    private val postDao = PostDatabase.getDatabase(context).postDao()

    fun getPosts(): Flow<List<Post>> = flow {
        try {
            val apiPosts = RetrofitInstance.api.getPosts()
            postDao.clearPosts()
            postDao.insertPosts(apiPosts)
            emit(apiPosts)
        } catch (e: Exception) {
            emit(postDao.getAllPosts())
        }
    }
}
