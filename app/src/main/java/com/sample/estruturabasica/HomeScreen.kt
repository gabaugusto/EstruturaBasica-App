package com.sample.estruturabasica

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.sample.estruturabasica.R

@Composable
fun HomeScreen(navController: NavController) {
    Scaffold(
        topBar = {
            CustomTopAppBar(
                title = "Home",
                navigationIcon = Icons.Default.Home,
                showBackButton = false
            )
        },
        bottomBar = {
            BottomAppBar {
                BottomNavItem(
                    icon = Icons.Default.Home,
                    label = "Home",
                    isSelected = true,
                    onClick = { /* Já estamos na home */ }
                )
                BottomNavItem(
                    icon = Icons.Default.Info,
                    label = "Sobre",
                    isSelected = false,
                    onClick = { navController.navigate(Screen.About.route) }
                )
                BottomNavItem(
                    icon = Icons.Default.Email,
                    label = "Contato",
                    isSelected = false,
                    onClick = { navController.navigate(Screen.Contact.route) }
                )
            }
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            Text("Bem-vindo ao App!")
        }
    }
}

@Composable
fun BottomNavItem(
    icon: ImageVector,
    label: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    IconButton(onClick = onClick) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = if (isSelected) MaterialTheme.colorScheme.primary
            else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
        )
    }
}