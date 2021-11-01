package com.madreapps.cocktailcrafter.feature_cocktail.presentation.add_edit_cocktail.components

import androidx.annotation.DrawableRes
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.Stable
import androidx.compose.ui.graphics.vector.ImageVector

@Immutable
interface FabIcon {
    @Stable
    val iconRes: ImageVector

    @Stable
    val iconRotate: Float?
}

private class FabIconImpl(
    override val iconRes: ImageVector,
    override val iconRotate: Float?
) : FabIcon

/**
 * Affects the main fab icon.
 *
 * @param iconRes [MultiFloatingActionButton]'s main icon
 * @param iconRotate if is not null, the [iconRes] rotates as much as [iconRotate] when [MultiFloatingActionButton] is in [MultiFabState.Expand] state.
 */
fun FabIcon(iconRes: ImageVector, iconRotate: Float? = null): FabIcon =
    FabIconImpl(iconRes = iconRes, iconRotate = iconRotate)