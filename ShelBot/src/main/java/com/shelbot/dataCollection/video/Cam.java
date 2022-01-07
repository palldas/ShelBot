package com.shelbot.dataCollection.video;

import java.io.File;

import uk.co.caprica.picam.Camera;
import uk.co.caprica.picam.CameraConfiguration;
import uk.co.caprica.picam.FilePictureCaptureHandler;
import uk.co.caprica.picam.enums.Encoding;

public class Cam {

    private Camera cam;
    private CameraConfiguration config;

    public Cam(){
        try{
            config = CameraConfiguration.cameraConfiguration()
            .width(1920)
            .height(1080)
            .encoding(Encoding.JPEG)
            .quality(85);
            cam = new Camera(config);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        
    }

    public void takePicture(String fileName){
        try{
            cam.takePicture(new FilePictureCaptureHandler(new File(fileName)));
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void closeCamera(){
        try{
            cam.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public boolean openCamera(){
        try{
            return cam.open();
        }
        catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public CameraConfiguration getConfig(){
        return config;
    }

    public void setConfig(CameraConfiguration config){
        this.config = config;
        try{
            cam = new Camera(config);
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

}