import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import bottombar.BottomBarScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import cafe.adriel.voyager.navigator.lifecycle.NavigatorLifecycleStore
import cafe.adriel.voyager.transitions.FadeTransition
import cafe.adriel.voyager.transitions.ScaleTransition
import cafe.adriel.voyager.transitions.SlideTransition
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import navigationexamplekmp.composeapp.generated.resources.Res
import navigationexamplekmp.composeapp.generated.resources.compose_multiplatform

@Composable
@Preview
fun App() {
    MaterialTheme {
    Navigator(screen = MainScreen()) { navigator ->
        //TIPOS DE TRANSICIONES
        SlideTransition(navigator)
        //FadeTransition(navigator)
        //ScaleTransition(navigator)
        }
    }
}

class MainScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = {
                navigator.push(SecondScreen())
            }){
                Text("Navegacion basica")
            }
        }
            Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            navigator.push(BottomBarScreen())
        }){
            Text("BottomBar")
        }

    }
}

class SecondScreen : Screen {
    @Composable
    override fun Content(){
        val navigator = LocalNavigator.currentOrThrow
        Column(modifier = Modifier.fillMaxSize().background(Color.Gray),
            horizontalAlignment = Alignment.CenterHorizontally) {
            Text("Segunda Pantalla", fontSize = 25.sp, color = Color.White)
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                navigator.pop()
            }){
                Text("Volver")
            }
        }
    }
}
