package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionContext
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
// for a 'val' variable
import androidx.compose.runtime.getValue

// for a `var` variable also add
import androidx.compose.runtime.setValue

// or just
import androidx.compose.runtime.*
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import com.example.myapplication.ui.theme.MyApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            LoginUI(applicationContext)
        }
    }
}
@Composable
fun Mytext(text: String){
    Text(text)
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginUI(context: Context) {
    var email by remember{ mutableStateOf("")}
    var password by remember{ mutableStateOf("")}

    Column() {

        Text(text = "Login Here",
            fontFamily = FontFamily.Monospace,
            textAlign = TextAlign.Center,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Red,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 20.dp)
        )
        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            label = { Text("Enter Your mail")},
            leadingIcon = {
                Icon(Icons.Default.Person, contentDescription = "Person" )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp, start = 10.dp, end = 10.dp)
        )
        OutlinedTextField(
            value = password,
            onValueChange = {password = it},
            label = { Text("Enter Your password")},
            leadingIcon = {
                Icon(Icons.Default.Info, contentDescription = "Pasword" )
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp, top = 10.dp,start = 10.dp, end = 10.dp),
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        OutlinedButton(onClick = { logged(email,password, context) },
            modifier = Modifier.fillMaxWidth().padding(bottom = 100.dp, top = 10.dp))
        {
            Text(text = "Login",
                textAlign = TextAlign.Center)
        }
    }
}

fun logged(email: String, password: String, context: Context) {
    if (email == "andres"&& password=="12345"){
        Toast.makeText(context,"Logged in", Toast.LENGTH_SHORT).show()
    } else {
        Toast.makeText(context,"Logged in error", Toast.LENGTH_SHORT).show()
    }

}