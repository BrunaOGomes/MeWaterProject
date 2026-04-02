package br.com.heiderlopes.watertrack.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.heiderlopes.watertrack.ui.theme.PrimaryColor
import br.com.heiderlopes.watertrack.ui.theme.PrimaryDisabledColor
import br.com.heiderlopes.watertrack.ui.theme.SecondaryTextColor

@Composable
fun ActionButtons(
    isGoalReached: Boolean,
    onDrink: () -> Unit,
    onRemove: () -> Unit,
    onReset: () -> Unit,

    ) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = onDrink,
            enabled = !isGoalReached,
            modifier = Modifier
                .fillMaxWidth()
                .height(54.dp),
            shape = RoundedCornerShape(14.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = PrimaryColor,
                disabledContainerColor = PrimaryDisabledColor,
                contentColor = Color.White,
                disabledContentColor = Color.White
            ),
            elevation = ButtonDefaults.buttonElevation(6.dp)
        ) {
            Text(
                text = "BEBER 1 COPO (200 ML)",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp
            )
        }
        Spacer(modifier = Modifier.height(8.dp))

        //botoes da aplicação
        Row (

        ) {
            TextButton(onClick = onRemove ) { }
            Text(text = "Remover",
            color = SecondaryTextColor,
                fontWeight = FontWeight.SemiBold
            )
        }
        TextButton(onClick = onReset ) { }
        Text(text = "Reiniciar",
            color = SecondaryTextColor,
            fontWeight = FontWeight.SemiBold
        )
    }
    }
@Preview(showBackground = true)
@Composable
private fun ActionButtonPreview() {
    ActionButtons(true,
    onDrink = {},
    onReset = {},
onRemove ={})
}