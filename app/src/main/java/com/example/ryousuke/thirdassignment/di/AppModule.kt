package com.example.ryousuke.thirdassignment.di

import android.content.Context
import androidx.room.Room
import com.example.ryousuke.thirdassignment.database.ToDoDatabase
import com.example.ryousuke.thirdassignment.utility.Constants.TODO_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun providingDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(
        context,
        ToDoDatabase::class.java,
        TODO_DATABASE_NAME
    ) .build()


    @Singleton
    @Provides
    fun provideDao(db: ToDoDatabase) = db.getToDoDao()
}