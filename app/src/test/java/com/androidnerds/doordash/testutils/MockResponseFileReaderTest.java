package com.androidnerds.doordash.testutils;


import android.text.TextUtils;

import com.androidnerds.doordash.testconstant.ApiConstants;

import org.junit.Test;

import static org.junit.Assert.*;

public class MockResponseFileReaderTest {

    @Test
    public void testReadFile() {

        MockResponseFileReader fileReader = new MockResponseFileReader(ApiConstants.STORE_FEED_SUCCESS);
        assertFalse(TextUtils.isEmpty(fileReader.getContent()));
    }
}