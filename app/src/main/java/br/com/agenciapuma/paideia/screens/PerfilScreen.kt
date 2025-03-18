package br.com.agenciapuma.paideia.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.agenciapuma.paideia.R
import br.com.agenciapuma.paideia.components.Header
import br.com.agenciapuma.paideia.models.ItemModel

@Composable
fun PerfilScreen(navController: NavController?) {
    Column(modifier = Modifier.fillMaxSize()
        .background(colorResource(id = R.color.white))) {
        Header(title = "Perfil", navController)
        ProfileHeader()
        InterestsAndSkillsSection()
//        BottomNavigationBar()
    }
}

@Composable
fun ProfileHeader(){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(colorResource(id = R.color.bg_grey))
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Image(
            painter = painterResource(id = R.drawable.profile_picture),
            contentDescription = "Profile Picture",
            modifier = Modifier
                .size(48.dp)
                .clip(CircleShape)
        )
        Column (
            modifier = Modifier.padding(start = 12.dp)
        ) {
            Text(stringResource(id = R.string.profile_title), fontSize = 18.sp, color = colorResource(id = R.color.grey))
            Text(stringResource(id = R.string.profile_description), fontSize = 14.sp, color = colorResource(id = R.color.light_grey))
        }
        Spacer(modifier = Modifier.height(16.dp))
    }

    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .background(colorResource(id = R.color.bg_grey))
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        Column {
            Text(stringResource(id = R.string.profile_connections), fontSize = 18.sp, color = colorResource(id = R.color.grey))
        }
        Spacer(modifier = Modifier.height(16.dp))
    }
}

@Composable
fun InterestsAndSkillsSection() {
    val interestProfileList = listOf(
        ItemModel(1, image = "item1.png", title = "Culinária"),
        ItemModel(2, image = "item2.png", title = "Jogos"),
        ItemModel(3, image = "item3.png", title = "Mágica"),
        ItemModel(4, image = "item4.png", title = "Programação"),
        ItemModel(5, image = "item5.png", title = "Teste")
    )
    val abilityProfileList = listOf(
        ItemModel(1, image = "item1.png", title = "Programação", subtitle = "Item 1"),
        ItemModel(2, image = "item2.png", title = "Carpintaria", subtitle = "Item 2"),
        ItemModel(3, image = "item3.png", title = "Games", subtitle = "Item 3")
    )
    
    Column(modifier = Modifier.padding(16.dp)) {
        Spacer(modifier = Modifier.height(16.dp))
        Text(stringResource(id = R.string.profile_my_interests), fontSize = 16.sp, fontWeight = FontWeight.Black)
        InterestsAndSkillsGrid(interestProfileList)
        Spacer(modifier = Modifier.height(32.dp))
        Text(stringResource(id = R.string.profile_my_abilities), fontSize = 16.sp, fontWeight = FontWeight.Black)
        InterestsAndSkillsGrid(abilityProfileList)
    }
}

@Composable
fun InterestsAndSkillsGrid(list: List<ItemModel>) {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(list) { item ->
            Column {
                Box(
                    modifier = Modifier
                        .size(96.dp)
                        .background(colorResource(id = R.color.light_grey), RoundedCornerShape(16.dp))
                )
                Text(item.title,
                    modifier = Modifier
                        .padding(top = 5.dp)
                )
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun PerfilScreenPreview() {
    PerfilScreen(navController = null)
}