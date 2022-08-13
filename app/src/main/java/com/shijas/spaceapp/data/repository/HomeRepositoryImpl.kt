package com.shijas.spaceapp.data.repository

import android.app.Application
import com.shijas.spaceapp.data.dto.NasaDto
import com.shijas.spaceapp.data.mapper.toNasaData
import com.shijas.spaceapp.domain.model.NasaData
import com.shijas.spaceapp.domain.repository.HomeRepository
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import javax.inject.Inject

class HomeRepositoryImpl @Inject
constructor(private val application: Application, private val moshi: Moshi) : HomeRepository {

    override fun getNasaData(): List<NasaData> {
        val myJson = application.assets.open(JSON_FILE_NAME).bufferedReader().use { it.readText() }
        val listType = Types.newParameterizedType(List::class.java, NasaDto::class.java)
        val adapter: JsonAdapter<List<NasaDto>> = moshi.adapter(listType)
        val nasaDtos = adapter.fromJson(myJson)
        return  nasaDtos?.map { it.toNasaData() } ?: emptyList()
    }

    companion object{
        const val JSON_FILE_NAME = "data.json"
    }
}