package com.dviana.books.utils

import com.dviana.books.presentation.BookViewModel
import com.dviana.books.presentation.Fiction
import com.dviana.books.presentation.NonFiction
import com.dviana.books.presentation.components.SortByAuthor
import com.dviana.books.presentation.components.SortByFictional
import com.dviana.books.presentation.components.SortByRead
import com.dviana.books.presentation.components.SortByTitle
import com.dviana.books.presentation.components.SortOrder

fun getBooks(orderBy: SortOrder): List<BookViewModel> {
    val books: List<BookViewModel> = listOf(
        BookViewModel("Catch-22", author = "Joseph Heller", isRead = true),
        BookViewModel("To Kill A Mockingbird", author = "Harper Lee", isRead = true),
        BookViewModel("A Tale Of Two Cities", author = "Charles Dickens", isRead = false),
        BookViewModel(
            "On The Origin Of Species",
            author = "Charles Darwin",
            isRead = false,
            bookType = NonFiction
        ),
        BookViewModel(
            "A Brief History Of TIme",
            author = "Stephen Hawkins",
            isRead = true,
            bookType = NonFiction
        ),
    )
    return when(orderBy) {
        SortByAuthor -> books.sortedBy { it.author }
        SortByFictional -> books.sortedBy { it.bookType == Fiction }
        SortByRead -> books.sortedBy { it.isRead }
        SortByTitle -> books.sortedBy { it.title }
    }
}