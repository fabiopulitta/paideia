package br.com.agenciapuma.paideia.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import br.com.agenciapuma.paideia.R
import br.com.agenciapuma.paideia.components.Header

@Composable
fun LoginScreen(navController: NavController?) {

    Column(modifier = Modifier.fillMaxSize()) {
        Header(title = stringResource(id = R.string.login_title), navController)

    }
}

@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    LoginScreen(navController = null)
}