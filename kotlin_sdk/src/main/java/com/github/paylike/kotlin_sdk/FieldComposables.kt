package com.github.paylike.kotlin_sdk

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.*
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.progressSemantics
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.PaintingStyle.Companion.Stroke
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.github.paylike.kotlin_sdk.cardprovider.CardProviderIconMap
import com.github.paylike.kotlin_sdk.cardprovider.SupportedCardProviders
import com.github.paylike.kotlin_sdk.theme.LocalPaylikePaddings
import com.github.paylike.kotlin_sdk.theme.PaylikeTheme
import com.github.paylike.kotlin_sdk.visualformatter.CardNumberVisualTransformation
import com.github.paylike.kotlin_sdk.visualformatter.CardVerificationCodeVisualTransformation
import com.github.paylike.kotlin_sdk.visualformatter.ExpirationDateVisualTransformation
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 */
@Composable
fun CardNumberField(
    modifier: Modifier = Modifier,
    value: String,
    textStyle: TextStyle = LocalTextStyle.current,
    isValid: Boolean,
    isEnabled: Boolean = true, // TODO
    onValueChanged: (String) -> Unit,
    highlightedCardProvider: SupportedCardProviders,
) {
    TextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChanged,
        textStyle = textStyle,
        trailingIcon = {
            CardProviderIcons(
                modifier = Modifier,
                highlightedCardProvider = highlightedCardProvider,
            )
        },
        visualTransformation =
            CardNumberVisualTransformation(
                validColor = PaylikeTheme.colors.onBackground,
                invalidColor = PaylikeTheme.colors.error,
                isValid = isValid,
            ),
        singleLine = true,
        enabled = isEnabled, // TODO if its good
        isError = !isValid, // TODO if its good
        keyboardOptions =
            KeyboardOptions(
                keyboardType = KeyboardType.Decimal,
            ),
        colors =
            TextFieldDefaults.textFieldColors(
                backgroundColor = PaylikeTheme.colors.background,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
    )
}

/**
 */
@Composable
fun ExpiryDateField(
    modifier: Modifier = Modifier,
    value: String,
    textStyle: TextStyle = LocalTextStyle.current,
    isValid: Boolean,
    isEnabled: Boolean = true, // TODO
    onValueChanged: (String) -> Unit,
) {
    TextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChanged,
        textStyle = textStyle,
        visualTransformation =
            ExpirationDateVisualTransformation(
                validColor = PaylikeTheme.colors.onBackground,
                invalidColor = PaylikeTheme.colors.error,
                isValid = isValid,
            ),
        singleLine = true,
        enabled = isEnabled, // TODO if its good
        isError = !isValid, // TODO if its good
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
        colors =
            TextFieldDefaults.textFieldColors(
                backgroundColor = PaylikeTheme.colors.background,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
    )
}

/**
 */
@Composable
fun CardVerificationCodeField(
    modifier: Modifier = Modifier,
    value: String,
    textStyle: TextStyle = LocalTextStyle.current,
    isValid: Boolean,
    isEnabled: Boolean = true, // TODO
    onValueChanged: (String) -> Unit,
) {
    TextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChanged,
        textStyle = textStyle,
        visualTransformation =
            CardVerificationCodeVisualTransformation(
                validColor = PaylikeTheme.colors.onBackground,
                invalidColor = PaylikeTheme.colors.error,
                isValid = isValid,
            ),
        enabled = isEnabled, // TODO if its good
        isError = !isValid, // TODO if its good
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
        colors =
            TextFieldDefaults.textFieldColors(
                backgroundColor = PaylikeTheme.colors.background,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
    )
}

/**
 */
@Composable
fun FirstNameField(
    modifier: Modifier = Modifier,
    value: String,
    textStyle: TextStyle = LocalTextStyle.current,
    isValid: Boolean,
    isEnabled: Boolean = true, // TODO
    onValueChanged: (String) -> Unit,
) {
    TextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChanged,
        textStyle = textStyle,
        placeholder = {
            Text(
                modifier = modifier,
                text = "John",
                style = textStyle,
                color = (if (isValid) Color.LightGray else PaylikeTheme.colors.error),
            )
        },
        enabled = isEnabled, // TODO if its good
        isError = !isValid, // TODO if its good
        colors =
            TextFieldDefaults.textFieldColors(
                backgroundColor = PaylikeTheme.colors.background,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
    )
}

/**
 */
@Composable
fun LastNameField(
    modifier: Modifier = Modifier,
    value: String,
    textStyle: TextStyle = LocalTextStyle.current,
    isValid: Boolean,
    isEnabled: Boolean = true, // TODO
    onValueChanged: (String) -> Unit,
) {
    TextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChanged,
        textStyle = textStyle,
        placeholder = {
            Text(
                modifier = modifier,
                text = "Doe",
                style = textStyle,
                color = (if (isValid) Color.LightGray else PaylikeTheme.colors.error),
            )
        },
        enabled = isEnabled, // TODO if its good
        isError = !isValid, // TODO if its good
        colors =
            TextFieldDefaults.textFieldColors(
                backgroundColor = PaylikeTheme.colors.background,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
    )
}

/**
 */
