package br.com.heiderlopes.watertrack.data.memory

import br.com.heiderlopes.watertrack.domain.repository.WaterRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class InMemoryWaterRepository : WaterRepository {

    private val cupsDrunkFlow = MutableStateFlow(0)

    //toda vez que as pessoas verem a mudanca de estado ele pega isso
    override fun getCupsDrunk(): Flow<Int> {
        return cupsDrunkFlow.asStateFlow()
    }

    override suspend fun saveCupsDrunk(value: Int) {
        cupsDrunkFlow.value = value
    }

    override suspend fun clear() {
        cupsDrunkFlow.value = 0
    }


}