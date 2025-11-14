package com.dviana.books

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dviana.books.presentation.list.ListBooksScreen
import com.dviana.books.presentation.list.ListBooksViewModel
import com.dviana.books.ui.theme.BooksTheme
import com.dviana.books.utils.Screen

class MainActivity : ComponentActivity() {
    override fun onStart() {
        super.onStart()
        println("onStart")
    }

    override fun onRestart() {
        super.onRestart()
        println("onRestart")
    }

    override fun onResume() {
        super.onResume()
        println("onResume")
    }

    override fun onPause() {
        super.onPause()
        println("onPause")
    }

    override fun onStop() {
        super.onStop()
        println("onStop")
    }

    override fun onDestroy() {
        super.onDestroy()
        println("onDestroy")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BooksTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.BookListScreen.route,
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        // Tell NavHost that this is our start destination
                        composable(route = Screen.BookListScreen.route) {
                            val books = viewModel<ListBooksViewModel>()
                            ListBooksScreen(navController, books)
                        }
                    }
                }
            }
        }
    }
}