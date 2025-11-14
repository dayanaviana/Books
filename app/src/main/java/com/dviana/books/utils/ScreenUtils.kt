package com.dviana.books.utils

sealed class Screen(val route: String) {
    data object BookListScreen : Screen("books_list_screen")
    data object AddEditBooksScreen : Screen("add_edit_book_screen")
}