package com.jesse.c25nys.data

import com.jesse.c25nys.domain.model.SchoolsItem
import javax.inject.Inject

class SchoolsRepo @Inject constructor(private val  schoolsService: SchoolsServ) {

    suspend fun getAllSchools(): List<SchoolsItem> {
        return schoolsService.getAllSchools()
    }
}