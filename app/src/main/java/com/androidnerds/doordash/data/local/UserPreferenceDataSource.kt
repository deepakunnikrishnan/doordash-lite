package com.androidnerds.doordash.data.local

import android.content.SharedPreferences
import android.content.SharedPreferences.OnSharedPreferenceChangeListener
import com.androidnerds.doordash.core.framework.editSharedPreferences
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.subjects.BehaviorSubject
import javax.inject.Inject

class UserPreferenceDataSource @Inject constructor(sharedPreferences: SharedPreferences) {

    private val preferencesBehaviorSubject: BehaviorSubject<SharedPreferences> = BehaviorSubject.createDefault(sharedPreferences)
    private val changeListener = OnSharedPreferenceChangeListener { sharedPreferences, key ->
        if(key.equals(KEY_BANNER_STATUS)) {
            preferencesBehaviorSubject.onNext(sharedPreferences)
        }
    }

    companion object {
        private const val KEY_BANNER_STATUS = "banner_status";
    }

    init {
        sharedPreferences.registerOnSharedPreferenceChangeListener(changeListener)
    }

    fun saveBannerStatus(closed: Boolean): Completable = preferencesBehaviorSubject
        .firstOrError()
        .editSharedPreferences {
            putBoolean(KEY_BANNER_STATUS, closed)
        }

    fun bannerStatus(): Observable<Boolean> = preferencesBehaviorSubject
        .map { it.getBoolean(KEY_BANNER_STATUS, false) }
}