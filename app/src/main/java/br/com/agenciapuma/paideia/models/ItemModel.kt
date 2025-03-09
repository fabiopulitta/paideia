package br.com.agenciapuma.paideia.models

data class ItemModel(
    val id: Int,
    val image: String,
    val title: String,
    val subtitle: String? = null
)
