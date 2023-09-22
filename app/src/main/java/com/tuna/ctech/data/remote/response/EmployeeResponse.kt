package com.tuna.ctech.data.remote.response

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import java.io.Serializable
import java.util.Date

@Entity(tableName = "employee")
data class EmployeeResponse(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,

    @SerializedName("fullname") val fullname: String,
    @SerializedName("birthday") val birthday: Date,
    @SerializedName("gender") val gender: Boolean,
    @SerializedName("email") val email: String,
    @SerializedName("phone_number") val phoneNumber: String? = null,
    @SerializedName("salary") val salary: Long,
    @SerializedName("department") val department: Int,
    @SerializedName("image") val image: String? = null,
    @SerializedName("biography") val biography: String? = null,
    @SerializedName("create_date") val createDate: Date,
    @SerializedName("modified_date") val modifiedDate: Date,
): Serializable
