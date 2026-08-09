package com.example.lms

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import dagger.hilt.android.AndroidEntryPoint
import com.example.lms.ui.AppNav

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(b: Bundle?) {
        super.onCreate(b);setContent { MaterialTheme { Surface { AppNav() } } }
    }
}
