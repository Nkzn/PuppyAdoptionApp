package info.nkzn.androiddevchallenge.puppyadoption.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import info.nkzn.androiddevchallenge.puppyadoption.puppies
import info.nkzn.androiddevchallenge.puppyadoption.ui.theme.PuppyAdoptionAppTheme

@Composable
fun PuppyDetailScreen(navController: NavController, puppyId: String?) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Puppy Detail")
                },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = null)
                    }
                }
            )
        }
    ) { innerPadding ->
        PuppyDetailBodyContent(
            id = puppyId,
            modifier = Modifier.padding(innerPadding),
        )
    }
}

@Composable
fun PuppyDetailBodyContent(id: String?, modifier: Modifier = Modifier) {
    val puppy = puppies.find { it.id == id }

    if (puppy == null) {
        Text("No data")
        return
    }

    Column(
        modifier.padding(8.dp)
    ) {
        Image(painter = painterResource(id = puppy.iconId), contentDescription = null)
        Text("Name: ${puppy.name}")
        Text("Age: ${puppy.monthsOfAge} months old")
    }

}

@Preview
@Composable
fun PuppyDetailScreenPreview() {
    PuppyAdoptionAppTheme {
        PuppyDetailBodyContent("1")
    }
}