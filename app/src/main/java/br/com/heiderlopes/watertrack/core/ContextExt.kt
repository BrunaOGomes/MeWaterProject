package br.com.heiderlopes.watertrack.core

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore

val Context.waterDataStore by preferencesDataStore("water_store")