package com.compose.nutrisportapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform