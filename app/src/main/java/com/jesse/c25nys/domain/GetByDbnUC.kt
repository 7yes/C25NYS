package com.jesse.c25nys.domain

import com.jesse.c25nys.data.SchoolsRepo
import javax.inject.Inject

class GetByDbnUC @Inject constructor(private val repo: SchoolsRepo) {

    suspend operator fun invoke(dbn: String) = repo.getByDBN(dbn)
}