/*
 * Copyright (C) 2014 Niek Haarman
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.haarman.pebblenotifier.model.ormlite;

import com.haarman.pebblenotifier.model.App;
import com.haarman.pebblenotifier.model.Notification;
import com.haarman.pebblenotifier.model.OrmManager;

import org.jetbrains.annotations.NotNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * A module for the database layer of the application, which uses OrmLite.
 *
 * Provides:
 *  - An OrmManager;
 *  - App;
 *  - Notification.
 */
@Module(
        complete = false,
        injects = {
                /* Specific model classes */
                OrmLiteNotification.class,
                OrmLiteApp.class,

                /* Interfaces */
                Notification.class,
                App.class
        },
        library = true
)
public class OrmLiteModule {

    @Provides
    @Singleton
    OrmManager provideOrmManager(@NotNull final OrmLiteDatabaseHelper ormLiteDatabaseHelper) {
        return ormLiteDatabaseHelper;
    }

    @Provides
    protected App provideApp(@NotNull final OrmLiteApp ormLiteApp) {
        return ormLiteApp;
    }

    @Provides
    protected Notification provideNotification(@NotNull final OrmLiteNotification ormLiteNotification) {
        return ormLiteNotification;
    }

}
