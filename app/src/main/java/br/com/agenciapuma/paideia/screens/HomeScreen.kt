package br.com.agenciapuma.paideia.screens

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.agenciapuma.paideia.R
import br.com.agenciapuma.paideia.network.RetrofitClient

import br.com.agenciapuma.paideia.components.Header
import br.com.agenciapuma.paideia.components.FeedMessage

import br.com.agenciapuma.paideia.models.BadgeModel
import br.com.agenciapuma.paideia.models.MessageModel
import coil.compose.AsyncImage

@Composable
fun HomeScreen(navController: NavController?) {

    Column(modifier = Modifier.fillMaxSize()) {
        Header(title = "Home", navController)
        BadgesSection()
        FeedSection()
//        BottomNavigationBar()
    }
}

@Composable
fun BadgesSection() {
    var badgeList by remember { mutableStateOf<List<BadgeModel>>(emptyList()) }
    var isLoading by remember { mutableStateOf(true) }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    // Chama a API assim que a tela for exibida
    LaunchedEffect(Unit) {
        try {
            Log.d("API_CALL", "Chamando a API...")
            val response = RetrofitClient.api.getBadges()
            Log.d("API_RESPONSE", "Resposta da API: $response")
            badgeList = response
        } catch (e: Exception) {
            errorMessage = "Erro ao carregar badges"
            Log.e("API_ERROR", "Erro na API", e)
        } finally {
            isLoading = false
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Badges",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )

        when {
            isLoading -> CircularProgressIndicator()
            errorMessage != null -> Text(text = errorMessage ?: "Erro desconhecido", color = Color.Red)
            else -> BadgeList(badgeList) // Chama a lista de badges
        }
    }
}

@Composable
fun BadgeList(badges: List<BadgeModel>) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(horizontal = 16.dp)
    ) {
        items(badges) { badge ->
            BadgeItem(badge) // Cada item da lista chama `BadgeItem()`
        }
    }
}

@Composable
fun BadgeItem(badge: BadgeModel) {
    Column(
        modifier = Modifier
            .padding(8.dp)
            .background(Color.LightGray, RoundedCornerShape(12.dp))
            .padding(8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        AsyncImage(
            model = badge.image, // Carrega a imagem do backend
            contentDescription = badge.title,
            modifier = Modifier.size(64.dp)
        )
        Text(
            text = badge.title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(top = 4.dp)
        )
    }
}


@Composable
fun FeedSection() {

    val feedMessages = listOf(
        MessageModel(1, "Lucas começou a aprender React Native! 🎉", "Parabéns por iniciar essa jornada!", "Há 5 min"),
        MessageModel(2, "Fernanda compartilhou um novo artigo sobre Kotlin Compose.", "Leia agora no blog!", "Há 30 min"),
        MessageModel(3, "Você atingiu o nível 5 em Desenvolvimento Mobile. 🚀", "Continue avançando!", "Ontem"),
        MessageModel(4, "Mariana concluiu o curso de Python para Iniciantes.", "Dê os parabéns para ela!", "2 dias atrás"),
        MessageModel(5, "Novo evento: Workshop sobre UX/UI Design amanhã às 19h.", "Inscreva-se agora!", "3 dias atrás"),
        MessageModel(6, "Pedro publicou um tutorial sobre Desenvolvimento Web.", "Confira no grupo de tecnologia!", "4 dias atrás"),
        MessageModel(7, "Camila recebeu 50 curtidas no seu post sobre IA! 🔥", "Veja o que ela compartilhou.", "5 dias atrás")
    )

    var messages by remember { mutableStateOf(feedMessages) }

    fun markMessageAsRead(messageId: Int) {
        messages = messages.map {
            if (it.id == messageId) it.copy(isRead = true) else it
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.white))
            .padding(16.dp)
    ) {
        Text(
            text = "Notificações",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        FeedList(messages, ::markMessageAsRead)
    }
}

@Composable
fun FeedList(messageList: List<MessageModel>, onMessageRead: (Int) -> Unit) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        modifier = Modifier.padding(top = 2.dp, bottom = 16.dp)
    ) {
        items(messageList) { message ->
            FeedMessage(
                message = message,
                onClick = { onMessageRead(message.id) }
            )
        }
    }
}


@Preview(showSystemUi = true)
@Composable
private fun HomeScreenPreview() {
    HomeScreen(navController = null)
}