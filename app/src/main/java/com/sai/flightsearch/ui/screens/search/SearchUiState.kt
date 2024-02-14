package com.sai.flightsearch.ui.screens.search

import com.sai.flightsearch.model.Airport
import com.sai.flightsearch.model.Favorite

data class SearchUiState(
    val searchQuery: String = "",
    val selectedCode: String = "",
    val airportList: List<Airport> = emptyList(),
    val favoriteList: List<Favorite> = emptyList(),
)