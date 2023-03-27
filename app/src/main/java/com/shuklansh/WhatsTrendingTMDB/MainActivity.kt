package com.shuklansh.WhatsTrendingTMDB

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.remember
import androidx.compose.runtime.*
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.shuklansh.WhatsTrendingTMDB.Composables.Dialog
import com.shuklansh.WhatsTrendingTMDB.NetworkConnectivity.ConnectivityObserver
import com.shuklansh.WhatsTrendingTMDB.NetworkConnectivity.NetworkConnectivityObserver
import com.shuklansh.WhatsTrendingTMDB.apiRepo.InterfaceApi
import com.shuklansh.WhatsTrendingTMDB.apiRepo.ObjectApi
import com.shuklansh.WhatsTrendingTMDB.ui.theme.PracticeJCTheme
import com.shuklansh.tmdblist.model.TrendingResponse
import com.shuklansh.tmdblist.oneCol
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    private lateinit var connectivityObserver: ConnectivityObserver
    val apicaller = ObjectApi.getInstance().create(InterfaceApi::class.java)
    val apikey = apikeyClass().apikeyreturn()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        connectivityObserver = NetworkConnectivityObserver(applicationContext)
        setContent {
            val status by connectivityObserver.observe()
                .collectAsState(initial = ConnectivityObserver.Status.Available)
            //var errorBool by remember { mutableStateOf(false) }
            var scope = rememberCoroutineScope()
            var listofResult by remember {
                mutableStateOf(
                    TrendingResponse(
                        0,
                        listOf(com.shuklansh.tmdblist.model.Result("", "Tv/Movie", "Name", "Overview", "Title")),
                        0,
                        0
                    )
                )
            }
            if (status.toString() != "Available" ) Dialog(dialogOpenSt = true, status.toString()) else
                PracticeJCTheme {
                    // A surface container using the 'background' color from the theme

                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colors.background
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier
                                .fillMaxWidth()
                                .background(Color.DarkGray)
                        ) {
                            Spacer(modifier = Modifier.height(12.dp))
                            Button(
                                onClick = {

                                    scope.launch {
                                        listofResult = getData(apikey)
                                    }


                                },
                                shape = RoundedCornerShape(500f),
                                colors = ButtonDefaults.buttonColors(
                                    backgroundColor = Color.Magenta
                                )
                            ) {

                                Text(
                                    text = "What's Trending?",
                                    fontSize = 20.sp,
                                    modifier = Modifier.padding(20.dp),
                                    color = Color.Black
                                )
                            }

                            LazyColumn(
                                modifier = Modifier.fillMaxHeight(0.98f)
                            )
                            {

                                items(items = listofResult.results) {
                                    Column(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .padding(8.dp)
                                            .clip(RoundedCornerShape(16.dp))
                                            .background(Color.Black),
                                    ) {
                                        Card(
                                            elevation = 8.dp,
                                            backgroundColor = Color.Black
                                        ){
                                        Column(
                                            modifier = Modifier.padding(21.dp),
                                            horizontalAlignment = Alignment.CenterHorizontally,
                                            verticalArrangement = Arrangement.Top
                                        ) {

                                                oneCol(listOfResults = it)
                                            }
                                        }

                                    }
                                }
                            }

                        }


                }

            }
        }
    }

    suspend fun getData(apikey: String): TrendingResponse {
        val resultOfCall = apicaller.getTrending(apikey)
        return resultOfCall
    }


}

//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name!")
//}
//
//@Preview(showBackground = true)
//@Composable
//fun DefaultPreview() {
//    PracticeJCTheme {
//        Greeting("Android")
//    }
//}