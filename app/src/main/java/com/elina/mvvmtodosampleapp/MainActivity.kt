package com.elina.mvvmtodosampleapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.elina.mvvmtodosampleapp.ui.add_edit_todo.AddEditToDoScreen
import com.elina.mvvmtodosampleapp.ui.theme.MVVMTodoSampleAppTheme
import com.elina.mvvmtodosampleapp.ui.todo_list.TodoListScreen
import com.elina.mvvmtodosampleapp.util.Routes
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVVMTodoSampleAppTheme {
                val navController = rememberNavController()
                NavHost(navController = navController,
                    startDestination = Routes.TODO_LIST) {
                    composable(Routes.TODO_LIST) {
                        TodoListScreen(onNavigate = {
                            navController.navigate(it.route)
                        })
                    }
                    composable(route = Routes.ADD_EDIT_TODO + "?todoId={todoId}",
                        arguments = listOf(
                            navArgument(name = "todoId") {
                                type = NavType.IntType
                                defaultValue = -1
                            }
                        )) {
                        AddEditToDoScreen(onPopBackStack = {
                            navController.popBackStack()
                        })
                    }
                }
            }
        }
    }
}
