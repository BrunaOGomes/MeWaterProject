package br.com.heiderlopes.watertrack.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.heiderlopes.watertrack.ui.screens.waterscreens.WaterUiState
import br.com.heiderlopes.watertrack.ui.components.ActionButtons
import br.com.heiderlopes.watertrack.ui.components.WaterIndicator
import br.com.heiderlopes.watertrack.ui.theme.BackgroundColor
import br.com.heiderlopes.watertrack.ui.theme.PrimaryColor
import br.com.heiderlopes.watertrack.ui.theme.SecondaryTextColor


@Composable
fun WaterScreen(
    waterUiState: WaterUiState,
    onDrink: () -> Unit,
    onRemove:() -> Unit,
    onReset:() ->Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(BackgroundColor)
            .padding(horizontal = 24.dp, vertical = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Beba Água",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = PrimaryColor
        )
        Text(
            text = "HIDRATAÇÃO DIÁRIA",
            fontSize = 11.sp,
            fontWeight = FontWeight.Bold,
            color = SecondaryTextColor
        )
        Spacer(modifier = Modifier.weight(1f))
        WaterIndicator(waterUiState.cupsDrunk, waterUiState.goalCups, waterUiState.progress)
        Spacer(modifier = Modifier.weight(1f))
        ActionButtons(
            waterUiState.isGoalReached,
            onDrink = onDrink,
            onRemove = onRemove,
            onReset = onReset
        )
    }
}