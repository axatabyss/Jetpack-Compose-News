package com.axat.newscompose.utils

sealed class Destination(val route: String) {

    object HomeScreen : Destination("HomeScreen")
    object NewsScreen : Destination("NewsScreen")

}
