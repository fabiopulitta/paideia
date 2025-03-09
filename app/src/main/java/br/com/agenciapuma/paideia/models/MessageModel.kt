package br.com.agenciapuma.paideia.models

data class MessageModel(
    val id: Int,
    val title: String,
    val body: String,
    val timestamp: String,
    val isRead: Boolean = false
)
