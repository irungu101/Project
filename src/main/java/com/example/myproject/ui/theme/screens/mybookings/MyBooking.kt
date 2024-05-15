package com.example.myproject.ui.theme.screens.mybookings




import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myproject.R
import com.example.myproject.data.ProductViewModel
import com.example.myproject.models.MyBookings
import com.example.myproject.navigation.ROUTE_MY_BOOKING
import com.example.myproject.navigation.ROUTE_UPDATE_BOOKING


@Composable
fun MyBookingScreen(navController:NavHostController) {
    Column(modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(painter = painterResource(id = R.drawable.b31), contentDescription = "background image",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.matchParentSize())


            val context = LocalContext.current
            val productRepository = ProductViewModel(navController, context)
            val emptyProductState = remember { mutableStateOf(MyBookings("", "", "", "", "")) }
            val emptyProductsListState = remember { mutableStateListOf<MyBookings>() }

            val products = productRepository.viewProducts(emptyProductState, emptyProductsListState)


            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "All My Bookings",
                    fontSize = 30.sp,
                    fontFamily = FontFamily.SansSerif,
                    color = Color.White
                )

                Spacer(modifier = Modifier.height(70.dp))

                LazyColumn() {
                    items(products) {
                        ProductItem(
                            from = it.from,
                            destination = it.destination,
                            departure = it.departure,
                            returndate = it.returndate,
                            id = it.id,
                            navController = navController,
                            productRepository = productRepository
                        )
                    }
                }
            }
        }
    }

}



@Composable
fun ProductItem(from:String, destination:String, departure:String,returndate:String ,id:String,
                navController:NavHostController, productRepository:ProductViewModel) {

    Column(modifier = Modifier.fillMaxWidth()
        ,horizontalAlignment = Alignment.CenterHorizontally) {
        Card (modifier = Modifier.size(width = 150.dp, height = 200.dp), colors = CardDefaults.cardColors(Color.White),
            shape = RoundedCornerShape(17.dp), border = BorderStroke(2.dp, Color.LightGray)


        )
        {


        Text(text = from, color = Color.Black, fontSize = 17.sp)
        Text(text = destination, color = Color.Black, fontSize = 17.sp)
        Text(text = departure, color = Color.Black, fontSize = 17.sp)
        Text(text =returndate, color = Color.Black, fontSize = 17.sp)
        Button(onClick = {
            productRepository.deleteProduct(id)
            navController.navigate(ROUTE_MY_BOOKING)
        }, colors = ButtonDefaults.buttonColors(Color(0xFF00BCD400))
        ) {

            Text(text = "DELETE", fontSize = 15.sp, fontWeight = FontWeight(600))
        }
        Button(onClick = {
            navController.navigate(ROUTE_UPDATE_BOOKING+"/$id")
        }, colors = ButtonDefaults.buttonColors(Color(0xFF00BCD400)),
        ) {
            Text(text = "UPDATE", fontSize = 15.sp, fontWeight = FontWeight(600))
        }
    }
        Spacer(modifier = Modifier.height(20.dp))

}
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun ViewFlightsScreenPreview() {
    MyBookingScreen(rememberNavController())

}