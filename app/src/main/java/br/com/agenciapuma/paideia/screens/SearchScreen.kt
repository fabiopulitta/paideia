package br.com.agenciapuma.paideia.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
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
fun SearchScreen(navController: NavController?) {
    Column(modifier = Modifier.fillMaxSize()
        .background(colorResource(id = R.color.white))) {
        Header(title = stringResource(id = R.string.search_title), navController)
        SearchForm()
        InterestsAndSkillsSearch()
//        BottomNavigationBar()
    }
}

@Composable
fun SearchForm(){
    Column( modifier = Modifier
        .fillMaxWidth()
    ) {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .background(colorResource(id=R.color.trans_purple))
            ,value = "Digite sua search",
            onValueChange = {},
            label = {
                Text(
                    text = "O que procura?",
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Black
                )
            }
        )
    }
}

val interestList = listOf(
    ItemModel(1, image = "item1.png", title = "Item 1", subtitle = "Item 1"),
    ItemModel(2, image = "item2.png", title = "Item 2", subtitle = "Item 2"),
    ItemModel(3, image = "item3.png", title = "Item 3", subtitle = "Item 3"),
    ItemModel(4, image = "item4.png", title = "Item 4", subtitle = "Item 4"),
    ItemModel(5, image = "item5.png", title = "Item 5", subtitle = "Item 5")
)
val abilityList = listOf(
    ItemModel(1, image = "item1.png", title = "Item 1", subtitle = "Item 1"),
    ItemModel(2, image = "item2.png", title = "Item 2", subtitle = "Item 2"),
    ItemModel(3, image = "item3.png", title = "Item 3", subtitle = "Item 3"),
    ItemModel(4, image = "item4.png", title = "Item 4", subtitle = "Item 4"),
    ItemModel(5, image = "item5.png", title = "Item 5", subtitle = "Item 5")
)

@Composable
fun InterestsAndSkillsSearch() {
    Column(modifier = Modifier.padding(16.dp)) {
        Spacer(modifier = Modifier.height(16.dp))
        Text( stringResource(id = R.string.search_interest_based), fontSize = 16.sp, fontWeight = FontWeight.Black)
        InterestsAndSkillsSearchGrid(interestList)
        Spacer(modifier = Modifier.height(32.dp))
        Text( stringResource(id = R.string.search_suggestions), fontSize = 16.sp, fontWeight = FontWeight.Black)
        InterestsAndSkillsSearchGrid(abilityList)
    }
}

@Composable
fun InterestsAndSkillsSearchGrid(list: List<ItemModel>) {

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
                        .width(130.dp)
                        .height(180.dp)
                        .background(colorResource(id = R.color.trans_purple), RoundedCornerShape(16.dp))
                        .padding(10.dp)
                ){
                    Column (
                    ){
                        Image(
                            painter = painterResource(id = R.drawable.profile_picture),
                            contentDescription = "Imagem de perfil",
                            modifier = Modifier
                                .height(116.dp)
                                .width(116.dp)
                                .clip(RoundedCornerShape(15.dp))
                        )
                        Text(item.title,
                            modifier = Modifier
                                .padding(top = 5.dp),
                            color = colorResource(id = R.color.white),
                            fontSize = 14.sp
                        )
                        item.subtitle?.let {
                            Text(
                                it,
                                color = colorResource(id = R.color.white),
                                fontSize = 12.sp
                            )
                        }
                    }

                }

            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
private fun SearchScreenPreview() {
    SearchScreen(navController = null)
}