package com.jesse.c25nys.data

import com.jesse.c25nys.data.model.SchoolsResponseItem
import com.jesse.c25nys.domain.model.SchoolsItem
import com.jesse.c25nys.domain.model.toDomain
import javax.inject.Inject

class SchoolsServ @Inject constructor(private val api: SchoolsApi) {

    suspend fun getAllSchools(): List<SchoolsItem> {
       try {
           val call = api.getAllSchools()
           if (call.isSuccessful) {
               return call.body()?.map {
                   it.toDomain()
               } ?: emptyList()
           }
           return emptyList()
       } catch (e: Exception) {
           return emptyList()
       }
    }

}