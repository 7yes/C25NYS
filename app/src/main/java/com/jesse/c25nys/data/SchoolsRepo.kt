package com.jesse.c25nys.data

import com.jesse.c25nys.domain.model.DbnItem
import com.jesse.c25nys.domain.model.SchoolsItem
import javax.inject.Inject

class SchoolsRepo @Inject constructor(private val  schoolsService: SchoolsServ, private val dbnServ: DbnService) {

    suspend fun getAllSchools(): List<SchoolsItem> {
        return schoolsService.getAllSchools()
    }

    suspend fun getByDBN(dnb: String): DbnItem? {
        return dbnServ.getByDBN(dnb)
    }
}