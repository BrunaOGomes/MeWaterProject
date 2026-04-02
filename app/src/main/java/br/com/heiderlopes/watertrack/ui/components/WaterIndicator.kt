package br.com.heiderlopes.watertrack.ui.components

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.lerp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.heiderlopes.watertrack.ui.theme.CircleBorderColor
import br.com.heiderlopes.watertrack.ui.theme.PrimaryColor
import br.com.heiderlopes.watertrack.ui.theme.SecondaryTextColor
import br.com.heiderlopes.watertrack.ui.theme.WaterFillColor
import br.com.heiderlopes.watertrack.ui.theme.WaterLightColor


@Composable
fun WaterIndicator(
    cupsDrunk: Int,
    goalsCup: Int,
    progress: Float
) {

    val fillColor by animateColorAsState(
        targetValue = lerp(

            start = WaterLightColor,
            stop = WaterFillColor,
            fraction = progress
        ),
        label = "fillColor"
    )
    Box(
        modifier = Modifier.size(190.dp),
        contentAlignment = Alignment.Center
    ) {
        // Borda externa
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clip(CircleShape)
                .background(CircleBorderColor)
        )
        // Área interna do círculo
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(6.dp)
                .clip(CircleShape)
                .background(Color.White)
        ) {
            // Água subindo
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(progress)
                    .align(Alignment.BottomCenter)
                    .background(fillColor)
            )
        }

        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Row {
                Text(
                    "$cupsDrunk",
                    fontSize = 48.sp,
                    fontWeight = FontWeight.Bold,
                    color = PrimaryColor,
                    modifier = Modifier.alignByBaseline()
                )
                Text(
                    "/$goalsCup",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = SecondaryTextColor,
                    modifier = Modifier.alignByBaseline()
                )
            }
            Text(
                text = if (cupsDrunk == 1) "COPO" else "COPOS",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = SecondaryTextColor
            )
        }

    }
}
