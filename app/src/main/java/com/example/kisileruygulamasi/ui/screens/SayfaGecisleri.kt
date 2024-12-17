package com.example.kisileruygulamasi.ui.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.kisileruygulamasi.data.entity.Kisiler
import com.google.gson.Gson

@Composable
fun SayfaGecisleri(){
    val navController= rememberNavController ()
    NavHost(navController = navController, startDestination = "anasayfa" ){
        composable("anasayfa"){
            Anasayfa(navController=navController)
        }
        composable("kisiKayitSayfa"){
            KisiKayitSayfa()
        }
        composable("kisiDetaySayfa/{kisi}",
            arguments = listOf(navArgument("kisi")
            {type= NavType.StringType})
        ){
            val json=it.arguments?.getString("kisi")
            val nesne=Gson().fromJson(json,Kisiler::class.java)
            KisiDetaySayfa(gelenKisi = nesne)
        }
    }
}