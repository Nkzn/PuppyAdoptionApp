package info.nkzn.androiddevchallenge.puppyadoption

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import info.nkzn.androiddevchallenge.puppyadoption.ui.PuppiesListScreen
import info.nkzn.androiddevchallenge.puppyadoption.ui.PuppyDetailScreen
import info.nkzn.androiddevchallenge.puppyadoption.ui.theme.PuppyAdoptionAppTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PuppyAdoptionAppTheme {
                val navController = rememberNavController()
                NavHost(navController, startDestination = "list") {
                    composable("list") { PuppiesListScreen(navController) }
                    composable("detail/{puppyId}") { backStackEntry ->
                        val puppyId = backStackEntry.arguments?.getString("puppyId")
                        PuppyDetailScreen(navController, puppyId)
                    }
                }
            }
        }
    }
}
