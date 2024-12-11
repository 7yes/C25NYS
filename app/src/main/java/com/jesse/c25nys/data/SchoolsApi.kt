package com.jesse.c25nys.data

import com.jesse.c25nys.data.model.SchoolsResponseItem
import retrofit2.Response
import retrofit2.http.GET

interface SchoolsApi {

    @GET("f9bf-2cp4.json")
    suspend fun getAllSchools(): Response<List<SchoolsResponseItem>>
}