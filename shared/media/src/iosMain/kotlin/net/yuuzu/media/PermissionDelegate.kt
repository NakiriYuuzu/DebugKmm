package net.yuuzu.media

internal interface PermissionDelegate {
    suspend fun providePermission()
    suspend fun getPermissionState(): PermissionState
}
