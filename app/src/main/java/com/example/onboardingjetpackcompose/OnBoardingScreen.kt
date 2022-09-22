package com.example.onboardingjetpackcompose

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.BlurEffect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.google.accompanist.pager.*
import com.skydoves.landscapist.CircularReveal
import com.skydoves.landscapist.glide.GlideImage

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun DefaultPreview() {
    ProfileScreen()
}

@OptIn(ExperimentalPagerApi::class, ExperimentalAnimationApi::class)
@Composable
fun ProfileScreen() {

    val pages = listOf(
            OnBoardingPage.First,
            OnBoardingPage.Second,
            OnBoardingPage.Third,
            OnBoardingPage.Fourth
    )
    val pagerState = rememberPagerState()

    Box(modifier = Modifier.background(Color.Black)) {
        Image(
                painter = painterResource(id = R.drawable.bg),
                contentDescription = "background",
                modifier = Modifier
                        .fillMaxSize()
                        .blur(30.dp)
                        .alpha(0.7F),
                contentScale = ContentScale.Crop,
        )
        Column(
                modifier = Modifier
                        .fillMaxSize()
        ) {
            HorizontalPager(
                    modifier = Modifier.weight(10F),
                    count = pages.size,
                    state = pagerState,
                    verticalAlignment = Alignment.Top
            ) { position ->
                PagerScreen(onBoardingPage = pages[position])
            }
            HorizontalPagerIndicator(
                    modifier = Modifier
                            .weight(1F)
                            .align(Alignment.CenterHorizontally),
                    pagerState = pagerState
            )
            FinishButton(
                    modifier = Modifier.weight(1f),
                    pagerState = pagerState
            ) { }
        }
    }


}

@Composable
fun PagerScreen(onBoardingPage: OnBoardingPage) {
    Column(
            modifier = Modifier
                    .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
    ) {
        Image(
                modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .fillMaxHeight(0.7f),
                painter = painterResource(id = onBoardingPage.photo),
                contentDescription = "Pager Image"
        )
        Text(
                modifier = Modifier
                        .fillMaxWidth(),
                text = onBoardingPage.title,
                fontSize = MaterialTheme.typography.h4.fontSize,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center,
                color = Color.White
        )
        Text(
                modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 40.dp)
                        .padding(top = 20.dp),
                text = onBoardingPage.description,
                fontSize = MaterialTheme.typography.subtitle1.fontSize,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center,
                color = Color.LightGray
        )
    }
}

@ExperimentalAnimationApi
@ExperimentalPagerApi
@Composable
fun FinishButton(
        modifier: Modifier,
        pagerState: PagerState,
        onClick: () -> Unit
) {
    Row(
            modifier = modifier
                    .padding(horizontal = 40.dp),
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.Center
    ) {
        AnimatedVisibility(
                modifier = Modifier.fillMaxWidth(),
                visible = pagerState.currentPage == 3
        ) {
            Button(
                    onClick = onClick,
                    colors = ButtonDefaults.buttonColors(
                            contentColor = Color.White
                    )
            ) {
                Text(text = "Finish")
            }
        }
    }
}



