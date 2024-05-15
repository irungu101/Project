package com.example.myproject.ui.theme.nav

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myproject.R
import com.example.myproject.navigation.ROUTE_HOME
import com.example.myproject.navigation.ROUTE_LOGIN
import com.example.myproject.navigation.ROUTE_LOGOUT
import com.example.myproject.navigation.ROUTE_MY_BOOKING
import com.example.myproject.navigation.ROUTE_REGISTER

@Composable
fun NavScreen(navController: NavController){

    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.b33),
            contentDescription = "background image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
Column (
    modifier = Modifier.fillMaxSize(),
    verticalArrangement = Arrangement.Center,
    horizontalAlignment = Alignment.CenterHorizontally
) {
    Button(onClick = {
        navController.navigate(ROUTE_HOME)
    }, colors = ButtonDefaults.buttonColors(Color(0xFF00BCD400)),
        border = BorderStroke(2.dp, Color.Black)
    ) {
        Image(
            painterResource(id = R.drawable.h1),
            contentDescription ="HOME",
            modifier = Modifier.size(30.dp),
        )


        Text(text = "HOME",Modifier.padding(start = 10.dp),
            Color.Black
        )
    }
    Spacer(modifier = Modifier.height(20.dp))
    Button(onClick = {
        navController.navigate(ROUTE_MY_BOOKING)
    }, colors = ButtonDefaults.buttonColors(Color(0xFF00BCD400)),
        border = BorderStroke(2.dp, Color.Black)
    ) {
        Image(
            painterResource(id = R.drawable.h3),
            contentDescription ="BOOKINGS",
            modifier = Modifier.size(30.dp),
        )


        Text(text = "BOOKINGS",Modifier.padding(start = 10.dp),
            Color.Black
        )
    }
    Spacer(modifier = Modifier.height(20.dp))
    Button(onClick = {
        navController.navigate(ROUTE_LOGIN)
    }, colors = ButtonDefaults.buttonColors(Color(0xFF00BCD400)),
        border = BorderStroke(2.dp, Color.Black)
    ) {
        Image(
            painterResource(id = R.drawable.x111),
            contentDescription ="person",
            modifier = Modifier.size(30.dp),
        )


        Text(text = "LOGIN",Modifier.padding(start = 10.dp),
            Color.Black
        )
    }
    Spacer(modifier = Modifier.height(20.dp))
    Button(onClick = {
        navController.navigate(ROUTE_REGISTER)
    }, colors = ButtonDefaults.buttonColors(Color(0xFF00BCD400)),
        border = BorderStroke(2.dp, Color.Black)
    ) {
        Image(
            painterResource(id = R.drawable.x222),
            contentDescription ="person",
            modifier = Modifier.size(30.dp),
        )


        Text(text = "SIGNUP",Modifier.padding(start = 10.dp),
            Color.Black
        )
    }
    Spacer(modifier = Modifier.height(20.dp))
    Button(onClick = {
        navController.navigate(ROUTE_LOGOUT)
    }, colors = ButtonDefaults.buttonColors(Color(0xFF00BCD400)),
        border = BorderStroke(2.dp, Color.Black)
    ) {
        Image(
            painterResource(id = R.drawable.h2),
            contentDescription ="person",
            modifier = Modifier.size(30.dp),
        )


        Text(text = "LOGOUT",Modifier.padding(start = 10.dp),
            Color.Black
        )
    }










}



        }
    }

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun NavScreenPreview() {
    NavScreen(rememberNavController())
}

