package com.app.dayregistry.components

import android.app.Activity
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material3.AssistChip
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.dayregistry.ui.theme.Roboto


@Composable
fun TitleText(
    modifier: Modifier = Modifier,
    text: String
){
    Text(
        modifier = Modifier,
        text = text,
        style = TextStyle(
            fontFamily = Roboto,
            fontWeight = FontWeight.Bold,
            fontSize = 35.sp
        )
    )
}

@Composable
fun MiniTextWithIcon(
    modifier: Modifier = Modifier,
    text: String,
    icon: Int
){
    val myId = "inlineContent"
    val wholeText = buildAnnotatedString {
        appendInlineContent(myId, "[icon]")
        append(text)
    }

    val inlineContent = mapOf(
        Pair(
            myId,
            InlineTextContent(
                Placeholder(
                    width = 25.sp,
                    height = 25.sp,
                    placeholderVerticalAlign = PlaceholderVerticalAlign.Center
                )
            ){
                Icon(
                    painter = painterResource(icon),
                    contentDescription = "icon",
                    tint = MaterialTheme.colorScheme.onBackground
                )
            }
        )
    )

    Text(
        modifier = Modifier,
        text = wholeText,
        inlineContent=inlineContent,
        style = TextStyle(
            fontFamily = Roboto,
            fontWeight = FontWeight.Medium,
            fontSize = 17.sp
        )
    )
}


@Composable
fun ButtonText(
    modifier: Modifier = Modifier,
    text: String,
){
    Text(
        modifier = modifier.wrapContentHeight(),
        text = text,
        style = TextStyle(
            fontFamily = Roboto,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        ),
        textAlign = TextAlign.Center,
    )
}

