package bottombar

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.TabDisposable
import cafe.adriel.voyager.navigator.tab.TabNavigator

class BottomBarScreen : Screen {
    @Composable
    override fun Content() {
        TabNavigator(
        HomeTab,
            tabDisposable = {
                TabDisposable(
                    it,
                    listOf(HomeTab,FavTab,ProfileTab)
                )
            }
        ) {
            Scaffold (
                topBar = {
                    TopAppBar(title = { Text(it.current.options.title) })
                },
                bottomBar = {
                    BottomNavigation {
                        val tabNavigation = LocalTabNavigator.current
                        BottomNavigationItem(
                            selected = tabNavigation.current.key == HomeTab.key,
                            label = { Text(HomeTab.options.title) },
                            icon = {
                                Icon(painter = HomeTab.options.icon!!,
                                    contentDescription = null) },
                            onClick = { tabNavigation.current = HomeTab }
                        )


                        BottomNavigationItem(
                            selected = tabNavigation.current.key == FavTab.key,
                            label = { Text(FavTab.options.title) },
                            icon = {
                                Icon(painter = FavTab.options.icon!!,
                                    contentDescription = null) },
                            onClick = { tabNavigation.current = FavTab }
                        )

                        BottomNavigationItem(
                            selected = tabNavigation.current.key == ProfileTab.key,
                            label = { Text(ProfileTab.options.title) },
                            icon = {
                                Icon(painter = ProfileTab.options.icon!!,
                                    contentDescription = null) },
                            onClick = { tabNavigation.current = ProfileTab }
                        )
                    }
                }, content = { CurrentTab() }
            )
        }
    }

}