package tests;

import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FileUploadPage;
import pages.HomePage;

import java.io.File;

public class FileUploadTest extends BaseTest {

    //Verify upload success
    @Test
    public void verifyFileUpload() {
        HomePage home=new HomePage(getDriver());
        home.openHomePage();
        home.goToFileUpload();

        FileUploadPage uploadPage=new FileUploadPage(getDriver());

        File file=new File("src/test/resources/testdata/sample.txt");
        uploadPage.uploadFile(file.getAbsolutePath());
        String uploadedFile=uploadPage.getUploadedFileName();

        Assert.assertEquals(uploadedFile,file.getName(),"Uploaded filename is incorrect");
    }

    //Verify unsupported file handling
    @Test
    public void verifyUnsupportedFileUpload() {
        HomePage home=new HomePage(getDriver());
        home.openHomePage();
        home.goToFileUpload();

        FileUploadPage uploadPage =new FileUploadPage(getDriver());
        File file=new File("src/test/resources/testdata/samplePdf.pdf");
        Assert.assertTrue(file.exists(), "Test file not found!");

        uploadPage.uploadFile(file.getAbsolutePath());
        String result=uploadPage.getUploadedFileName();

        Assert.assertNotNull(result, "Upload result is null");
        Assert.assertTrue(result.contains(file.getName()),"Application did not handle unsupported file gracefully");
    }

    //Verify page title and form visibility
    @Test
    public void verifyUploadPageUI() {
        HomePage home=new HomePage(getDriver());
        home.openHomePage();
        home.goToFileUpload();

        FileUploadPage uploadPage=new FileUploadPage(getDriver());

        Assert.assertEquals(uploadPage.getPageTitle(), "File Uploader");
        Assert.assertTrue(uploadPage.isUploadFormVisible(),"Upload form is not visible");
    }
}