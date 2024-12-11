package com.jesse.c25nys.data

import com.jesse.c25nys.data.model.DBNResponseItem
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DBNApi {

    @GET("s3k6-pzi2.json")
    suspend fun getByDBN(@Query("dbn") dbn: String): Response<List<DBNResponseItem>>
}
