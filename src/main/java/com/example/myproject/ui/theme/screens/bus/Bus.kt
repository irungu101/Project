package com.example.myproject.ui.theme.screens.bus

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myproject.R
import com.example.myproject.data.ProductViewModel
import com.example.myproject.navigation.ROUTE_MY_BOOKING

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BusScreen(navController: NavController){
    var productFrom by remember { mutableStateOf(TextFieldValue("")) }
    var productDestination by remember { mutableStateOf(TextFieldValue("")) }
    var productDeparture by remember { mutableStateOf(TextFieldValue("")) }
    var productReturndate by remember { mutableStateOf(TextFieldValue("")) }

    var context= LocalContext.current

    Box(modifier = Modifier.fillMaxSize()) {
        Image(painter = painterResource(id = R.drawable.b25), contentDescription = "background image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize())


        Column {
            Row {
                Text(
                    "Book Your Bus Here",
                    fontSize = 28.sp,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Left,
                    fontWeight = FontWeight(400),
                    color = Color.White

                )

            }

//            Row {
//                Text(
//                    "Book Your Flight Here",
//                    fontSize = 32.sp,
//                    fontFamily = FontFamily.SansSerif,
//                    textAlign = TextAlign.Left,
//                    fontWeight = FontWeight(400),
//                    color = Color.White
//
//                )
//            }
        }











        Column(modifier = Modifier
            .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )


//        .background(Color.White),
//        horizontalAlignment = Alignment.CenterHorizontally)
        {
            Spacer(modifier = Modifier.height(70.dp))
//            SLIDESHOW(FLIGHTS)
            Card {
                Image(painter = painterResource(id = R.drawable.x9), contentDescription = "background image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(170.dp)
                        .clip(RectangleShape)
                )
            }



            Spacer(modifier = Modifier.height(30.dp))
            OutlinedTextField(
                value = productFrom,
                onValueChange = {
                    productFrom = it
                },
                label = { Text(text = "From", color = Color.DarkGray) },
                leadingIcon = { Icon(imageVector = Icons.Default.Place, contentDescription = "placeIcon") },
                placeholder = { Text(text = "From", color = Color.DarkGray, fontSize = 10.sp) },
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = productDestination,
                leadingIcon = { Icon(imageVector = Icons.Default.Place, contentDescription = "placeIcon") },
                //trailingIcon = { Icon(imageVector = Icons.Default.Add, contentDescription = null) },
                onValueChange = {
                    productDestination = it
                },
                label = { Text(text = "Destination", color = Color.DarkGray) },
                placeholder = { Text(text = "Enter Your Destination", color = Color.DarkGray, fontSize = 10.sp) },
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = productDeparture,
                leadingIcon = { Icon(imageVector = Icons.Default.DateRange, contentDescription = "placeIcon") },
                //trailingIcon = { Icon(imageVector = Icons.Default.Add, contentDescription = null) },
                onValueChange = {
                    productDeparture = it
                },
                label = { Text(text = "Departure Date", color = Color.DarkGray) },
                placeholder = { Text(text = "Enter Departure Date", color = Color.DarkGray, fontSize = 10.sp) },
            )
            Spacer(modifier = Modifier.height(10.dp))
            OutlinedTextField(
                value = productReturndate,
                leadingIcon = { Icon(imageVector = Icons.Default.DateRange, contentDescription = "placeIcon") },
                //trailingIcon = { Icon(imageVector = Icons.Default.Add, contentDescription = null) },
                onValueChange = {
                    productReturndate = it
                },
                label = { Text(text = "Add Return", color = Color.DarkGray) },
                placeholder = { Text(text = "Enter Return Date", color = Color.DarkGray, fontSize = 10.sp) },
            )
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = {
                val productRepository = ProductViewModel(navController,context)
                productRepository.saveProduct(productFrom.text.trim(),productDestination.text.trim(),
                    productDeparture.text.trim(),productReturndate.text.trim())
                navController.navigate(ROUTE_MY_BOOKING)
            }, colors = ButtonDefaults.buttonColors(Color(0xFF00BCD400)),
                border = BorderStroke(2.dp, Color.Black)
            ) {
                Image(
                    painterResource(id = R.drawable.n2),
                    contentDescription ="button icon",
                    modifier = Modifier.size(30.dp),
                )
                Text(text = "BOOK", color = Color.Black)


            }}

    }}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun BusScreenPreview() {
    BusScreen(rememberNavController())
}