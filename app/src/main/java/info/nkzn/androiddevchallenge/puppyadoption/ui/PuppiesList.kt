package info.nkzn.androiddevchallenge.puppyadoption.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import info.nkzn.androiddevchallenge.puppyadoption.Puppy
import info.nkzn.androiddevchallenge.puppyadoption.R
import info.nkzn.androiddevchallenge.puppyadoption.puppies
import info.nkzn.androiddevchallenge.puppyadoption.ui.theme.PuppyAdoptionAppTheme

@Composable
fun PuppiesListScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Puppy Adoption")
                },
            )
        }
    ) { innerPadding ->
        PuppiesListBodyContent(
            onClickGoToDetail = { id ->
                navController.navigate("detail/$id")
            },
            modifier = Modifier.padding(innerPadding)
        )
    }
}

@Composable
fun PuppiesListBodyContent(onClickGoToDetail: (id: String) -> Unit, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier
            .fillMaxSize()
            .background(color = Color.LightGray)
    ) {
        items(items = puppies) {
            PuppyCard(
                puppy = it,
                onClickPuppy = onClickGoToDetail,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}

@Composable
fun PuppyCard(puppy: Puppy, onClickPuppy: (id: String) -> Unit, modifier: Modifier = Modifier) {
    Row(
        modifier
            .padding(8.dp)
            .clip(RoundedCornerShape(4.dp))
            .background(MaterialTheme.colors.surface)
            .clickable(onClick = { onClickPuppy(puppy.id) })
            .padding(16.dp)
    ) {
        Surface(
            modifier = Modifier.size(50.dp),
            shape = CircleShape,
            color = MaterialTheme.colors.onSurface.copy(alpha = 0.2f)
        ) {
            Image(painter = painterResource(id = puppy.iconId), contentDescription = null)
        }
        Column(
            modifier = Modifier
                .padding(start = 8.dp)
                .align(Alignment.CenterVertically)
        ) {
            Text(puppy.name, fontWeight = FontWeight.Bold)
            CompositionLocalProvider(LocalContentAlpha provides ContentAlpha.medium) {
                Text("${puppy.monthsOfAge} months old", style = MaterialTheme.typography.body2)
            }
        }
    }
}

@Preview
@Composable
fun PuppiesListScreenPreview() {
    PuppyAdoptionAppTheme {
        PuppiesListBodyContent({})
    }
}

@Preview
@Composable
fun PuppyCardPreview() {
    PuppyAdoptionAppTheme {
        PuppyCard(puppy = Puppy("1", "Shiba", 14, R.drawable.dog_shibainu_brown), {})
    }
}