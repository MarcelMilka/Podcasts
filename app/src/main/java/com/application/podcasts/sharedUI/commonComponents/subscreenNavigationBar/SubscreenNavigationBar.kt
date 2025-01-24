package com.application.podcasts.sharedUI.commonComponents.subscreenNavigationBar

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.application.podcasts.constants.Padding

@Composable
fun SubscreenNavigationBar() {

    var xIsActive by remember { mutableStateOf(true) }
    var yIsActive by remember { mutableStateOf(false) }
    var zIsActive by remember { mutableStateOf(false) }

    Row(

        modifier = Modifier
            .fillMaxWidth()
            .height(90.dp)
            .padding(
                start = Padding.BIG.dp,
                end = Padding.BIG.dp,
                top = 40.dp,
                bottom = Padding.NONE.dp
            ),

        horizontalArrangement = Arrangement.SpaceBetween,

        content = {

            LazyRow(
                modifier = Modifier
                    .height(40.dp),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically,


                content = {

                    this.item {

                        SubscreenNavigationBarButton(
                            isActive = xIsActive,
                            isEnabled = !xIsActive,
                            content = "Podcasts",
                            onClick = {

                                xIsActive = !xIsActive
                                yIsActive = !yIsActive
                            }
                        )

                        Spacer(Modifier.width(5.dp))

                        SubscreenNavigationBarButton(
                            isActive = yIsActive,
                            isEnabled = !yIsActive,
                            content = "Habit tracker",
                            onClick = {

                                yIsActive = !yIsActive
                                xIsActive = !xIsActive
                            }
                        )
                    }
                }
            )

            SubscreenNavigationBarIconButton(
                isActive = zIsActive,
                isEnabled = !zIsActive,
                onClick = {

                    zIsActive = !zIsActive
                }
            )
        }
    )
}