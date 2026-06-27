package com.safehelplineindia.ui.screens

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.safehelplineindia.data.HelplineRepository
import com.safehelplineindia.domain.model.Helpline
import com.safehelplineindia.domain.model.HelplineCategory
import com.safehelplineindia.domain.usecase.SearchHelplinesUseCase
import com.safehelplineindia.ui.components.HelplineCard
import com.safehelplineindia.ui.util.openDialer
import com.safehelplineindia.ui.util.openWebPage

@Composable
fun DirectoryScreen(
    repository: HelplineRepository,
    onOpenDetails: (Helpline) -> Unit
) {
    val context = LocalContext.current
    val searchHelplines = remember(repository) { SearchHelplinesUseCase(repository) }
    var query by rememberSaveable { mutableStateOf("") }
    var selectedCategory by rememberSaveable { mutableStateOf("All") }
    val category = HelplineCategory.fromLabel(selectedCategory)
    val results = remember(query, selectedCategory) { searchHelplines(query, category) }
    val filters = listOf("All") + HelplineCategory.values().map { it.label }

    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = 12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            OutlinedTextField(
                value = query,
                onValueChange = { query = it },
                modifier = Modifier.fillMaxWidth(),
                singleLine = true,
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                label = { Text("Search verified helplines") },
                placeholder = { Text("Number, category, or source") }
            )
            Row(
                modifier = Modifier.horizontalScroll(rememberScrollState()),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                filters.forEach { filter ->
                    FilterChip(
                        selected = selectedCategory == filter,
                        onClick = { selectedCategory = filter },
                        label = { Text(filter) }
                    )
                }
            }
            Text(
                text = "Showing ${results.size} verified helplines",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        }

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(horizontal = 20.dp, vertical = 8.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp)
        ) {
            items(results, key = { it.id }) { helpline ->
                HelplineCard(
                    helpline = helpline,
                    onCall = { context.openDialer(helpline.number) },
                    onOpenSource = { context.openWebPage(helpline.sourceUrl) },
                    onOpenDetails = { onOpenDetails(helpline) }
                )
            }
        }
    }
}
