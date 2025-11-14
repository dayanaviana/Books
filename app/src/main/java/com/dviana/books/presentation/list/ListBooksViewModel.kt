package com.dviana.books.presentation.list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.dviana.books.presentation.BookViewModel
import com.dviana.books.presentation.components.BookEvent
import com.dviana.books.presentation.components.SortByAuthor
import com.dviana.books.presentation.components.SortOrder
import com.dviana.books.utils.getBooks

class ListBooksViewModel : ViewModel() {
    private val _books: MutableState<List<BookViewModel>> = mutableStateOf(emptyList())
    var books: State<List<BookViewModel>> = _books

    private var _sortOrder: MutableState<SortOrder> = mutableStateOf(SortByAuthor)
    var sortOrder: State<SortOrder> = _sortOrder

    init {
        _books.value = loadBooks(sortOrder.value)

    }

    private fun loadBooks(sortOrder: SortOrder): List<BookViewModel> {
        return getBooks(sortOrder)
    }

    fun onEvent(event: BookEvent) {
        when (event) {
            is BookEvent.Delete -> {
                deleteBook(event.book)
            }

            is BookEvent.Order -> {
                _sortOrder.value = event.order
                _books.value = loadBooks(event.order)
            }
        }
    }

    private fun deleteBook(book: BookViewModel) {
        _books.value = _books.value.filter { it != book }
    }

}