package br.com.agenciapuma.paideia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.com.agenciapuma.paideia.screens.SearchScreen
import br.com.agenciapuma.paideia.screens.HomeScreen
import br.com.agenciapuma.paideia.screens.LoginScreen
import br.com.agenciapuma.paideia.screens.PerfilScreen
import br.com.agenciapuma.paideia.ui.theme.PaideiaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            PaideiaTheme {

                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = "home"
                ){
                    composable(route = "home") { HomeScreen(navController) }
                    composable(route = "perfil") { PerfilScreen(navController) }
                    composable(route = "busca") { SearchScreen(navController)  }
                    composable(route = "login") { LoginScreen(navController)  }
                }

            }
        }
    }
}