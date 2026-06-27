package com.safehelplineindia.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.safehelplineindia.domain.model.Helpline
import com.safehelplineindia.ui.components.EmergencyNotice
import com.safehelplineindia.ui.components.HelplineCard
import com.safehelplineindia.ui.util.openDialer
import com.safehelplineindia.ui.util.openWebPage

@Composable
@OptIn(ExperimentalLayoutApi::class)
fun HomeScreen(
    helplines: List<Helpline>,
    onOpenDirectory: () -> Unit,
    onOpenDetails: (Helpline) -> Unit
) {
    val context = LocalContext.current

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(20.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                Text(
                    text = "Safe Helpline India",
                    style = MaterialTheme.typography.displaySmall,
                    fontWeight = FontWeight.Black
                )
                Text(
                    text = "Offline verified helpline information for India with no accounts, no location permission, and no automatic calls.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                FlowRow(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Button(
                        onClick = { context.openDialer("112") },
                        colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.error)
                    ) {
                        Icon(imageVector = Icons.Default.Phone, contentDescription = null)
                        Text(text = "Call 112", modifier = Modifier.padding(start = 8.dp))
                    }
                    OutlinedButton(onClick = onOpenDirectory) {
                        Icon(imageVector = Icons.Default.Search, contentDescription = null)
                        Text(text = "Browse directory", modifier = Modifier.padding(start = 8.dp))
                    }
                }
            }
        }

        item {
            EmergencyNotice()
        }

        items(helplines, key = { it.id }) { helpline ->
            HelplineCard(
                helpline = helpline,
                onCall = { context.openDialer(helpline.number) },
                onOpenSource = { context.openWebPage(helpline.sourceUrl) },
                onOpenDetails = { onOpenDetails(helpline) }
            )
        }
    }
}
