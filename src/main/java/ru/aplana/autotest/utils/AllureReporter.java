package ru.aplana.autotest.utils;


import io.qameta.allure.Attachment;

public class AllureReporter {

    @Attachment(value = "Page screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenShot) {
        return screenShot;
    }


}
