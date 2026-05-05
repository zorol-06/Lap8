package com.example.lap8

import android.os.Bundle
import android.view.Surface
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lap8.ui.theme.MidTermTheme
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth

class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MidTermTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Mynavigation()
                }
            }
        }
    }
}

@Composable
fun Mynavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Signin.route          // ← route
    ) {
        composable(Screen.Signin.route) {               // ← route
            Signln(navController = navController)
        }
        composable(Screen.Home.route) {                 // ← route
            HomeScreen(navController = navController)
        }
        composable(Screen.Signup.route) {               // ← route
            SignUp(navController = navController)
        }
    }
}