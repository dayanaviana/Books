package com.dviana.books.presentation

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dviana.books.presentation.components.BookCard

@Composable
fun ListBooksScreen(innerPadding: PaddingValues) {
    LazyColumn(
        modifier = Modifier
            .padding(innerPadding)
            .border(1.dp, color = Color.Red)
            .fillMaxSize()
    ) {
        books.forEach { book ->
            item {
                BookCard(book) {
                    println("Deleting book ${book.title}")
                    books.remove(book)
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ListBooksScreenPreview() {
    ListBooksScreen(innerPadding = PaddingValues())
}