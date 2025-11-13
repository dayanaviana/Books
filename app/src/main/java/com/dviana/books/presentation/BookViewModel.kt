package com.dviana.books.presentation

import androidx.compose.ui.graphics.Color
import com.dviana.books.presentation.components.BookEvent
import com.dviana.books.presentation.components.*
import com.dviana.books.ui.theme.Purple40
import com.dviana.books.ui.theme.Purple80
import com.dviana.books.ui.theme.PurpleGrey40
import com.dviana.books.ui.theme.PurpleGrey80

data class BookViewModel(
    val title: String = "",
    val author: String = "",
    val isRead: Boolean = false,
    val bookType: BookType = Fiction,
)

sealed class BookType(
    val backgroundColor: Color, val foregroundColor: Color
)

data object Fiction : BookType(Purple80, PurpleGrey40)
data object NonFiction : BookType(Purple40, PurpleGrey80)

val books = mutableListOf(
    BookViewModel(
        title = "The Great Gatsby",
        author = "F. Scott Fitzgerald",
        isRead = false,
        bookType = Fiction
    ),
    BookViewModel(
        title = "To Kill a Mockingbird",
        author = "Harper Lee",
        isRead = true,
        bookType = Fiction
    ),
    BookViewModel(
        title = "1984",
        author = "George Orwell",
        isRead = false,
        bookType = Fiction
    ),
    BookViewModel(
        title = "Pride and Prejudice",
        author = "Jane Austen",
        isRead = false,
        bookType = Fiction
    ),
    BookViewModel(
        title = "The Catcher in the Rye",
        author = "J.D. Salinger",
        isRead = false,
        bookType = NonFiction
    ),
    BookViewModel(
        title = "The Hobbit",
        author = "J.R.R. Tolkien",
        isRead = true,
        bookType = Fiction
    ),
    BookViewModel(
        title = "The Lord of the Rings",
        author = "J.R.R. Tolkien",
        isRead = true,
        bookType = Fiction
    ),
    BookViewModel(
        title = "The Alchemist",
        author = "Paulo Coelho",
        isRead = true,
        bookType = Fiction
    ),
    BookViewModel(
        title = "The Da Vinci Code",
        author = "Dan Brown",
        isRead = false,
        bookType = Fiction
    ),
    BookViewModel(
        title = "The Hunger Games",
        author = "Suzanne Collins",
        isRead = false,
        bookType = Fiction
    ),
    BookViewModel(
        title = "The Fault in Our Stars",
        author = "John Green",
        isRead = false,
        bookType = NonFiction
    ),
    BookViewModel(
        title = "The Kite Runner",
        author = "Khaled Hosseini",
        isRead = false,
        bookType = Fiction
    ),
    BookViewModel(
        title = "The Book Thief",
        author = "Markus Zusak",
        isRead = false,
        bookType = NonFiction
    ),
    BookViewModel(
        title = "Harry Potter and the Sorcerer's Stone",
        author = "J.K. Rowling",
        isRead = false,
        bookType = Fiction
    ),
    BookViewModel(
        title = "The Chronicles of Narnia",
        author = "C.S. Lewis",
        isRead = true,
        bookType = Fiction
    ),
    BookViewModel(
        title = "Animal Farm",
        author = "George Orwell",
        isRead = false,
        bookType = NonFiction
    ),
    BookViewModel(
        title = "Fahrenheit 451",
        author = "Ray Bradbury",
        isRead = false,
        bookType = NonFiction
    ),
    BookViewModel(
        title = "Moby Dick",
        author = "Herman Melville",
        isRead = false,
        bookType = Fiction
    ),
    BookViewModel(
        title = "War and Peace",
        author = "Leo Tolstoy",
        isRead = true,
        bookType = NonFiction
    ),
    BookViewModel(
        title = "The Odyssey",
        author = "Homer",
        isRead = true,
        bookType = Fiction
    ),
    BookViewModel(
        title = "Brave New World",
        author = "Aldous Huxley",
        isRead = false,
        bookType = NonFiction
    ),
    BookViewModel(
        title = "Don Quixote",
        author = "Miguel de Cervantes",
        isRead = true,
        bookType = Fiction
    ),
    BookViewModel(
        title = "Frankenstein",
        author = "Mary Shelley",
        isRead = false,
        bookType = Fiction
    )
)

fun sortBooks(books: List<BookViewModel>, event: BookEvent.Order): List<BookViewModel> {
    return when (event.order) {
        SortByAuthor -> books.sortedBy { it.author }
        SortByFictional -> books.sortedBy { it.bookType == Fiction }
        SortByRead -> books.sortedBy { it.isRead }
        SortByTitle -> books.sortedBy { it.title }
    }
}
