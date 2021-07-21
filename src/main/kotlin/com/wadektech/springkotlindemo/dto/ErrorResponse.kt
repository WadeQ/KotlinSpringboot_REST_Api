package com.wadektech.springkotlindemo.dto

import java.time.LocalDateTime

data class ErrorResponse(
    val error : String = "Bad request",
    val message : String,
    val date : LocalDateTime = LocalDateTime.now()
) {
}