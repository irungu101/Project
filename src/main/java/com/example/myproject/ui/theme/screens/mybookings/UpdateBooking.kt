package com.example.myproject.ui.theme.screens.mybookings

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Button
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
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myproject.R
import com.example.myproject.data.ProductViewModel
import com.example.myproject.models.MyBookings
import com.example.myproject.navigation.ROUTE_MY_BOOKING
//import com.example.firebaseauth.data.productviewmodel
//import com.example.firebaseauth.models.Product
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdateFlightScreen(navController: NavHostController,id:String) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally)  {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(painter = painterResource(id = R.drawable.b25), contentDescription = "background image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.matchParentSize())


    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {



        var context = LocalContext.current
        var from by remember { mutableStateOf("") }
        var destination by remember { mutableStateOf("") }
        var departure by remember { mutableStateOf("") }
        var returndate by remember { mutableStateOf("") }

        var currentDataRef = FirebaseDatabase.getInstance().getReference()
            .child("Products/$id")
        currentDataRef.addValueEventListener(object: ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                var product = snapshot.getValue(MyBookings::class.java)
                from = product!!.from
                destination = product!!.destination
                departure = product!!.departure
                returndate = product!!.returndate
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(context, error.message, Toast.LENGTH_SHORT).show()
            }
        })



        Text(
            text = "Update Bookings",
            fontSize = 30.sp,
            fontFamily = FontFamily.SansSerif,
            color = Color.White,
            fontWeight = FontWeight(800),
            textAlign = TextAlign.Left

        )

        var productFrom by remember { mutableStateOf(TextFieldValue(from)) }
        var productDestination by remember { mutableStateOf(TextFieldValue(destination)) }
        var productDeparture by remember { mutableStateOf(TextFieldValue(departure)) }
        var productReturndate by remember { mutableStateOf(TextFieldValue(returndate)) }
        Spacer(modifier = Modifier.height(100.dp))
//            SLIDESHOW(FLIGHTS)
        Card {
            Image(painter = painterResource(id = R.drawable.d6), contentDescription = "background image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .size(190.dp)
                    .clip(RectangleShape)
            )
        }



        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = productFrom,
            onValueChange = { productFrom = it },
            leadingIcon = { Icon(imageVector = Icons.Default.Place, contentDescription = "placeIcon") },
            label = { Text(text = "From", color = Color.DarkGray) },
            placeholder = { Text(text = "From", color = Color.DarkGray, fontSize = 10.sp) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = productDestination,
            onValueChange = { productDestination = it },
            leadingIcon = { Icon(imageVector = Icons.Default.Place, contentDescription = "placeIcon") },
            label = { Text(text = "Destination", color = Color.DarkGray) },
            placeholder = { Text(text = "Enter Your Destination", color = Color.DarkGray, fontSize = 10.sp) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = productDeparture,
            onValueChange = { productDeparture = it },
            leadingIcon = { Icon(imageVector = Icons.Default.DateRange, contentDescription = "placeIcon") },
            label = { Text(text = "Departure", color = Color.DarkGray) },
            placeholder = { Text(text = "Enter Your Departure", color = Color.DarkGray, fontSize = 10.sp) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = productReturndate,
            onValueChange = { productReturndate = it },

            label = { Text(text = "Return Date", color = Color.DarkGray) },
            leadingIcon = { Icon(imageVector = Icons.Default.DateRange, contentDescription = "placeIcon") },
            placeholder = { Text(text = "Enter Return Date", color = Color.DarkGray, fontSize = 10.sp) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )
        Spacer(modifier = Modifier.height(20.dp))


        Button(onClick = {
            //-----------WRITE THE UPDATE LOGIC HERE---------------//
            var productRepository = ProductViewModel(navController, context)
            productRepository.updateProduct(productFrom.text.trim(),productDestination.text.trim(),
                productDeparture.text.trim(),productReturndate.text.trim(),id)
            navController.navigate(ROUTE_MY_BOOKING)

        }) {
            Text(text = "UPDATE" ,fontSize = 15.sp, fontWeight = FontWeight(600))
        }

    }}}
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun UpdateProductsScreenPreview() {
    UpdateFlightScreen(rememberNavController(), id = "")
}