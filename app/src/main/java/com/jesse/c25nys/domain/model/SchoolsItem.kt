package com.jesse.c25nys.domain.model

import com.google.gson.annotations.SerializedName
import com.jesse.c25nys.data.model.SchoolsResponseItem

data class SchoolsItem(
    val dbn:String,
    val name:String,
    val satWritingAvgScore:String?,
    val satMathAvgScore:String?,
    val satCriticalReadingAvgScore:String?,
    val numOfSatTestTakers:String?
)

fun SchoolsResponseItem.toDomain() = SchoolsItem(
    dbn = dbn,
    name = school_name,
    satWritingAvgScore = sat_writing_avg_score,
    satMathAvgScore = sat_math_avg_score,
    satCriticalReadingAvgScore = sat_critical_reading_avg_score,
    numOfSatTestTakers = num_of_sat_test_takers
)
