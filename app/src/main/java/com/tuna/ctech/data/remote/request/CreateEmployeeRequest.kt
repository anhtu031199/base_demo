package com.tuna.nothingapp.data.remote.request

data class CreateEmployeeRequest(
    var fullName: String,
    var birthday: String,
    var gender: Boolean,
    var email: String,
    var phoneNumber: String,
    var salary: Double,
    var department: Int,
    var biography: String,
    var image: String
)

