package com.pranav.findme.home.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import com.pranav.findme.R
import com.pranav.findme.utils.FindMeConstants
import com.pranav.findme.utils.processStates.Screen

@kotlin.OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavController) {
    var text by remember {
        mutableStateOf("")
    }
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                horizontal = 50.dp,
                vertical = 50.dp
            )
    ) {
        Spacer(modifier = Modifier.height(180.dp))

        OutlinedTextField(
            value = text,
            onValueChange = { newString ->
                text = newString
            }, placeholder = { Text(text= stringResource(id = R.string.login_til_hint_msg)) })

        Spacer(modifier = Modifier.height(8.dp))

        Button(
            onClick = {
                navController.navigate(route = Screen.DetailsScreen.route + "/${text}"){
                    popUpTo(FindMeConstants.FIND_ME_LOGIN_FLOW_KEY_MAIN_ACTIVITY){
                        inclusive = false
                    }
                }
            },
            modifier = Modifier.align(Alignment.CenterHorizontally),
            enabled = text.isNullOrBlank().not()
        ) {
            val context = LocalContext.current
            Text(text = stringResource(id = R.string.login_btn_text))

        }
    }
}