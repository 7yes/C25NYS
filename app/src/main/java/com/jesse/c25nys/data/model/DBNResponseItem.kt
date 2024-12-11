package com.jesse.c25nys.data.model

import com.google.gson.annotations.SerializedName

data class DBNResponseItem(
   @SerializedName("academicopportunities1") val academicopportunities1: String,
   @SerializedName("building_code") val building_code: String,
   @SerializedName("bus") val bus: String,
   @SerializedName("census_tract") val census_tract: String,
   @SerializedName("city") val city: String,
   @SerializedName("code1") val code1: String,
   @SerializedName("community_board") val community_board: String,
   @SerializedName("council_district") val council_district: String,
   @SerializedName("dbn") val dbn: String,
   @SerializedName("directions1") val directions1: String,
   @SerializedName("extracurricular_activities") val extracurricular_activities: String,
   @SerializedName("fax_number") val fax_number: String,
   @SerializedName("finalgrades") val finalgrades: String,
   @SerializedName("grade9geapplicants1") val grade9geapplicants1: String,
   @SerializedName("language_classes") val language_classes: String,
   @SerializedName("latitude") val latitude: String,
   @SerializedName("location") val location: String,
   @SerializedName("longitude") val longitude: String,
   @SerializedName("neighborhood") val neighborhood: String,
   @SerializedName("phone_number") val phone_number: String,
   @SerializedName("primary_address_line_1") val primary_address_line_1: String,
   @SerializedName("school_email") val school_email: String,
   @SerializedName("school_name") val school_name: String,
   @SerializedName("school_sports") val school_sports: String,
   @SerializedName("total_students") val total_students: String,
   @SerializedName("transfer") val transfer: String,
   @SerializedName("website") val website: String,
   @SerializedName("zip") val zip: String)