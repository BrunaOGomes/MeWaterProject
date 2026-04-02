package br.com.heiderlopes.watertrack.ui.screens.waterscreens

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.heiderlopes.watertrack.domain.repository.WaterRepository
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
// ela faz a comunicacao com a tela atraves dos estados , mostra os valores que estamos manipulando e manipulacao
class WaterViewModel(
    val repository: WaterRepository
) : ViewModel() {

    var uiState by mutableStateOf(WaterUiState())
        private set

    init {
        observeCups()
    }
//cara que vai iniciar a observacao , ele faz com qu
    //pensa no prof falando e a gente pegando as infos se necessario
    private fun observeCups() {
        viewModelScope.launch {
            repository.getCupsDrunk().collectLatest { cups ->
                uiState = uiState.copy(cupsDrunk = cups)
            }
        }
    }

    fun drinkOneCup() {
        if (uiState.cupsDrunk < uiState.goalCups) {
            viewModelScope.launch {
                repository.saveCupsDrunk(uiState.cupsDrunk + 1)
            }
        }
    }

    fun removeOnCup() {
        if (uiState.cupsDrunk > 0) {
            viewModelScope.launch {
                repository.saveCupsDrunk(uiState.cupsDrunk - 1)
            }
        }
    }

    fun reset() {
        viewModelScope.launch {
            repository.clear()
        }
    }

}