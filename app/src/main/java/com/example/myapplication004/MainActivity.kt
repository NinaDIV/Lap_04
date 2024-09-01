package com.example.myapplication004

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyGridScope
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.*

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.filled.Star

import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.remember
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp

import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.myapplication004.ui.theme.MyApplication004Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplication004Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    GreetingCard()
                    Greeting(
                        name = "Android" ,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(innerPadding)

                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String , modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!" ,
        modifier = modifier
    )
}


@Composable
fun GreetingCard() {
    var showDialog by remember { mutableStateOf(false) }
    // Maneja el estado del texto ingresado en el TextField
    val (text, setText) = remember { mutableStateOf("") }
    // Maneja el estado del saludo mostrado
    val (greeting, setGreeting) = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        Text(
            text = "Welcome to the Course!" ,
            fontSize = 28.sp ,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Hello, Student!" ,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = text ,
            onValueChange = setText ,
            label = { Text("Enter your name") }
        )

        Spacer(modifier = Modifier.height(16.dp))
        OutlinedButton(onClick = { setGreeting("Hello, $text!") }) {
            Text("Mostrar saludo")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = greeting ,
            fontSize = 20.sp ,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth() ,
            horizontalArrangement = Arrangement.SpaceAround
        ) {
            Button(onClick = { showDialog = true }) { // Mostrar el diálogo al hacer clic en "Accept"
                Text("Accept")
            }
            Button(onClick = { showDialog = true }) { // Mostrar el diálogo al hacer clic en "Decline"
                Text("Decline")
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Image(
            painter = painterResource(id = R.drawable.muscular_bear_at_gym_vector) ,
            contentDescription = "Course Image" ,
            modifier = Modifier.size(100.dp)
        )

        if (showDialog) {
            AlertDialogExample(
                onDismiss = { showDialog = false } // Ocultar el diálogo cuando se cierra
            )
        }

    }

}


@Composable
fun AlertDialogExample(onDismiss: () -> Unit) {
    AlertDialog(
        onDismissRequest = { onDismiss() },
        title = { Text("Confirmación") },
        text = { Text("¿Estás seguro de que deseas continuar?") },
        confirmButton = {
            Button(onClick = { onDismiss() }) {
                Text("Sí")
            }
        },
        dismissButton = {
            Button(onClick = { onDismiss() }) {
                Text("No")
            }
        }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {

    GreetingCard()

}


