package com.jesse.c25nys.domain.model

import com.jesse.c25nys.data.model.DBNResponseItem

data class DbnItem (
    val dbn:String,
    val name:String = "",
    val location:String? = "",
    val phone_number:String? = "",
    val school_sports:String? = "",
    val city:String? = "",
    val website:String? = "",
    val email:String? = "",
    val total_students:String? = "",
    val zip:String? = ""
)

fun DBNResponseItem.toDomain() = DbnItem(
    dbn = dbn,
    name = school_name,
    location = location,
    phone_number = phone_number,
    school_sports = school_sports,
    city = city,
    website = website,
    email = school_email,
    total_students = total_students,
    zip = zip
)