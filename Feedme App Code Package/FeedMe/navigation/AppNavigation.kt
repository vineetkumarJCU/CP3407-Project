package com.example.feedme.ui.navigation

import androidx.compose.runtime.*
import androidx.navigation.NavType
import androidx.navigation.compose.*
import androidx.navigation.navArgument
import com.example.feedme.ui.screens.*

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    var savedAddress by remember {
        mutableStateOf("No address selected")
    }

    val cartItems = remember {
        listOf(
            CartItem("Burger Combo", 18.99, 1),
            CartItem("Fries", 5.99, 2)
        )
    }

    NavHost(
        navController = navController,
        startDestination = "welcome"
    ) {
        composable("welcome") {
            WelcomeScreen(navController)
        }

        composable("login") {
            LoginScreen(navController)
        }

        composable("register") {
            RegisterScreen(navController)
        }

        composable("home") {
            HomeScreen(navController)
        }

        composable("restaurants") {
            RestaurantListScreen(navController)
        }

        composable("restaurant_detail") {
            RestaurantDetailScreen(navController)
        }

        composable("saved") {
            SavedScreen(navController)
        }

        composable("orders") {
            OrdersScreen(navController)
        }

        composable("settings") {
            SettingsScreen(navController)
        }

        // 🛒 Cart
        composable("cart") {
            CartScreen(
                cartItems = cartItems,
                onCheckoutClick = {
                    navController.navigate("checkout")
                }
            )
        }

        // 📍 Address
        composable("address") {
            DeliveryAddressScreen(
                onSave = { address ->
                    savedAddress = address
                    navController.popBackStack()
                }
            )
        }

        // 💳 Checkout
        composable("checkout") {
            CheckoutScreen(
                navController = navController,
                totalAmount = cartItems.sumOf { it.price * it.quantity },
                address = savedAddress,
                onPlaceOrder = {
                    navController.navigate("tracking")
                },
                onEditAddress = {
                    navController.navigate("address")
                }
            )
        }

        // 📦 Tracking
        composable("tracking") {
            OrderTrackingScreen(navController)
        }

        // 📊 Vendor analytics
        composable("vendor_analytics") {
            VendorAnalyticsScreen(navController)
        }

        // 🛡 Admin
        composable("admin_approval") {
            AdminApprovalScreen(navController)
        }

        // 🌱 Sustainability
        composable("sustainability") {
            SustainabilityScoreScreen(navController)
        }

        // backward compatibility route
        composable(
            route = "checkout/{restaurantName}",
            arguments = listOf(
                navArgument("restaurantName") {
                    type = NavType.StringType
                }
            )
        ) {
            CheckoutScreen(
                navController = navController,
                totalAmount = cartItems.sumOf { it.price * it.quantity },
                address = savedAddress,
                onPlaceOrder = {
                    navController.navigate("tracking")
                },
                onEditAddress = {
                    navController.navigate("address")
                }
            )
        }
    }
}