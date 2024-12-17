package com.example.kisileruygulamasi.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.example.kisileruygulamasi.R
import com.example.kisileruygulamasi.data.entity.Kisiler
import com.google.gson.Gson

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Anasayfa(navController: NavController){
    val aramaYapiliyorMu=remember{ mutableStateOf(false) }
    val tfAra= remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    if (aramaYapiliyorMu.value){
                        Text(text = "Ara")
                    }else{
                        Text(text = "Kisiler")
                    }

                        },
                actions={
                    if (aramaYapiliyorMu.value){
                        IconButton(onClick = { aramaYapiliyorMu.value=false}) {
                            Icon(painter = painterResource(id = R.drawable.kapat_resim), contentDescription ="" )
                        }
                    }else{
                        IconButton(onClick = {aramaYapiliyorMu.value=true }) {
                            Icon(painter = painterResource(id = R.drawable.ara_resim), contentDescription ="" )
                        }
                    }

                }
            )
                 },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                          navController.navigate("kisiKayitSayfa")
                },
                content = { Icon(painter = painterResource(id = R.drawable.ekle_resim),
                    contentDescription = "")
                }
            )
        }
    ) {paddingValues ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            )
        {
            Button(onClick = {
                val kisi=Kisiler(1,"Ahmet","1111")
                val kisiJson=Gson().toJson(kisi)
                navController.navigate("kisiDetaySayfa/${kisiJson}")
            })
            {
                Text(text = "Detay")
            }
        }
    }
}