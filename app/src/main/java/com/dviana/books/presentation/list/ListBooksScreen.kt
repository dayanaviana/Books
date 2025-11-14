package com.dviana.books.presentation.list

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.dviana.books.R
import com.dviana.books.presentation.components.BookCard
import com.dviana.books.presentation.components.BookEvent
import com.dviana.books.presentation.components.SortOptions
import com.dviana.books.utils.Screen

@Composable
fun ListBooksScreen(navController: NavController, booksViewModel: ListBooksViewModel) {

    Scaffold(
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Screen.AddEditBooksScreen.route)
                }, modifier = Modifier.background(Color.White)
            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = "Add a book")
            }
        }) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .padding(horizontal = 8.dp)
                .fillMaxSize()
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp),
                textAlign = TextAlign.Center,
                text = stringResource(id = R.string.main_heading),
                style = TextStyle(fontSize = 32.sp)
            )

            SortOptions(bookOrder = booksViewModel.sortOrder.value, onSortOrderChange = { order ->
                booksViewModel.onEvent(BookEvent.Order(order))
            })

            Spacer(modifier = Modifier.height(8.dp))
            LazyColumn {
                items(booksViewModel.books.value) { book ->
                    BookCard(book, onDeleteClick = {
                        booksViewModel.onEvent(BookEvent.Delete(book))
                    })
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}