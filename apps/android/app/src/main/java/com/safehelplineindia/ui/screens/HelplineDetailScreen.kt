package com.safehelplineindia.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.safehelplineindia.domain.model.Helpline
import com.safehelplineindia.ui.components.EmergencyNotice
import com.safehelplineindia.ui.util.openDialer
import com.safehelplineindia.ui.util.openWebPage

@Composable
@OptIn(ExperimentalLayoutApi::class)
fun HelplineDetailScreen(helpline: Helpline) {
    val context = LocalContext.current

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            EmergencyNotice()
        }
        item {
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(text = helpline.category.label, color = MaterialTheme.colorScheme.primary, fontWeight = FontWeight.Bold)
                Text(text = helpline.name, style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Black)
                Text(
                    text = helpline.number,
                    style = MaterialTheme.typography.displayMedium,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Black
                )
                Text(
                    text = helpline.description,
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Button(
                        onClick = { context.openDialer(helpline.number) },
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                    ) {
                        Icon(imageVector = Icons.Default.Phone, contentDescription = null)
                        Text(text = "Call ${helpline.number}", modifier = Modifier.padding(start = 8.dp))
                    }
                    OutlinedButton(onClick = { context.openWebPage(helpline.sourceUrl) }) {
                        Icon(imageVector = Icons.Default.Info, contentDescription = null)
                        Text(text = "Open source", modifier = Modifier.padding(start = 8.dp))
                    }
                }
            }
        }
        item {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = MaterialTheme.shapes.medium,
                color = MaterialTheme.colorScheme.surface
            ) {
                Column(Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    DetailRow("Availability", helpline.availability)
                    HorizontalDivider()
                    DetailRow("Country", helpline.country)
                    HorizontalDivider()
                    DetailRow("Source", helpline.sourceName)
                    HorizontalDivider()
                    DetailRow("Last verified", helpline.lastVerified)
                    HorizontalDivider()
                    DetailRow("Verification status", helpline.verificationStatus)
                }
            }
        }
    }
}

@Composable
private fun DetailRow(label: String, value: String) {
    Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
        Text(text = label, style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
        Text(text = value, style = MaterialTheme.typography.bodyLarge)
    }
}
