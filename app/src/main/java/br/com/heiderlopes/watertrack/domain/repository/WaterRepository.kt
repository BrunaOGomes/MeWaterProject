package br.com.heiderlopes.watertrack.domain.repository

import kotlinx.coroutines.flow.Flow

interface WaterRepository {

    fun getCupsDrunk(): Flow<Int>

    suspend fun saveCupsDrunk(value: Int)

    suspend fun clear()

}