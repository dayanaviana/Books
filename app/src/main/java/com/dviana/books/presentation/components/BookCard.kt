package com.dviana.books.presentation.components

import com.dviana.books.R
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dviana.books.presentation.BookViewModel

@Composable
fun BookCard(book: BookViewModel,
             onDeleteClick: (BookViewModel) -> Unit) {
    Box(
        modifier = Modifier
            .border(1.dp, color = Color.Blue)
            .fillMaxSize()
            .background(
                color = book.bookType.backgroundColor,
                shape = RoundedCornerShape(25.dp)
            )
            .padding(16.dp)
    ) {
        Column {
            Row(
                modifier = Modifier.fillMaxSize(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = book.title,
                    style = TextStyle(fontSize = 32.sp, color = book.bookType.foregroundColor),
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis
                )
                if (book.isRead) {
                    Icon(
                        imageVector = Icons.Filled.Check,
                        contentDescription = "Check",
                        tint = Color.DarkGray
                    )
                }
            }
            Text(
                text = book.author,
                style = TextStyle(fontSize = 32.sp, color = book.bookType.foregroundColor),
                maxLines = 1,
                overflow = TextOverflow.Visible
            )
        }
        IconButton(
            onClick = { onDeleteClick(book)
            },
            modifier = Modifier.align(Alignment.BottomEnd)
        ) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = stringResource(id = R.string.delete),
                tint = Color.White
            )
        }
    }
}