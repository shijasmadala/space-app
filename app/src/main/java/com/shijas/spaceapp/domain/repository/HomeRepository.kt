package com.shijas.spaceapp.domain.repository

import com.shijas.spaceapp.domain.model.NasaData


interface HomeRepository {

    fun getNasaData() : List<NasaData>
}