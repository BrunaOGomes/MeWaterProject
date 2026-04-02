package br.com.heiderlopes.watertrack.data.datastore

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import br.com.heiderlopes.watertrack.domain.repository.WaterRepository
import br.com.heiderlopes.watertrack.core.waterDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataStoreWaterRepository(
    private val context:Context
) : WaterRepository {
    companion object{
        //isso é tipo a classe global do java
        private val CUPS_DRUNK_KEY = intPreferencesKey("cups_drunk")
    }

    override fun getCupsDrunk(): Flow<Int> {
        return context.waterDataStore.data.map{ data ->
            data[CUPS_DRUNK_KEY] ?: 0
        }
    }

    override suspend fun saveCupsDrunk(value: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun clear() {
        context.waterDataStore.edit { data ->
            data.remove(CUPS_DRUNK_KEY)
        }
    }
}