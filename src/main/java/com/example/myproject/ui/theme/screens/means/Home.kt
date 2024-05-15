package com.example.myproject.ui.theme.screens.means

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

import androidx.navigation.compose.rememberNavController
import com.example.myproject.R
import com.example.myproject.navigation.ROUTE_BUS
import com.example.myproject.navigation.ROUTE_FLIGHT
import com.example.myproject.navigation.ROUTE_NAV
import com.example.myproject.navigation.ROUTE_TRAIN


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavController){

    Box(modifier = Modifier.fillMaxSize()) {

        Image(
            painter = painterResource(id = R.drawable.b22),
            contentDescription = "background image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize()
        )
        Column (modifier = Modifier.align(Alignment.TopEnd),){
            Row {
                Button(onClick = {navController.navigate(ROUTE_NAV)},
                    ) {
                    Image(
                        painterResource(id = R.drawable.menu1),
                        contentDescription ="menu",
                        modifier = Modifier.size(30.dp),
                    )
                }

            }
        }




        Column {

            Row {

                Text(
                    "Welcome",
                    fontSize = 29.sp,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Left,
                    fontWeight = FontWeight(400),
                    color = Color.White

                )
            }
            Row {
                Text(
                    "Travel With Us To Your Dream Destination",
                    fontSize = 22.sp,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Left,
                    fontWeight = FontWeight(400),
                    color = Color.White

                )
            }
        }

        Column(modifier = Modifier
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )

//        .background(Color.White),
//        horizontalAlignment = Alignment.CenterHorizontally)
        {
            Text(text = "Choose your preferred means of travel",
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily.SansSerif,
                color= Color.Black
            )
            Spacer(modifier = Modifier.height(30.dp))
//            SLIDESHOW(FLIGHTS)
            Card {
                Image(painter = painterResource(id = R.drawable.d9), contentDescription = "background image",
                    contentScale = ContentScale.FillBounds,
                    modifier = Modifier
                        .size(190.dp)
                        .clip(RectangleShape),

                    )
            }



            Spacer(modifier = Modifier.height(60.dp))
            Button(onClick = {
                navController.navigate(ROUTE_FLIGHT)
            }, colors = ButtonDefaults.buttonColors(Color(0xFF00BCD400)),
                border = BorderStroke(2.dp, Color.Black)
            ) {
                Image(
                    painterResource(id = R.drawable.m4),
                    contentDescription ="Bus button icon",
                    modifier = Modifier.size(30.dp),
                )


                Text(text = "Flight",Modifier.padding(start = 10.dp),
                    Color.Black
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = {
                navController.navigate(ROUTE_TRAIN)
            }, colors = ButtonDefaults.buttonColors(Color(0xFF00BCD400)),
                border = BorderStroke(2.dp, Color.Black)
            ) {
                Image(
                    painterResource(id = R.drawable.m6),
                    contentDescription ="Train button icon",
                    modifier = Modifier.size(30.dp),
                )


                Text(text = "Train",Modifier.padding(start = 10.dp),
                    Color.Black
                )
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = {
                navController.navigate(ROUTE_BUS)
            }, colors = ButtonDefaults.buttonColors(Color(0xFF00BCD400)),
                border = BorderStroke(2.dp, Color.Black)
            ) {
                Image(
                    painterResource(id = R.drawable.m3),
                    contentDescription ="Bus button icon",
                    modifier = Modifier.size(30.dp),

                    )


                Text(text = "Bus",Modifier.padding(start = 10.dp),
                    Color.Black
                )
            }










        }}}



@Preview(showSystemUi = true, showBackground = true)
@Composable
fun LoginScreenPreview() {
    HomeScreen(rememberNavController())
}
