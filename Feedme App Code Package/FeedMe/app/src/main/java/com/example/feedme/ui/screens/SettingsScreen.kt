package com.example.feedme.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.feedme.data.FeedMeSettings
import com.example.feedme.ui.components.FeedMeTopBar

@Composable
fun SettingsScreen(navController: NavController) {
    val bg = if (FeedMeSettings.darkMode) Color(0xFF121212) else Color(0xFFF6F6F6)
    val card = if (FeedMeSettings.darkMode) Color(0xFF1E1E1E) else Color.White
    val textColor = if (FeedMeSettings.darkMode) Color.White else Color(0xFF222222)
    val subTextColor = if (FeedMeSettings.darkMode) Color(0xFFBBBBBB) else Color(0xFF666666)
    val accent = FeedMeSettings.accentColor

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(bg)
            .navigationBarsPadding()
    ) {
        FeedMeTopBar(
            title = "Settings",
            navController = navController
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Account",
                style = MaterialTheme.typography.headlineSmall,
                fontWeight = FontWeight.Bold,
                color = textColor
            )

            Spacer(modifier = Modifier.height(16.dp))

            Surface(
                color = card,
                shape = RoundedCornerShape(18.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Surface(
                        modifier = Modifier.size(56.dp),
                        shape = CircleShape,
                        color = accent
                    ) {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = FeedMeSettings.username.firstOrNull()?.toString() ?: "F",
                                color = Color.White,
                                style = MaterialTheme.typography.headlineSmall,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = FeedMeSettings.username,
                            style = MaterialTheme.typography.titleLarge,
                            fontWeight = FontWeight.Bold,
                            color = textColor
                        )
                        Text(
                            text = "View profile",
                            style = MaterialTheme.typography.bodyMedium,
                            color = subTextColor
                        )
                    }

                    Text(
                        text = ">",
                        color = subTextColor,
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Surface(
                color = card,
                shape = RoundedCornerShape(18.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column {
                    SettingRow(
                        title = "Saved Stores",
                        subtitle = "Restaurants you saved",
                        textColor = textColor,
                        subTextColor = subTextColor,
                        onClick = { navController.navigate("saved") }
                    )

                    Divider()

                    SettingRow(
                        title = "Orders",
                        subtitle = "View your placed orders",
                        textColor = textColor,
                        subTextColor = subTextColor,
                        onClick = { navController.navigate("orders") }
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Surface(
                color = card,
                shape = RoundedCornerShape(18.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Appearance",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = textColor
                    )

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Column {
                            Text("Dark Mode", color = textColor)
                            Text(
                                if (FeedMeSettings.darkMode) "Enabled" else "Disabled",
                                color = subTextColor
                            )
                        }

                        Switch(
                            checked = FeedMeSettings.darkMode,
                            onCheckedChange = { FeedMeSettings.darkMode = it }
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))

                    Text("Accent Color", color = textColor)

                    Spacer(modifier = Modifier.height(12.dp))

                    Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                        ColorDot(Color(0xFFF4A048)) { FeedMeSettings.setOrangeTheme() }
                        ColorDot(Color(0xFF4A90E2)) { FeedMeSettings.setBlueTheme() }
                        ColorDot(Color(0xFF9B59B6)) { FeedMeSettings.setPurpleTheme() }
                        ColorDot(Color(0xFF2FC45A)) { FeedMeSettings.setGreenTheme() }
                    }
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = { FeedMeSettings.reset() },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = accent)
            ) {
                Text("Reset Settings")
            }
        }
    }
}

@Composable
private fun SettingRow(
    title: String,
    subtitle: String,
    textColor: Color,
    subTextColor: Color,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = title,
                color = textColor,
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = subtitle,
                color = subTextColor,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Text(">", color = subTextColor)
    }
}

@Composable
private fun ColorDot(
    color: Color,
    onClick: () -> Unit
) {
    Surface(
        modifier = Modifier
            .size(32.dp)
            .clip(CircleShape)
            .clickable { onClick() },
        color = color
    ) {}
}