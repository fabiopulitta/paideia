package br.com.agenciapuma.paideia.network

import br.com.agenciapuma.paideia.models.BadgeModel
import retrofit2.http.GET

interface BadgeApi {
    @GET("badges")
    suspend fun getBadges(): List<BadgeModel>
}
