package com.pranav.findme.utils.processStates

import com.pranav.findme.utils.FindMeConstants

sealed class Screen(val route:String){
    object MainScreen : Screen(FindMeConstants.FIND_ME_LOGIN_FLOW_KEY_MAIN_ACTIVITY)
    object DetailsScreen : Screen(FindMeConstants.FIND_ME_MAIN_SCREEN_KEY_DETAIL)

    fun withArgs( args:String):String{
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}