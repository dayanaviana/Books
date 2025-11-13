package com.dviana.books.presentation

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dviana.books.presentation.components.BookCard

import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.dviana.books.R
import com.dviana.books.presentation.components.BookEvent
import com.dviana.books.presentation.components.SortByAuthor
import com.dviana.books.presentation.components.SortOptions
import com.dviana.books.presentation.components.SortOrder

@Composable
fun ListBooksScreen(booksVM: ListBooksViewModel, innerPadding: PaddingValues) {

    Column(
        modifier = Modifier
            .padding(innerPadding)
            .padding(horizontal = 8.dp)
            .fillMaxSize()
    ) {
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
            textAlign = TextAlign.Center,
            text = stringResource(id = R.string.main_heading),
            style = TextStyle(fontSize = 32.sp)
        )

        var sortOrder: SortOrder by remember {
            mutableStateOf(SortByAuthor)
        }
//        SortOptions(bookOrder = sortOrder, onSortOrderChange = { order ->
//            sortOrder = order
//            booksVM = sortBooks(booksVM, BookEvent.Order(order))
//        })

        Spacer(modifier = Modifier.height(8.dp))

        //Book List
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .border(1.dp, color = Color.Red)
                .fillMaxSize()
        ) {
            items(booksVM.books.value) { book ->
                BookCard(book, onDeleteClick = {})

            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ListBooksScreenPreview() {
    ListBooksScreen(ListBooksViewModel(), innerPadding = PaddingValues())
}