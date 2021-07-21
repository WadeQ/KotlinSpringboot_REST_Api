package com.wadektech.springkotlindemo.utils

import com.wadektech.springkotlindemo.dto.ErrorResponse
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import java.lang.IllegalStateException

@ControllerAdvice
class ErrorLogger {

    fun handleIllegalStateException(e: IllegalStateException) : ResponseEntity<ErrorResponse>{
        return ResponseEntity
            .badRequest()
            .body(ErrorResponse(message = e.localizedMessage))
    }
}