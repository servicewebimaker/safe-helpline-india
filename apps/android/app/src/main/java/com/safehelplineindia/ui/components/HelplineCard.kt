package com.safehelplineindia.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.safehelplineindia.domain.model.Helpline
import com.safehelplineindia.domain.model.HelplineCategory
import com.safehelplineindia.ui.theme.EmergencyRed
import com.safehelplineindia.ui.theme.WomenPurple

@Composable
@OptIn(ExperimentalLayoutApi::class)
fun HelplineCard(
    helpline: Helpline,
    onCall: () -> Unit,
    onOpenSource: () -> Unit,
    onOpenDetails: () -> Unit,
    modifier: Modifier = Modifier
) {
    val categoryColor = if (helpline.category == HelplineCategory.Emergency) EmergencyRed else WomenPurple

    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Column(Modifier.padding(18.dp)) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                AssistChip(
                    onClick = onOpenDetails,
                    label = { Text(helpline.category.label) },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.CheckCircle,
                            contentDescription = null,
                            tint = categoryColor
                        )
                    }
                )
                AssistChip(onClick = onOpenDetails, label = { Text(helpline.availability) })
            }

            Spacer(Modifier.height(12.dp))
            Text(text = helpline.name, style = MaterialTheme.typography.titleLarge)
            Text(
                text = helpline.number,
                style = MaterialTheme.typography.displaySmall,
                fontWeight = FontWeight.Black,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier
                    .padding(top = 4.dp)
                    .semantics { contentDescription = "Helpline number ${helpline.number}" }
            )
            Text(
                text = helpline.description,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                modifier = Modifier.padding(top = 8.dp)
            )

            FlowRow(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Button(
                    onClick = onCall,
                    colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
                ) {
                    Icon(imageVector = Icons.Default.Phone, contentDescription = null)
                    Text(text = "Call ${helpline.number}", modifier = Modifier.padding(start = 8.dp))
                }
                OutlinedButton(onClick = onOpenSource) {
                    Icon(imageVector = Icons.Default.Info, contentDescription = null)
                    Text(text = "Source", modifier = Modifier.padding(start = 8.dp))
                }
                TextButton(onClick = onOpenDetails) {
                    Text("Details")
                }
            }
        }
    }
}
