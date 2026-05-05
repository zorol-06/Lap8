package com.example.lap8

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth

@Composable
fun HomeScreen(navController: NavController) {
    val offset = Offset(5.0f, 6.0f)

    // Box cho phép xếp chồng ảnh nền
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        // Ảnh nền (đặt dưới cùng)
        Image(
            painter = painterResource(id = R.drawable.man),
            contentDescription = "man",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )

        // Nội dung chính (đặt trên ảnh nền)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF1C137).copy(alpha = 0.85f)), // Thêm độ trong suốt để nhìn thấy ảnh nền
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(50.dp))

            // Tiêu đề PIZZERIA
            Text(
                text = "PIZZERIA",
                style = TextStyle(
                    fontSize = 38.sp,
                    color = Color(0xFFD32C2C),
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 9.sp,
                    shadow = Shadow(
                        color = Color.Black,
                        offset = offset,
                        blurRadius = 0.5f
                    )
                )
            )

            Spacer(modifier = Modifier.height(30.dp))

            // Slogan
            Text(
                text = "Delivering \nDeliciousness right\nto your door!",
                fontSize = 32.sp,
                letterSpacing = 1.sp,
                lineHeight = 35.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            // Icon 3 chấm
            Image(
                painter = painterResource(id = R.drawable._cham),
                contentDescription = "3doc",
                modifier = Modifier.size(60.dp)
            )

            Spacer(modifier = Modifier.height(20.dp))

            // Nút START ORDER
            Button(
                onClick = { /* Xử lý bắt đầu đơn hàng */ },
                shape = RoundedCornerShape(35.dp),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 15.dp,
                    pressedElevation = 6.dp
                ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFB90020)
                ),
                border = BorderStroke(0.5.dp, Color.Red)
            ) {
                Text(
                    text = "START ORDER",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
            }

            Spacer(modifier = Modifier.height(58.dp))

            // Nút Sign Out
            Button(
                onClick = {
                    val firebaseAuth = FirebaseAuth.getInstance()
                    firebaseAuth.signOut()
                    navController.navigate(Screen.Signin.route) {
                        // Xoá back stack để không thể quay lại Home sau khi logout
                        popUpTo(Screen.Home.route) { inclusive = true }
                    }
                },
                shape = RoundedCornerShape(35.dp),
                elevation = ButtonDefaults.buttonElevation(
                    defaultElevation = 15.dp,
                    pressedElevation = 6.dp
                ),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFB90020)
                ),
                border = BorderStroke(0.5.dp, Color.Red)
            ) {
                Text(
                    text = "SignOut",
                    fontWeight = FontWeight.Bold,
                    fontSize = 15.sp
                )
            }

            // Khoảng trống cuối (tuỳ chỉnh)
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}