@Composable
fun NoteField(
    modifier: Modifier = Modifier,
    value: String,
    textStyle: TextStyle = LocalTextStyle.current,
    isEnabled: Boolean = true, // TODO
    onValueChanged: (String) -> Unit,
) {
    TextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChanged,
        textStyle = textStyle,
        placeholder = {
            Text(
                modifier = modifier,
                text = "Note (optional)",
                style = textStyle,
                color = Color.LightGray,
            )
        },
        enabled = isEnabled, // TODO if its good
        colors =
            TextFieldDefaults.textFieldColors(
                backgroundColor = PaylikeTheme.colors.background,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
                disabledIndicatorColor = Color.Transparent
            )
    )
}

/**
 */
@Composable
fun CardProviderIcon(
    modifier: Modifier = Modifier,
    showedCardProviderIcon: SupportedCardProviders,
    isHighlighted: Boolean,
) {
    Image(
        modifier = modifier,
        painter = painterResource(id = CardProviderIconMap[showedCardProviderIcon]!!),
        contentDescription =
            null, // TODO do we need description to be able to support accessibility features such
        // as reading out loud any icon
        colorFilter = if (isHighlighted) null else ColorFilter.tint(Color.Gray),
    )
}

/**
 */
@Composable
fun CardProviderIcons(
    modifier: Modifier = Modifier,
    highlightedCardProvider: SupportedCardProviders
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        CardProviderIcon(
            modifier = Modifier.size(48.dp).padding(horizontal = 8.dp),
            showedCardProviderIcon = SupportedCardProviders.MAESTRO,
            isHighlighted = highlightedCardProvider == SupportedCardProviders.MAESTRO,
        )
        CardProviderIcon(
            modifier = Modifier.size(48.dp).padding(horizontal = 8.dp),
            showedCardProviderIcon = SupportedCardProviders.MASTERCARD,
            isHighlighted = highlightedCardProvider == SupportedCardProviders.MASTERCARD,
        )
        CardProviderIcon(
            modifier = Modifier.size(48.dp).padding(horizontal = 8.dp),
            showedCardProviderIcon = SupportedCardProviders.VISA,
            isHighlighted = highlightedCardProvider == SupportedCardProviders.VISA,
        )
    }
}

@Composable
fun SecurePaymentLabel(
    modifier: Modifier = Modifier,
    textStyle: TextStyle = LocalTextStyle.current,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            modifier = Modifier.padding(LocalPaylikePaddings.current.smallPadding),
            painter = painterResource(R.drawable.ic_paylike),
            contentDescription =
                null, // TODO do we need description to be able to support accessibility features
            // such as reading out loud any icon
            )
        Text(
            modifier = Modifier,
            style = textStyle,
            text = stringResource(id = R.string.SecurePayment),
        )
    }
}

@Composable
fun LoadingSpinner(
    modifier: Modifier = Modifier,
    color: Color = LocalContentColor.current,
) {
    val sweepAngle: Float = 90f
    val strokeWidth: Dp = ProgressIndicatorDefaults.StrokeWidth
    val transition = rememberInfiniteTransition()
    val currentArcStartAngle by
        transition.animateValue(
            0,
            360,
            Int.VectorConverter,
            infiniteRepeatable(animation = tween(durationMillis = 1100, easing = LinearEasing))
        )
    val stroke =
        with(LocalDensity.current) { Stroke(width = strokeWidth.toPx(), cap = StrokeCap.Square) }
    Canvas(modifier.progressSemantics().padding(strokeWidth / 2)) {
        drawArc(
            color,
            startAngle = currentArcStartAngle.toFloat() - 90,
            sweepAngle = sweepAngle,
            useCenter = false,
            style = stroke
        )
        drawArc(
            color,
            startAngle = currentArcStartAngle.toFloat() + 90,
            sweepAngle = sweepAngle,
            useCenter = false,
            style = stroke
        )
    }
}

@Composable
fun SuccessAnimation(
    modifier: Modifier = Modifier,
    delay: Long = 600,
) {
    var visible by remember { mutableStateOf(false) }
    SideEffect {
        CoroutineScope(Dispatchers.IO).launch {
            delay(delay)
            visible = true
        }
    }
    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center,
    ) {
        Image(
            modifier = Modifier.fillMaxSize(1f),
            painter =
                painterResource(
                    id = R.drawable.bg_successful_payment
                ),
            contentDescription =
                null, // TODO do we need description to be able to support accessibility features
                      // such as reading out loud any icon
            )
        Image(
            modifier = Modifier.fillMaxSize(0.8f),
            painter =
                painterResource(
                    id = R.drawable.ic_successful_payment_circle
                ),
            contentDescription = null
        )
        val density = LocalDensity.current
        AnimatedVisibility(
            visible = visible,
            enter = slideInVertically { with(density) { -400.dp.roundToPx() } }
        ) {
            Image(
                modifier =
                    Modifier.fillMaxSize(0.5f)
                        .padding(25.dp, 0.dp, 0.dp, 0.dp), // TODO csoves megoldas
                painter = painterResource(id = R.drawable.ic_successful_payment_checkmark),
                contentDescription = null
            )
        }
    }
}

@Composable fun ErrorAnimation() {}

/**
 */
@Composable
fun PayButton(
    modifier: Modifier = Modifier,
    shape: Shape = PaylikeTheme.shapes.medium,
    onClick: () -> Unit,
    isVisible: Boolean = true,
    content: @Composable RowScope.() -> Unit = {
        Text(
            LocalContext.current.getString(R.string.PayButton),
        )
    },
) {
    if (isVisible) {
        Button(
            modifier = modifier,
            shape = shape,
            onClick = onClick,
            content = content,
        )
    }
}
