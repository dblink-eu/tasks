package com.crud.tasks.config;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class AdminConfigTest {

    @Mock
    private AdminConfig adminConfig;

    @Test
    public void getAdminMail() {
        //Given
        String adminMail = "test.admin.mail@test.com";
        when(adminConfig.getAdminMail()).thenReturn(adminMail);
        //When
        String testAdminMail = adminConfig.getAdminMail();
        //Then
        Assert.assertEquals(adminMail, testAdminMail);
    }
}