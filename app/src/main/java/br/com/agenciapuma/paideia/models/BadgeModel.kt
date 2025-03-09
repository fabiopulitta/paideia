package br.com.agenciapuma.paideia.models

data class BadgeModel(
    val id: Int,
    val image: String,
    val title: String,
    val owned: Boolean
)