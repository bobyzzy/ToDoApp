package com.example.todo.presentation

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.todo.R
import com.example.todo.ui.theme.Backround
import com.example.todo.ui.theme.ToDoTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TodoCreateScreen(navController: NavHostController) {
    var textValue: String by remember {
        mutableStateOf(value = "")
    }
    var switchValue: Boolean by remember {
        mutableStateOf(value = false)
    }
    ToDoTheme {
        Scaffold(
            containerColor = Backround, // TODO: Replace to theme Data
            topBar = {

                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Backround //TODO: replace to theme color
                    ),
                    title = {},
                    actions = {
                        TextButton(onClick = { }) {
                            Text("Сохранить")
                        }
                    },
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Image(
                                painter = painterResource(id = R.drawable.x_icon),
                                contentDescription = "x_icon"
                            )
                        }
                    }
                )

            },
        ) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                Column(modifier = Modifier.padding(20.dp)) {
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(130.dp)
                            .border(
                                width = 0.dp,
                                color = Color.White,
                                shape = RoundedCornerShape(8.dp)
                            ),
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedContainerColor = Color.White,
                            focusedContainerColor = Color.White,
                            unfocusedBorderColor = Color.White,
                            focusedBorderColor = Color.White,
                        ),
                        placeholder = {
                            Text("Что надо сделать...")
                        },

                        maxLines = 20,
                        value = textValue,
                        onValueChange = {
                            textValue = it
                        },
                    )

                    Text("Важность", modifier = Modifier.padding(top = 20.dp))
                    Text(
                        "нет",
                        modifier = Modifier.padding(top = 10.dp),
                        style = TextStyle(color = Color.Gray)
                    )
                    Divider(modifier = Modifier.padding(vertical = 15.dp))
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 20.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text("Сделать до")
                        Switch(checked = switchValue, onCheckedChange = {
                            switchValue = it
                        })
                    }
                }
            }


        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Preview(showBackground = true, showSystemUi = false)
@Composable
fun ToDoCreatePreview() {
    val navController = rememberNavController()
    ToDoTheme {
        Scaffold(
            containerColor = Backround, // TODO: Replace to theme Data
            topBar = {

                TopAppBar(
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Backround //TODO: replace to theme color
                    ),
                    title = {},
                    actions = {
                        TextButton(onClick = { }) {
                            Text("Сохранить")
                        }
                    },
                    navigationIcon = {
                        IconButton(onClick = { navController.popBackStack() }) {
                            Image(
                                painter = painterResource(id = R.drawable.x_icon),
                                contentDescription = "x_icon"
                            )
                        }
                    }
                )

            },
        ) { innerPadding ->
            Box(modifier = Modifier.padding(innerPadding)) {
                Column(modifier = Modifier.padding(20.dp)) {
                    OutlinedTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .border(
                                width = 0.dp,
                                color = Color.White,
                                shape = RoundedCornerShape(8.dp)
                            ),
                        colors = OutlinedTextFieldDefaults.colors(
                            unfocusedContainerColor = Color.White,
                        ),
                        maxLines = 20,
                        value = "text",
                        onValueChange = {},
                    )
                }
            }


        }
    }
}