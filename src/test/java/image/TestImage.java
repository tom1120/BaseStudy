package image;

import org.im4java.core.*;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author zhaoyipc
 * @company QLONG
 * @date 2022-11-07 17:15
 */

public class TestImage {

    @Test
    public void testImage() throws IOException, InterruptedException, IM4JavaException {
        IMOperation operation = new IMOperation();
        operation.addImage("C:\\Users\\Administrator\\Desktop\\logo.png");
        operation.rotate(90d);
        operation.addImage("C:\\Users\\Administrator\\Desktop\\logo_rotate.png");

        ConvertCmd cmd = new ConvertCmd();
        cmd.setSearchPath("D:\\ImageMagick-7.1.0-Q16-HDRI");  //Windows需要设置，Linux不需要
        cmd.run(operation);
    }

    /**
     * @param filePath    文件路径
     * @param width       宽
     * @param height      高
     * @param genType     生成文件类型即后缀名
     * @param genFileName 生成文件名称
     * @param genPath     生成文件路径
     */
    public static void convertImages(String filePath, String width, String height, String genType, String genFileName, String genPath) {

        String commandStr = "convert -resize " + width + "x" + height + " " + filePath + " " + genPath + "/" + genFileName + "." + genType;
        System.out.println(commandStr);
        BufferedReader br = null;
        try {
            Process p = Runtime.getRuntime().exec(commandStr);
            br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line = null;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            System.out.println(sb.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }



    @Test
    public void testPsd() throws IOException, InterruptedException, IM4JavaException {
        IMOperation operation = new IMOperation();
        operation.addImage("C:\\Users\\Administrator\\Desktop\\psd35547\\psd35547.psd");
        operation.addImage("C:\\Users\\Administrator\\Desktop\\psd35547\\psd35547.png");
        ConvertCmd cmd = new ConvertCmd();
        cmd.setSearchPath("D:\\ImageMagick-7.1.0-Q16-HDRI");  //Windows需要设置，Linux不需要
        cmd.run(operation);

    }

    @Test
    public void testPsdInfo() throws InfoException {
        Info info=new Info("C:\\Users\\Administrator\\Desktop\\psd35547\\psd35547.psd");
        System.out.println("info.getImageGeometry() = " + info.getImageGeometry());

    }

}
