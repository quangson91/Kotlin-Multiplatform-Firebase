package com.rubylich.ktmp.notifications.di

import android.app.NotificationManager
import android.content.Context
import com.rubylich.ktmp.notifications.*
import com.russhwolf.settings.PlatformSettings
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.Module
import org.koin.dsl.module.module
import rubylich.ktmp.notifications.IUnreadNotificationsRepo
import rubylich.ktmp.notifications.NotificationItemResolver
import rubylich.ktmp.notifications.NotificationItemResolverImpl
import rubylich.ktmp.notifications.UnreadNotificationsRepo

/**
 * Created by rl98880 on 05/07/2018.
 */
fun notificationsModule(): Module = module {
    single { androidContext().getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager }
    single { PushNotification(get(), get(), get()) }
    single { NotificationItemResolverImpl(get()) as NotificationItemResolver }
    single { NotificationBuilderImpl() as NotificationBuilder }
    single { UnreadNotificationsRepo(PlatformSettings.Factory(androidContext())) as IUnreadNotificationsRepo }
}