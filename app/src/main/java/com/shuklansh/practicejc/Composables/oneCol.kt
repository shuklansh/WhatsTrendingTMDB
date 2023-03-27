package com.shuklansh.tmdblist

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import com.shuklansh.tmdblist.model.Result

val varcol = Color.White

@Composable
fun oneCol(listOfResults: com.shuklansh.tmdblist.model.Result) {
    //Spacer(modifier = Modifier.height(50.dp))
    //Log.d("name",printTitleOrNAme(listOfResults))
    Log.d("titel", if (listOfResults.title == null) listOfResults.name else listOfResults.title)
    Log.d("titel", listOfResults.media_type)
    Text(
        text = (if (listOfResults.title == null) listOfResults.name else listOfResults.title),
        fontSize = 40.sp,
        modifier = Modifier.width(300.dp),
        textAlign = TextAlign.Start,
        fontWeight = FontWeight.Bold,
        color = varcol
    )
    Spacer(modifier = Modifier.height(20.dp))
    Text(
        text = listOfResults.overview,
        fontSize = 16.sp,
        fontWeight = FontWeight.W600,
        color = varcol
    )
    Spacer(modifier = Modifier.height(40.dp))

    AsyncImage(

        model = "https://image.tmdb.org/t/p/w780/" + listOfResults.backdrop_path,
        contentDescription = "img",
        modifier = Modifier
            .fillMaxSize()
            .clip(
                RoundedCornerShape(12.dp)
            ),
        contentScale = ContentScale.Crop
    )


//        Box(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(
//                    Brush.verticalGradient(
//                        colors = listOf(
//                            Color.Transparent,
//                            Color.Red
//                        ),
//                        startY = 300f
//                    )
//                )
//        )

    Spacer(modifier = Modifier.height(16.dp))
    Text(
        text = if (listOfResults.media_type != "") "Media Type : " + listOfResults.media_type else "",
        color = if (listOfResults.title == null) Color.Red else Color.Magenta
    )
}


