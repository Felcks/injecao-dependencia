package com.felcks.injecaodependencia.di

import android.app.Application
import com.felcks.injecaodependencia.common.domain.model.ObraRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Singleton
    @Provides
    fun provideContext(application: Application) = application.applicationContext

//    @Provides
//    fun provideCarregarObras(): ObraRepository {
//        return ObraRepository()
//    }
}