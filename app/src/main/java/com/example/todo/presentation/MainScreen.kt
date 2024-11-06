package com.example.todo.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.LargeTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.todo.R
import com.example.todo.ui.theme.AppRotues
import com.example.todo.ui.theme.BLue00
import com.example.todo.ui.theme.Backround
import com.example.todo.ui.theme.ToDoTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavHostController) {

    ToDoTheme {
        Scaffold(
            containerColor = Backround, //TODO: replace to theme color

            floatingActionButton = { FabButton(onClick = { navController.navigate(AppRotues.ToDoCreate) }) },
            floatingActionButtonPosition = FabPosition.End,
            topBar = {
                CustomAppBar()

            },
        ) { innerPadding ->
            BuildTodoItems(items = listOf(1, 2, 3, 4, 5), modifier = Modifier.padding(innerPadding))

        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomAppBar() {
    LargeTopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Backround //TODO: replace to theme color
        ),
        title = {
            Column {
                Text(
                    "Мои дела",
                    modifier = Modifier.padding(start = 60.dp),
                    style = TextStyle(
                        fontSize = 32.sp,
                        color = Color(0xff000000)
                    ), //TODO: replace to theme color
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = 24.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(
                        "Выполнено — 5",
                        modifier = Modifier.padding(start = 60.dp),
                        style = TextStyle(
                            fontSize = 16.sp, color = Color(
                                0x4D333333  //TODO: replace to theme color
                            )
                        )
                    )

                    IconButton(onClick = {  }) {

                       Image(painter = painterResource(id = R.drawable.eye_icon), contentDescription = "info_icon")

                    }

                }


            }
        }
    )
}


@Composable
fun BuildTodoItems(items: List<Int>, modifier: Modifier) {
    LazyColumn(
        modifier
            .fillMaxWidth()
            .padding(20.dp)
            .clip(shape = RoundedCornerShape(10.dp))
            .background(color = Color(0xFFffffff)) //TODO: replace to theme color
            .padding(20.dp)
            ,
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(items) { item ->
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.fillMaxWidth()
            ) {
                Checkbox(checked = false, onCheckedChange = {})
                Text(

                    text = "Таск:  ${item.toString()}",
                    style = TextStyle(fontSize = 18.sp, color = Color(0xFF000000))
                )

                IconButton(
                    onClick = { /*TODO*/ },
                    colors = IconButtonDefaults.iconButtonColors(contentColor = Color.Red) //TODO: replace to theme color
                ) {
                    Image(painter = painterResource(id = R.drawable.info_icon) , contentDescription = "Info" )
                }

            }
        }
    }
}

@Composable
fun FabButton(onClick: () -> Unit) {
    FloatingActionButton(
        shape = CircleShape,
        containerColor = BLue00,
        contentColor = Color.White,
        onClick = { onClick() },
    ) {
        Icon(Icons.Filled.Add, "Floating action button.")
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true, showSystemUi = false)
@Composable
fun HomeScreenPreview() {
    val navController = rememberNavController()
    NavHost(
        navController = navController, startDestination = AppRotues.MainScreen,
        builder = {
            composable(route = "MainScreen") {
                MainScreen(navController)
            }
            composable(route = "ToDo_Create") {
                TodoCreateScreen(navController)
            }
        },
    )
}
