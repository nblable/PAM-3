package com.example.myfirstkmpapp

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.School
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import myfirstkmpapp.composeapp.generated.resources.Res
import myfirstkmpapp.composeapp.generated.resources.nabilacantik
import org.jetbrains.compose.resources.painterResource

val PinkPrimary = Color(0xFFD81B60)
val PinkSecondary = Color(0xFFF06292)
val LinkedInBg = Color(0xFFF3F2EF)
val TextBlack = Color(0xFF191919)
val TextGray = Color(0xFF666666)

val PinkColorScheme = lightColorScheme(
    primary = PinkPrimary,
    onPrimary = Color.White,
    secondary = PinkSecondary,
    background = LinkedInBg,
    surface = Color.White,
    surfaceVariant = Color(0xFFF8F8F8)
)

@Composable
@Preview
fun App() {
    MaterialTheme(colorScheme = PinkColorScheme) {
        ProfileScreen()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen() {
    var isBioVisible by remember { mutableStateOf(true) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        "My Profile",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.White,
                    titleContentColor = PinkPrimary
                )
            )
        },
        containerColor = LinkedInBg
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Card(
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
                shape = RoundedCornerShape(topStart = 0.dp, topEnd = 0.dp, bottomStart = 12.dp, bottomEnd = 12.dp),
                modifier = Modifier.fillMaxWidth().padding(bottom = 8.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {

                    ProfileHeader(
                        name = "nblable",
                        role = "CEO Sate Taichan"
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    Row(
                        horizontalArrangement = Arrangement.spacedBy(8.dp),
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Button(
                            onClick = { isBioVisible = !isBioVisible },
                            shape = RoundedCornerShape(50),
                            modifier = Modifier.weight(1f),
                            colors = ButtonDefaults.buttonColors(containerColor = PinkPrimary)
                        ) {
                            Text(if (isBioVisible) "Close Bio" else "Open Bio")
                        }

                        OutlinedButton(
                            onClick = { /* Message Action */ },
                            shape = RoundedCornerShape(50),
                            border = androidx.compose.foundation.BorderStroke(1.dp, PinkPrimary),
                            modifier = Modifier.weight(1f)
                        ) {
                            Text("Message", color = PinkPrimary, fontWeight = FontWeight.Bold)
                        }
                    }
                }
            }

            AnimatedVisibility(visible = isBioVisible) {
                Card(
                    colors = CardDefaults.cardColors(containerColor = Color.White),
                    elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
                    modifier = Modifier.fillMaxWidth().padding(vertical = 4.dp, horizontal = 0.dp)
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(
                            text = "YTTA",
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold,
                            color = TextBlack
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            text = "Nabila cantik pengen pake pashmina vischose tapi takut botak",
                            style = MaterialTheme.typography.bodyMedium,
                            color = TextBlack,
                            textAlign = TextAlign.Left
                        )
                    }
                }
            }

            Card(
                colors = CardDefaults.cardColors(containerColor = Color.White),
                elevation = CardDefaults.cardElevation(defaultElevation = 1.dp),
                modifier = Modifier.fillMaxWidth().padding(top = 8.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Kalo Mau Tau",
                        style = MaterialTheme.typography.titleMedium,
                        fontWeight = FontWeight.Bold,
                        color = TextBlack
                    )
                    Spacer(modifier = Modifier.height(16.dp))

                    InfoRowItem(Icons.Default.Email, "Email", "nabila.123140062@student.itera.ac.id")
                    Divider(color = Color(0xFFEEEEEE), modifier = Modifier.padding(vertical = 12.dp))

                    InfoRowItem(Icons.Default.AccountBox, "Instagram", "@nblramadhanii")
                    Divider(color = Color(0xFFEEEEEE), modifier = Modifier.padding(vertical = 12.dp))

                    InfoRowItem(Icons.Default.School, "Education", "Institut Teknologi Sumatera")
                }
            }

            Spacer(modifier = Modifier.height(32.dp))
        }
    }
}

@Composable
fun ProfileHeader(
    name: String,
    role: String
) {
    Row(
        verticalAlignment = Alignment.Top,
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .size(88.dp)
                .clip(CircleShape)
                .border(2.dp, PinkPrimary, CircleShape)
        ) {
            Image(
                painter = painterResource(Res.drawable.nabilacantik),
                contentDescription = "Profile Photo",
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                color = TextBlack
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = role,
                style = MaterialTheme.typography.bodyMedium,
                color = TextBlack,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "Tapi aku lagi di Tomoro Coffee",
                style = MaterialTheme.typography.bodySmall,
                color = TextGray
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = "500+ connections",
                style = MaterialTheme.typography.labelMedium,
                color = PinkPrimary,
                fontWeight = FontWeight.Bold
            )
        }
    }
}

@Composable
fun InfoRowItem(
    icon: ImageVector,
    label: String,
    value: String
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = icon,
            contentDescription = label,
            tint = TextGray,
            modifier = Modifier.size(24.dp)
        )

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(
                text = label,
                style = MaterialTheme.typography.labelSmall,
                color = TextGray
            )
            Text(
                text = value,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium,
                color = PinkPrimary
            )
        }
    }
}