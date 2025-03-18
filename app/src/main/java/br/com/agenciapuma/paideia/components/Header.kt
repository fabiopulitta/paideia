package br.com.agenciapuma.paideia.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import br.com.agenciapuma.paideia.R
import br.com.agenciapuma.paideia.screens.HomeScreen

@Composable
fun Header(title: String, navController: NavController?) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                colorResource(id = R.color.primary)
            )
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, bottom = 16.dp, start = 16.dp, end = 6.dp)
        ) {
            Text(
                text = title.uppercase() + " - " + stringResource(id = R.string.app_name).uppercase(),
                color = Color.White,
                fontSize = 12.sp
            )
            IconButton(
                onClick = { /* Ação do menu */ }) {
                Icon(
                    Icons.Filled.Menu, contentDescription = "Menu",
                    tint = colorResource(id = R.color.secondary)
                )
            }
        }

            Row{
                Button(onClick = {
                    navController?.navigate("home")
                }) {
                    Text("Home")
                }
                Button(onClick = {
                    navController?.navigate("busca")
                }) {
                    Text("Busca")
                }
                Button(onClick = {
                    navController?.navigate("perfil")
                }) {
                    Text("Perfil")
                }
                Button(onClick = {
                    navController?.navigate("login")
                }) {
                    Text("Login")
                }
            }

    }
}


@Preview(showSystemUi = true)
@Composable
private fun HeaderPreview() {
    Header("Paideia", null)
}