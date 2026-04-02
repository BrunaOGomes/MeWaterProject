package br.com.heiderlopes.watertrack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import br.com.heiderlopes.watertrack.ui.theme.WaterTrackerTheme
import androidx.lifecycle.viewmodel.compose.viewModel
import br.com.heiderlopes.watertrack.data.datastore.DataStoreWaterRepository
import br.com.heiderlopes.watertrack.domain.repository.WaterRepository
import br.com.heiderlopes.watertrack.ui.screens.WaterScreen
import br.com.heiderlopes.watertrack.ui.screens.waterscreens.WaterViewModel
import br.com.heiderlopes.watertrack.ui.screens.waterscreens.WaterViewModelFactory

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            WaterTrackerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //val viewModel: WaterViewModel = viewModel()
                    //val repository: WaterRepository = InMemoryWaterRepository()
                    val repository: WaterRepository = DataStoreWaterRepository(this)
                    val factory = WaterViewModelFactory(repository)

                    val viewModel: WaterViewModel = viewModel(factory = factory)

                    WaterScreen(
                        waterUiState = viewModel.uiState,
                        onDrink = viewModel::drinkOneCup,
                        onRemove = viewModel :: removeOnCup,
                        onReset = viewModel::reset,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


