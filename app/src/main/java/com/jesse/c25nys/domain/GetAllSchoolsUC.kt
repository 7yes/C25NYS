package com.jesse.c25nys.domain

import com.jesse.c25nys.data.SchoolsRepo
import javax.inject.Inject

class GetAllSchoolsUC @Inject constructor(private val repo:SchoolsRepo ) {
    suspend operator fun invoke() = repo.getAllSchools()
}