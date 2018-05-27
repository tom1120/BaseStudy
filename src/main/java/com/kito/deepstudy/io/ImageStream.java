package com.kito.deepstudy.io;/**
 * Created by hasee on 2017/5/27.
 */

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;

/**
 * @author zhaoyi
 * @createTime 2017-05-2017/5/27-23:51
 */
public class ImageStream {
    private void readImage(){
        String imagePath="E:\\123.jpg";
        File imageFile=new File(imagePath);
        try {

            BufferedImage bi= ImageIO.read(imageFile);


            ImageIO.write(bi, "jpg", new File("e:\\test.jpg"));

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ImageStream imageStream=new ImageStream();
        imageStream.readImage();
    }

}
