package com.example.loginandnavigate.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.FilterList
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.loginandnavigate.ui.theme.Primary
import com.example.loginandnavigate.R
import com.example.loginandnavigate.core.model.PopularItem
import com.example.loginandnavigate.ui.theme.colorBlack
import com.example.loginandnavigate.ui.theme.colorWhite

@Composable
fun HomeScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        SearchBar()
        Spacer(modifier = Modifier.height(20.dp))
        CategoriesSection()
        Spacer(modifier = Modifier.height(20.dp))
        PopularSection()
        Spacer(modifier = Modifier.height(20.dp))
        OfferDealSection()
    }
}

@Composable
fun SearchBar() {
    var searchText by remember { mutableStateOf("") }

    TextField(
        value = searchText,
        onValueChange = { searchText = it },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = WindowInsets.statusBars.asPaddingValues().calculateTopPadding()), // Prevent overlap
        placeholder = { Text("Search food...", color = Color.White) },
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = "Search Icon") },
        trailingIcon = { Icon(Icons.Default.FilterList, contentDescription = "Filter") },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.White,
            unfocusedContainerColor = Primary
        ),
        shape = RoundedCornerShape(20.dp)
    )
}

@Composable
fun CategoriesSection() {
    val categories = listOf("Burgers", "Pizza", "Healthy")

    Column {
        Text(text = "Categories", fontWeight = FontWeight.Bold, fontSize = 18.sp)

        LazyRow {
            items(categories) { category ->
                Box(
                    modifier = Modifier
                        .padding(8.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(Primary)
                        .padding(16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Text(text = category, color = Color.White)
                }
            }
        }
    }
}

@Composable
fun PopularSection() {
    val popularItems = listOf(
        PopularItem(R.drawable.pizza, "pizza", "Burger King","$", "1.25"),
        PopularItem(R.drawable.icecream, "Ice cream", "Ibaco ","$", "1.45"),
        PopularItem(R.drawable.burger, "Chicken Burger", "Burger King", "$", "4.25"),
        PopularItem(R.drawable.burger2, "Beef Burger", "Shake Shack", "$", "3.45"),
        PopularItem(R.drawable.salad, "salad", "salad","$", "1.45")
    )

    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "Popular now 🔥",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = Modifier.padding(bottom = 8.dp)
        )

        LazyRow(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            items(popularItems) { item ->
                PopularCard(item)
            }
        }
    }
}

@Composable
fun PopularCard(item: PopularItem) {
    Box(
        modifier = Modifier
            .width(180.dp)
            .wrapContentHeight()
            .clip(RoundedCornerShape(16.dp))
            .border(1.dp, Primary)
            .padding(8.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(12.dp)),
                painter = painterResource(item.imageRes),
                contentDescription = "Food Image",
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = item.title,
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.Black
            )

            Text(
                text = item.subTitle,
                fontSize = 14.sp,
                color = Color.Gray
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "${item.priceTag}${item.price}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = Primary
                )

                Box(
                    modifier = Modifier
                        .size(32.dp)
                        .clip(CircleShape)
                        .background(Primary)
                        .clickable { },
                    contentAlignment = Alignment.Center
                ) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add",
                        tint = Color.White
                    )
                }
            }
        }
    }
}

@Composable
fun OfferDealSection() {
    val offerDeals = listOf(
        PopularItem(R.drawable.burger, "Chicken Burger", "Burger King","$", "1.25"),
        PopularItem(R.drawable.burger2, "Beef Burger", "Shake Shack","$", "1.45"),
        PopularItem(R.drawable.pizza, "pizza", "Burger King","$", "1.25"),
        PopularItem(R.drawable.icecream, "Ice cream", "Ibaco ","$", "1.45"),
        PopularItem(R.drawable.salad, "salad", "salad","$", "1.45")
    )

    Column {
        Text(
            text = "Offer & Deal 😄",
            style = MaterialTheme.typography.titleLarge, // Corrected for Material3
            color = colorBlack
        )

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            items(offerDeals) { deal ->
                Box(
                    modifier = Modifier
                        .width(200.dp)
                        .wrapContentHeight()
                        .padding(10.dp)
                        .clip(RoundedCornerShape(24.dp))
                        .border(width = 1.dp, color = Primary)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Image(
                            modifier = Modifier.size(100.dp),
                            painter = painterResource(deal.imageRes),
                            contentDescription = "",
                            contentScale = ContentScale.Fit
                        )

                        Text(
                            text = deal.title,
                            fontWeight = FontWeight.Bold,
                            style = MaterialTheme.typography.titleLarge,
                            color = colorBlack
                        )

                        Text(
                            text = deal.subTitle,
                            fontWeight = FontWeight.Normal,
                            style = MaterialTheme.typography.bodyMedium,
                            color = Color.Gray
                        )

                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(20.dp),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Text(
                                text = buildAnnotatedString {
                                    withStyle(style = SpanStyle(Primary, fontWeight = FontWeight.Bold)) {
                                        append(deal.priceTag)
                                    }
                                    withStyle(style = SpanStyle(Primary)) {
                                        append(deal.price)
                                    }
                                },
                                style = MaterialTheme.typography.titleLarge
                            )

                            Box(
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .background(Primary)
                                    .padding(4.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                Icon(
                                    modifier = Modifier.size(20.dp),
                                    imageVector = Icons.Default.Add,
                                    contentDescription = "Add",
                                    tint = colorWhite
                                )
                            }
                        }
                    }
                }
            }
        }

        Spacer(modifier = Modifier.height(50.dp))
    }
}





@Preview
@Composable
private fun homeoo() {
    HomeScreen()
}