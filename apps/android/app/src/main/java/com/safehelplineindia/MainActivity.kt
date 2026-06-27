package com.safehelplineindia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.safehelplineindia.ui.SafeHelplineApp
import com.safehelplineindia.ui.theme.SafeHelplineIndiaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SafeHelplineIndiaTheme {
                SafeHelplineApp()
            }
        }
    }
}
