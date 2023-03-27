package com.shuklansh.practicejc.Composables

import android.app.Activity
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.format.TextStyle

@Composable
fun Dialog(dialogOpenSt : Boolean , message : String){

//    Column(modifier = Modifier.fillMaxWidth()) {
//        Button(onClick = {dialogOpen=true}) {
//            Text(text = "dialog show")
//        }
//    }
    var dialogOpen = dialogOpenSt
    val activity = LocalContext.current as? Activity
    if(dialogOpen){
        androidx.compose.ui.window.Dialog(onDismissRequest = {
            dialogOpen=false
        }) {

            Column(modifier = Modifier.fillMaxWidth().fillMaxHeight(0.55f).padding(40.dp)
                .background(Color.White)  ) {

                Column(modifier = Modifier
                    .padding(12.dp)
                    ) {
                    Text(text = "Error" , fontSize = 20.sp , fontWeight = FontWeight.Bold  )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "Network status: "+ message , fontSize = 12.sp , )//fontWeight = FontWeight.Bold  )
                    Spacer(modifier = Modifier.height(10.dp))
                    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.End) {
                        Button(onClick = { activity?.finish() }) {
                            Text(text = "Okay")
                        }
                    }
                }


            }

        }

    }


}