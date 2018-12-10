package com.felcks.injecaodependencia.di

import android.app.Application
import com.felcks.injecaodependencia.common.domain.model.ObraRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {


    @Provides
    fun provideContext(application: Application) = application.applicationContext

    @Singleton
    @Provides
    fun provideCarregarObras(): ObraRepository {
        return ObraRepository()
    }
}