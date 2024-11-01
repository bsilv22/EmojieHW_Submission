package edu.farmingdale.datastoredemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import edu.farmingdale.datastoredemo.ui.EmojiReleaseApp
import edu.farmingdale.datastoredemo.ui.ThemeViewModel
import edu.farmingdale.datastoredemo.ui.theme.DataStoreDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize ThemeViewModel to observe theme state
        val themeViewModel: ThemeViewModel by viewModels()

        setContent {
            // Collect the isDarkTheme state from ThemeViewModel
            val isDarkTheme = themeViewModel.isDarkTheme.collectAsState().value

            // Pass isDarkTheme to DataStoreDemoTheme
            DataStoreDemoTheme(darkTheme = isDarkTheme) {
                EmojiReleaseApp()
            }
        }
    }
}