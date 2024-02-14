package com.sai.flightsearch.ui.screens.flight_screen

import com.sai.flightsearch.model.Airport
import com.sai.flightsearch.model.Favorite

data class FlightsUiState(
    val code: String = "",
    val favoriteList: List<Favorite> = emptyList(),
    val destinationList: List<Airport> = emptyList(),
    val departureAirport: Airport = Airport(),
)
