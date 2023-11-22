package com.example.breakfastapp

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconToggleButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.breakfastapp.ui.theme.MakeupTipsTheme
import androidx.compose.runtime.*
import androidx.compose.ui.draw.rotate

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MakeupTipsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MakeupScreen()
                }
            }
        }
    }
}

@Composable
fun MakeupScreen() {
    // Replace this with your data fetching logic
    val MakeupTips = sampleMakeupData()

    LazyColumn {
        items(MakeupTips) { tip ->
            MakeupTipCard(tip = tip)
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
}

@Composable
fun MakeupTipCard(tip: MakeupTip) {
    var isDescriptionVisible by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "Day ${tip.id}",
                style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Bold)
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = tip.title,
                style = MaterialTheme.typography.labelMedium
            )
            Spacer(modifier = Modifier.height(8.dp))


            Image(
                painter = painterResource(id = tip.imageRes),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(180.dp)
                    .align(Alignment.CenterHorizontally)
            )
            Spacer(modifier = Modifier.height(8.dp))
            IconToggleButton(
                checked = isDescriptionVisible,
                onCheckedChange = { isDescriptionVisible = it },
                modifier = Modifier
                    .rotate(if (isDescriptionVisible) 180f else 0f)
                    .align(Alignment.CenterHorizontally)
            ) {
                if (isDescriptionVisible) {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowUp,
                        contentDescription = null
                    )
                } else {
                    Icon(
                        imageVector = Icons.Default.KeyboardArrowDown,
                        contentDescription = null
                    )
                }
            }
            AnimatedVisibility(
                visible = isDescriptionVisible,
                enter = fadeIn(
                    initialAlpha = 0.3f,
                    animationSpec = tween(durationMillis = 300)
                ),
                exit = fadeOut(
                    animationSpec = tween(durationMillis = 300)
                )
            ) {
                Text(
                    text = tip.description,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

data class MakeupTip(
    val id: Int,
    val day: String,
    val title: String,
    val description: String,
    val imageRes: Int // This should be a drawable resource ID
)

fun sampleMakeupData(): List<MakeupTip> {
    return listOf(
        MakeupTip(
            id = 1,
            day = "Day 1",
            title = "Primer Powder",
            description = "Always start with a primer to create a smooth canvas for your makeup.",
            imageRes = R.drawable.image1
        ),
        MakeupTip(
            id = 2,
            day = "Day 2",
            title = "Perfecting the Base",
            description = "Blend your foundation well for a natural, seamless look.",
            imageRes = R.drawable.image2
        ),
        MakeupTip(
            id = 3,
            day = "Day 3",
            title = "Concealer Techniques",
            description = "Apply concealer in a triangular shape under your eyes to brighten and lift.",
            imageRes = R.drawable.image3
        ),
        MakeupTip(
            id = 4,
            day = "Day 4",
            title = "Brow Shaping",
            description = "Define your brows with short, light strokes for a natural appearance.",
            imageRes = R.drawable.image4
        ),
        MakeupTip(
            id = 5,
            day = "Day 5",
            title = "Eyeshadow Blending",
            description = "Blend eyeshadow colors seamlessly for a professional eye look.",
            imageRes = R.drawable.image5
        ),
        MakeupTip(
            id = 6,
            day = "Day 6",
            title = "Winged Eyeliner",
            description = "Master the art of winged eyeliner for a classic and bold look.",
            imageRes = R.drawable.image6
        ),
        MakeupTip(
            id = 7,
            day = "Day 7",
            title = "Mascara Magic",
            description = "Curl your lashes before applying mascara for an open-eyed effect.",
            imageRes = R.drawable.image7
        ),
        MakeupTip(
            id = 8,
            day = "Day 8",
            title = "Natural Contouring",
            description = "Use a matte bronzer to softly contour your face for a natural finish.",
            imageRes = R.drawable.image8
        ),
        MakeupTip(
            id = 9,
            day = "Day 9",
            title = "Blush Placement",
            description = "Smile and apply blush to the apples of your cheeks for a rosy glow.",
            imageRes = R.drawable.image9
        ),
        MakeupTip(
            id = 10,
            day = "Day 10",
            title = "Lip Liner Precision",
            description = "Outline your lips with a lip liner for a defined and long-lasting lip color.",
            imageRes = R.drawable.image10
        ),
        MakeupTip(
            id = 11,
            day = "Day 11",
            title = "Nude Lips Elegance",
            description = "Nude lip colors are versatile and perfect for a polished, everyday look.",
            imageRes = R.drawable.image11
        ),
        MakeupTip(
            id = 12,
            day = "Day 12",
            title = "Setting Spray Finale",
            description = "Set your makeup with a setting spray to keep it in place throughout the day.",
            imageRes = R.drawable.image12
        ),
        MakeupTip(
            id = 13,
            day = "Day 13",
            title = "Color Correcting",
            description = "Use color correctors to neutralize discolorations before applying foundation.",
            imageRes = R.drawable.image13
        ),
        MakeupTip(
            id = 14,
            day = "Day 14",
            title = "Luminous Highlighting",
            description = "Apply highlighter to the high points of your face for a radiant glow.",
            imageRes = R.drawable.image14
        ),
        MakeupTip(
            id = 15,
            day = "Day 15",
            title = "Eyebrow Gel",
            description = "Set your brows in place with a clear eyebrow gel for a polished look.",
            imageRes = R.drawable.image15
        ),
        MakeupTip(
            id = 16,
            day = "Day 16",
            title = "Monochromatic Makeup",
            description = "Experiment with monochromatic makeup for a cohesive and trendy appearance.",
            imageRes = R.drawable.image16
        ),
        MakeupTip(
            id = 17,
            day = "Day 17",
            title = "Smudged Eyeliner Look",
            description = "Embrace a smudged eyeliner look for a sultry and lived-in vibe.",
            imageRes = R.drawable.image17
        ),
        MakeupTip(
            id = 18,
            day = "Day 18",
            title = "Matte vs. Dewy Finish",
            description = "Choose between a matte or dewy finish based on your skin type and preference.",
            imageRes = R.drawable.image18
        ),
        MakeupTip(
            id = 19,
            day = "Day 19",
            title = "Gradient Lips",
            description = "Create a gradient lip by concentrating color in the center and blending outward.",
            imageRes = R.drawable.image19
        ),
        MakeupTip(
            id = 20,
            day = "Day 20",
            title = "Glitter Eyeshadow Accent",
            description = "Add a touch of glitter eyeshadow to the center of your lids for a glamorous look.",
            imageRes = R.drawable.image20
        ),
        MakeupTip(
            id = 21,
            day = "Day 21",
            title = "Bold Lipstick Confidence",
            description = "Bold lipstick shades can instantly elevate your makeup and boost confidence.",
            imageRes = R.drawable.image21
        ),
        MakeupTip(
            id = 22,
            day = "Day 22",
            title = "Tinted Moisturizer for a Light Look",
            description = "Opt for a tinted moisturizer for a light and breathable makeup option.",
            imageRes = R.drawable.image22
        ),
        MakeupTip(
            id = 23,
            day = "Day 23",
            title = "Graphic Eyeliner Experiment",
            description = "Try graphic eyeliner shapes for a creative and edgy makeup expression.",
            imageRes = R.drawable.image23
        ),
        MakeupTip(
            id = 24,
            day = "Day 24",
            title = "Makeup Remover Wipes",
            description = "Keep makeup remover wipes handy for quick and easy makeup removal.",
            imageRes = R.drawable.image24
        ),
        MakeupTip(
            id = 25,
            day = "Day 25",
            title = "Defined Cupid's Bow",
            description = "Accentuate your cupid's bow with a highlighter for a defined lip shape.",
            imageRes = R.drawable.image25
        ),
        MakeupTip(
            id = 26,
            day = "Day 26",
            title = "Soft Smoky Eyes",
            description = "Create a soft smoky eye using neutral tones for a subtle, everyday glam.",
            imageRes = R.drawable.image26
        ),
        MakeupTip(
            id = 27,
            day = "Day 27",
            title = "Glossy Lips Trend",
            description = "Embrace the glossy lips trend for a modern and youthful makeup style.",
            imageRes = R.drawable.image27
        ),
        MakeupTip(
            id = 28,
            day = "Day 28",
            title = "Double-Cleansing Routine",
            description = "Incorporate a double-cleansing routine to ensure thorough makeup removal.",
            imageRes = R.drawable.image28
        ),
        MakeupTip(
            id = 29,
            day = "Day 29",
            title = "Statement Eyebrows",
            description = "Bold, well-groomed eyebrows frame the face and make a statement.",
            imageRes = R.drawable.image29
        ),
        MakeupTip(
            id = 30,
            day = "Day 30",
            title = "Custom Lip Color",
            description = "Mix and match lip colors to create your custom shades for a unique look.",
            imageRes = R.drawable.image30
        )
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
        MakeupScreen()
}