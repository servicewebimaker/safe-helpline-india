package com.safehelplineindia.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import com.safehelplineindia.data.HelplineRepository
import com.safehelplineindia.ui.screens.AboutScreen
import com.safehelplineindia.ui.screens.DirectoryScreen
import com.safehelplineindia.ui.screens.HelplineDetailScreen
import com.safehelplineindia.ui.screens.HomeScreen
import com.safehelplineindia.ui.screens.PrivacyScreen
import com.safehelplineindia.ui.screens.SafetyResourcesScreen

private enum class AppDestination(val label: String) {
    Home("Home"),
    Directory("Directory"),
    Safety("Safety"),
    Privacy("Privacy"),
    About("About")
}

@Composable
fun SafeHelplineApp() {
    val repository = remember { HelplineRepository() }
    var destinationName by rememberSaveable { mutableStateOf(AppDestination.Home.name) }
    var selectedHelplineId by rememberSaveable { mutableStateOf<String?>(null) }
    val destination = AppDestination.valueOf(destinationName)
    val selectedHelpline = selectedHelplineId?.let(repository::getById)

    Scaffold(
        topBar = {
            SafeTopBar(
                title = selectedHelpline?.name ?: destination.label,
                showBack = selectedHelpline != null,
                onBack = { selectedHelplineId = null }
            )
        },
        bottomBar = {
            if (selectedHelpline == null) {
                NavigationBar {
                    AppDestination.values().forEach { item ->
                        NavigationBarItem(
                            selected = destination == item,
                            onClick = { destinationName = item.name },
                            icon = { Icon(destinationIcon(item), contentDescription = null) },
                            label = { Text(item.label) }
                        )
                    }
                }
            }
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { innerPadding ->
        Box(Modifier.padding(innerPadding)) {
            if (selectedHelpline != null) {
                HelplineDetailScreen(helpline = selectedHelpline)
            } else {
                when (destination) {
                    AppDestination.Home -> HomeScreen(
                        helplines = repository.getHelplines(),
                        onOpenDirectory = { destinationName = AppDestination.Directory.name },
                        onOpenDetails = { selectedHelplineId = it.id }
                    )

                    AppDestination.Directory -> DirectoryScreen(
                        repository = repository,
                        onOpenDetails = { selectedHelplineId = it.id }
                    )

                    AppDestination.Safety -> SafetyResourcesScreen()
                    AppDestination.Privacy -> PrivacyScreen()
                    AppDestination.About -> AboutScreen(helplines = repository.getHelplines())
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SafeTopBar(title: String, showBack: Boolean, onBack: () -> Unit) {
    TopAppBar(
        title = { Text(title) },
        navigationIcon = {
            if (showBack) {
                IconButton(onClick = onBack) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Back")
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.background,
            titleContentColor = MaterialTheme.colorScheme.onBackground
        )
    )
}

private fun destinationIcon(destination: AppDestination): ImageVector =
    when (destination) {
        AppDestination.Home -> Icons.Default.Home
        AppDestination.Directory -> Icons.Default.Search
        AppDestination.Safety -> Icons.Default.Warning
        AppDestination.Privacy -> Icons.Default.Lock
        AppDestination.About -> Icons.Default.Info
    }
