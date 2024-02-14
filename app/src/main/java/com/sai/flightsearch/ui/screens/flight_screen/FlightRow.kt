package com.sai.flightsearch.ui.screens.flight_screen

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.sai.flightsearch.data.MockData
import com.sai.flightsearch.ui.screens.search.AirportRow

@Composable
fun FlightRow(
    modifier: Modifier = Modifier,
    isFavorite: Boolean,
    departureAirportCode: String,
    departureAirportName: String,
    destinationAirportCode: String,
    destinationAirportName: String,
    onFavoriteClick: (String, String) -> Unit,
) {
    Card(
        elevation = 8.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
    ) {
        Row {
            Column(
                modifier = modifier.weight(10f)
            ) {
                Column {
                    Text(
                        text = "Depart",
                        style = MaterialTheme.typography.overline,
                        modifier = Modifier.padding(start = 32.dp),
                        color = Color.Red // Set departure text color to red
                    )
                    AirportRow(code = departureAirportCode, name = departureAirportName, color = Color.Red)
                    Text(
                        text = "Arrival",
                        style = MaterialTheme.typography.overline,
                        modifier = Modifier.padding(start = 32.dp),
                        color = Color.Green // Set arrival text color to green
                    )
                    AirportRow(code = destinationAirportCode, name = destinationAirportName, color = Color.Green)
                }
            }
            IconButton(
                onClick = {
                    onFavoriteClick(departureAirportCode, destinationAirportCode)
                },
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Icon(
                    imageVector = if (isFavorite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                    tint = if (isFavorite) Color.Red else Color.LightGray,
                    contentDescription = null
                )
            }
        }
    }
}

@Composable
fun AirportRow(code: String, name: String, color: Color) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = code,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(start = 16.dp),
            color = color // Set text color
        )
        Text(
            text = name,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.padding(start = 8.dp),
            color = color // Set text color
        )
    }
}

@Preview
@Composable
fun FlightRowPreview() {
    val mock = MockData
    FlightRow(
        isFavorite = true,
        departureAirportCode = mock.airports[1].code,
        departureAirportName = mock.airports[1].name,
        destinationAirportCode = mock.airports[2].code,
        destinationAirportName = mock.airports[2].name,
        onFavoriteClick = { _: String, _:String ->}
    )
}
