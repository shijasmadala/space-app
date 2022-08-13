package com.shijas.spaceapp.data.mapper

import com.shijas.spaceapp.data.dto.NasaDto
import com.shijas.spaceapp.domain.model.NasaData

fun NasaDto.toNasaData(): NasaData {
    return NasaData(
        date = date ?: "",
        explanation = explanation ?: "",
        hduUrl = hdurl ?: "",
        title = title ?: "",
        url = url ?: ""
    )
}