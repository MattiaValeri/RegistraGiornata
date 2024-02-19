package com.app.dayregistry.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.Placeholder
import androidx.compose.ui.text.PlaceholderVerticalAlign
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.app.dayregistry.ui.theme.Roboto


@Composable
fun TitleText(
    modifier: Modifier = Modifier,
    text: String,
    textAlign: TextAlign? = TextAlign.Left
){
    Text(
        modifier = modifier,
        text = text,
        style = TextStyle(
            fontFamily = Roboto,
            fontWeight = FontWeight.Bold,
            fontSize = 35.sp
        ),
        textAlign = textAlign
    )
}

@Composable
fun SubtitleText(
    modifier: Modifier = Modifier,
    text: String
){
    Text(
        modifier = modifier,
        text = text,
        style = TextStyle(
            fontFamily = Roboto,
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp
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
        modifier = modifier,
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
fun NormalText(
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

@Composable
fun NormalAppButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    text: String
){
    Surface(
        modifier = modifier
            .size(30.dp)
            .clickable { onClick() },
        color = MaterialTheme.colorScheme.primary,
        shape = RoundedCornerShape(15.dp),

    ) {
        NormalText(text = text)
    }
}

@Composable
fun NormalOutlinedTextField(
    modifier: Modifier = Modifier,
    initialText: String = "",
    label: String
){
    var text by remember { mutableStateOf(TextFieldValue(initialText)) }
    OutlinedTextField(
        modifier = modifier,
        value = text,
        onValueChange = { newText ->
            text = newText
        },
        label = {Text(text = label)}
    )
}



