package com.pranav.login.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.pranav.findme.utils.processStates.Screen
import com.pranav.findme.home.ui.DetailsScreen
import com.pranav.findme.home.ui.MainScreen
import com.pranav.findme.utils.FindMeConstants

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigation()
        }
    }

    @Composable
    fun Navigation() {
        val navController = rememberNavController()
        NavHost(navController = navController, startDestination = Screen.MainScreen.route) {

            composable(route = Screen.MainScreen.route) {
                MainScreen(navController = navController)
            }

            composable(route = Screen.DetailsScreen.route + "/{name}",
                arguments = listOf(
                    navArgument(name = FindMeConstants.ARGS_KEY_LOGIN_FLOW_TO_DETAIL) {
                        type = NavType.StringType
                        nullable = true
                    }
                )) { backStackEntry ->
                DetailsScreen(
                    name = backStackEntry.arguments?.getString(
                        FindMeConstants.ARGS_KEY_LOGIN_FLOW_TO_DETAIL
                    )
                )
            }
        }
    }
}
