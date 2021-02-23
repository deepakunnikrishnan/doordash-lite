package com.androidnerds.doordash.data.local.store;

import android.content.Context;

import androidx.room.Room;
import androidx.test.core.app.ApplicationProvider;

import com.androidnerds.doordash.constant.FileConstants;
import com.androidnerds.doordash.data.local.AppDatabase;
import com.androidnerds.doordash.data.local.dao.StoreDao;
import com.androidnerds.doordash.data.local.entity.StoreEntity;
import com.androidnerds.doordash.data.local.entity.StoreFeedEntity;
import com.androidnerds.doordash.domain.model.store.Store;
import com.androidnerds.doordash.testutils.JsonUtils;
import com.androidnerds.doordash.testutils.MockResponseFileReader;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.observers.TestObserver;

import static org.junit.Assert.*;

public class StoreLocalDataSourceTest {

    private StoreDao storeDao;
    private AppDatabase appDatabase;
    private MockResponseFileReader mockResponseFileReader;

    @Before
    public void setup() {
        createDb();
    }

    private void createDb() {
        Context context = ApplicationProvider.getApplicationContext();
        appDatabase = Room.inMemoryDatabaseBuilder(context, AppDatabase.class).build();
        storeDao = appDatabase.storeDao();
    }

    @After
    public void tearDown() {
        closeDb();
    }

    private void closeDb() {
        appDatabase.close();
    }
    @Test
    public void testInsertStores() {
        this.mockResponseFileReader = new MockResponseFileReader(FileConstants.STORE_ITEM);
        StoreEntity storeEntity = JsonUtils.getStore(mockResponseFileReader.getContent());
        assertNotNull(storeEntity);

        //operation
        List<StoreEntity> list = new ArrayList<>();
        list.add(storeEntity);
        List<Long> ids = storeDao.insertStores(list);
        //assert
        assertFalse(ids.isEmpty());

        //operation
        StoreEntity result = storeDao.getStore(storeEntity.getId()).blockingGet();
        //assert
        assertNotNull(storeEntity);
        assertEquals(result.getName(), storeEntity.getName());
    }

    @Test
    public void testInsertStore() {
        this.mockResponseFileReader = new MockResponseFileReader(FileConstants.STORE_ITEM);
        StoreEntity storeEntity = JsonUtils.getStore(mockResponseFileReader.getContent());
        assertNotNull(storeEntity);
        TestObserver testObserver = new TestObserver();

        //operation
        storeDao.insertStore(storeEntity)
                .subscribe(testObserver);

        //assert
        testObserver.assertNoErrors();
        testObserver.assertComplete();

        //operation
        StoreEntity result = storeDao.getStore(storeEntity.getId()).blockingGet();
        //assert
        assertNotNull(storeEntity);
        assertEquals(result.getName(), storeEntity.getName());
    }
}