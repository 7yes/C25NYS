package com.jesse.c25nys.data

import com.jesse.c25nys.domain.model.DbnItem
import com.jesse.c25nys.domain.model.toDomain
import javax.inject.Inject

class DbnService @Inject constructor(private val api : DBNApi) {
    suspend fun getByDBN(dbn: String): DbnItem? {
     return   try {
            val call = api.getByDBN(dbn)
            if (call.isSuccessful) {
                call.body()?.get(0)?.toDomain()
            } else {
                throw Exception()
            }
        } catch (e: Exception) {
            throw e
        }
    }
}