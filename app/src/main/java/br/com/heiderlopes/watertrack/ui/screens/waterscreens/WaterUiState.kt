package br.com.heiderlopes.watertrack.ui.screens.waterscreens
//controle de estado somente mostra as infos
data class WaterUiState(
    val cupsDrunk : Int = 0,
    val goalCups: Int = 8,
    val mlPerCup : Int = 200
) {

    val progress : Float
        get() = (cupsDrunk.toFloat() / goalCups.toFloat()).coerceIn(0f,1f)

    val isGoalReached: Boolean
        get() = cupsDrunk >= goalCups

    val remainingCups: Int
        get() = (goalCups - cupsDrunk)

    val totalMl: Int
        get() = cupsDrunk * mlPerCup


}