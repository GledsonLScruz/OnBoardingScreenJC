package com.example.onboardingjetpackcompose

import androidx.annotation.DrawableRes

sealed class OnBoardingPage (
    @DrawableRes
    val photo : Int,
    val title: String,
    val description: String
        ){
    object First: OnBoardingPage(
        photo = R.drawable.finance_organization,
        title = "Manage your money",
        description = "A simple way to administrate your money"
    )
    object Second: OnBoardingPage(
        photo = R.drawable.currency_flatline,
        title = "Have options",
        description = "Decide where you put your money"
    )
    object Third: OnBoardingPage(
        photo = R.drawable.cripto_ethereum,
        title = "Also Cripto",
        description = "Buy and seel cripto coins"
    )
    object Fourth: OnBoardingPage(
        photo = R.drawable.online_payment,
        title = "Pay your bills online",
        description = "pay everywhere and to everyone"
    )
}