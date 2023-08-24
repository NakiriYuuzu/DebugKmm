package net.yuuzu.media.ios

import net.yuuzu.media.PermissionDelegate
import net.yuuzu.media.PermissionState

internal class AlwaysGrantedPermissionDelegate : PermissionDelegate {
    override suspend fun providePermission() = Unit

    override suspend fun getPermissionState(): PermissionState = PermissionState.Granted
}