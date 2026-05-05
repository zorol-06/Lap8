package com.example.lap8

sealed class Screen(val route: String){
    object Home : Screen("home")
    object Signin : Screen("signin")
    object Signup : Screen("signup")
}