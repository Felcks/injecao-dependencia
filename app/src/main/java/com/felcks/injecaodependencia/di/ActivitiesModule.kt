package com.felcks.injecaodependencia.di

import com.felcks.injecaodependencia.map.MainActivity
import com.felcks.injecaodependencia.map.MainModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivitiesModule {

    @ContributesAndroidInjector(modules = arrayOf(MainModule::class))
    abstract fun bindLobbyActivity(): MainActivity

}