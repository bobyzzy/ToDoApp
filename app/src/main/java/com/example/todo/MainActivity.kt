package com.example.todo

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todo.presentation.MainScreen
import com.example.todo.presentation.TodoCreateScreen
import com.example.todo.ui.theme.AppRotues


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            NavHost(
                navController = navController, startDestination = AppRotues.MainScreen,
                builder = {
                    composable(route = "MainScreen") {
                        MainScreen(navController)
                    }
                    composable(route = "ToDo_Create") {
                        TodoCreateScreen(navController)
                    }
                },
            )
        }
    }

    @OptIn(ExperimentalMaterial3Api::class)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @Preview(showBackground = true, showSystemUi = false)
    @Composable
    fun Preview() {
        val navController = rememberNavController()
        NavHost(
            navController = navController, startDestination = AppRotues.MainScreen,
            builder = {
                composable(route = "MainScreen") {
                    MainScreen(navController)
                }
                composable(route = "ToDo_Create") {
                    TodoCreateScreen(navController)
                }
            },
        )
    }
}


