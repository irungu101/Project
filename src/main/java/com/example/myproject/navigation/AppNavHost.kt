package com.example.myproject.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myproject.ui.theme.nav.NavScreen
import com.example.myproject.ui.theme.screens.bus.BusScreen
import com.example.myproject.ui.theme.screens.flight.FlightScreen
import com.example.myproject.ui.theme.screens.train.TrainScreen
import com.example.myproject.ui.theme.screens.login.LoginScreen
import com.example.myproject.ui.theme.screens.logout.LogOutScreen
import com.example.myproject.ui.theme.screens.means.HomeScreen
import com.example.myproject.ui.theme.screens.mybookings.MyBookingScreen
import com.example.myproject.ui.theme.screens.mybookings.UpdateFlightScreen
import com.example.myproject.ui.theme.screens.register.RegisterScreen
import com.example.myproject.ui.theme.screens.welcome.WelcomeScreen

//import com.example.mvvmarchitecture.ui.theme.screens.products.AddProductsScreen
//import com.vic.mvvmarchitecture.ui.theme.screens.about.AboutScreen
//import com.vic.mvvmarchitecture.ui.theme.screens.about.Aboutscreen
//import com.vic.mvvmarchitecture.ui.theme.screens.home.HomeScreen
//import com.vic.mvvmarchitecture.ui.theme.screens.login.LoginScreen
//import com.vic.mvvmarchitecture.ui.theme.screens.products.AddProductsScreen
//import com.vic.mvvmarchitecture.ui.theme.screens.products.UpdateProductsScreen
//import com.vic.mvvmarchitecture.ui.theme.screens.products.ViewProductsScreen
//import com.vic.mvvmarchitecture.ui.theme.screens.products.ViewUploadsScreen
//import com.vic.mvvmarchitecture.ui.theme.screens.register.RegisterScreen


@Composable
fun AppNavHost(modifier: Modifier=Modifier,
               navController: NavHostController= rememberNavController(),
               startDestination: String= ROUTE_WELCOME) {
    NavHost(
        navController = navController,
        modifier = modifier,
        startDestination = startDestination
    ) {
        composable(ROUTE_WELCOME) { WelcomeScreen(navController) }
        composable(ROUTE_LOGIN){ LoginScreen(navController)}
        composable(ROUTE_REGISTER) { RegisterScreen(navController)}
        composable(ROUTE_HOME) { HomeScreen(navController) }
        composable(ROUTE_FLIGHT) { FlightScreen(navController) }
        composable(ROUTE_TRAIN) { TrainScreen(navController) }
        composable(ROUTE_BUS) { BusScreen(navController) }
        composable(ROUTE_NAV) { NavScreen(navController) }
      composable(ROUTE_MY_BOOKING) { MyBookingScreen(navController) }


        composable(ROUTE_LOGOUT) { LogOutScreen(navController) }
        composable(ROUTE_UPDATE_BOOKING+"/{id}"){
                passedData ->
            UpdateFlightScreen(
                navController,passedData.arguments?.getString("id")!!
            )
        }



//        composable(ROUTE_ADD_PRODUCT){ AddProductsScreen(navController)}
//        composable(ROUTE_VIEW_PRODUCT){ ViewProductsScreen(navController)}

//        composable(ROUTE_VIEW_UPLOAD){ViewUploadsScreen(navController)}
        //        composable(ROUTE_BOOKING_DETAIL) { BookingDetailScreen(navController) }
    }
}