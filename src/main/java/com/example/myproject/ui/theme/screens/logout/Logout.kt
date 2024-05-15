package com.example.myproject.ui.theme.screens.logout

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myproject.R
import com.example.myproject.data.AuthViewModel
import com.example.myproject.navigation.ROUTE_LOGIN

@Composable
fun LogOutScreen(navController: NavController){
    var context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.z1), contentDescription = "background image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
//        .background(Color.White),
//        horizontalAlignment = Alignment.CenterHorizontally)
        {


            Spacer(modifier = Modifier.height(250.dp))
            Spacer(modifier = Modifier.height(130.dp))

            Button(
                onClick = {
                    val mylogout= AuthViewModel(navController, context )
                    mylogout.logout()
                    navController.navigate(
                        ROUTE_LOGIN
                    )
                }, modifier = Modifier.padding(10.dp),
                colors = ButtonDefaults.buttonColors(Color(0xFF2196F3))
            ) {
                Text(text = "LOGOUT", fontWeight = FontWeight.ExtraBold, fontSize = 22.sp)
            }



        }












//        Spacer(modifier = Modifier.height(250.dp))


    }

}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LogoutScreenPreview() {
    LogOutScreen(rememberNavController())
}
