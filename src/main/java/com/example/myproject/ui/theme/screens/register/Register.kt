package com.example.myproject.ui.theme.screens.register

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Arrangement.Absolute.spacedBy
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.LineBreak
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.myproject.R
import com.example.myproject.data.AuthViewModel
import com.example.myproject.navigation.ROUTE_HOME
import com.example.myproject.navigation.ROUTE_LOGIN
import com.example.myproject.navigation.ROUTE_REGISTER

@Composable
fun RegisterScreen(navController: NavController){
    var email by remember { mutableStateOf(TextFieldValue("")) }
    var pass by remember { mutableStateOf(TextFieldValue("")) }
    var confirmpass by remember { mutableStateOf(TextFieldValue("")) }
    var context= LocalContext.current
    Box(modifier = Modifier.fillMaxSize()) {
        Image(painter = painterResource(id = R.drawable.screen), contentDescription = "background image",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier.matchParentSize())
        Column {
            Row {
                Text(
                    "Hello",
                    fontSize = 28.sp,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Left,
                    fontWeight = FontWeight(400),
                    color = Color.White

                )
            }
            Row {
                Text(
                    "Sign Up!",
                    fontSize = 42.sp,
                    fontFamily = FontFamily.SansSerif,
                    textAlign = TextAlign.Left,
                    fontWeight = FontWeight(400),
                    color = Color.White

                )
            }
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




        Spacer(modifier = Modifier.height(250.dp))

        OutlinedTextField(value =email ,
            onValueChange = {email=it},
            label = { Text(text = "Enter Email", color = Color.DarkGray) },
            leadingIcon = { Icon(imageVector = Icons.Default.Email, contentDescription = "placeIcon") },
                            placeholder = { Text(text = "Enter Your Email", color = Color.DarkGray, fontSize = 10.sp) },

            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)



            )
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(value =pass , onValueChange = {pass=it},
            label = { Text(text = "Enter Password", color = Color.DarkGray) },
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "placeIcon") },
            placeholder = { Text(text = "Enter Your Password", color = Color.DarkGray, fontSize = 10.sp) },

            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        OutlinedTextField(value =confirmpass , onValueChange = {confirmpass=it},
            label = { Text(text = "Confirm Password", color = Color.DarkGray) },
            leadingIcon = { Icon(imageVector = Icons.Default.Lock, contentDescription = "placeIcon") },
            placeholder = { Text(text = "Confirm Your Password", color = Color.DarkGray, fontSize = 10.sp) },

            keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Next),
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {

            val signup= AuthViewModel(navController, context )
            signup.signup(email.text.trim(),pass.text.trim(),confirmpass.text.trim())
            navController.navigate(ROUTE_HOME)
        }, modifier = Modifier.padding(10.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF00BCD4))) {
            Text(text = "Sign Up")
        }
        Spacer(modifier = Modifier.height(10.dp))

        Button(onClick = {
            navController.navigate(ROUTE_LOGIN)
        }, modifier = Modifier.padding(10.dp),
            colors = ButtonDefaults.buttonColors(Color(0xFF00BCD4))) {
            Text(text = "Have an account? Click to Login")
        }

    }

}
@Preview(showSystemUi = true, showBackground = true)
@Composable
fun RegisterScreenPreview() {
    RegisterScreen(rememberNavController())
}