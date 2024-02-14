package com.sai.flightsearch.di

import android.content.Context
import com.sai.flightsearch.data.FlightDatabase
import com.sai.flightsearch.data.FlightRepository
import com.sai.flightsearch.data.OfflineFlightRepository

/**
 * App container for Dependency injection.
 */
interface AppContainer {
    val flightRepository: FlightRepository
}

/**
 * [AppContainer] implementation that provides instance of [OfflineFlightRepository]
 */
class AppDataContainer(private val context: Context) : AppContainer {
    /**
     * Implementation for [FlightRepository]
     */
    override val flightRepository: FlightRepository by lazy {
        OfflineFlightRepository(FlightDatabase.getDatabase(context).flightDao())
    }
}