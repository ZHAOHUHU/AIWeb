package shenzhen.teamway.utils;

import shenzhen.teamway.jsonResult.FaceResult;

import javax.imageio.stream.FileImageInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * @program: FTPFolder
 * @description:
 * @author: Zhao Hong Ning
 * @create: 2019-02-23 15:15
 **/
public class OtherUtiis {
    public static boolean checkingSucess1(File file) {
        file.canRead();
        long o1 = 0;
        long o2 = 0;
        while (true) {
            o1 = file.length();
            if (o1 == o2) {
                return true;
            } else {
                o2 = o1;
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public static boolean checkingSucess(File file) {
        boolean b = false;
        for (int i = 0; i < 5; i++) {
            b = file.renameTo(file);
            if (b) {
                break;
            }
        }
        return b;
    }

    /**
     * @Author: Zhao Hong Ning
     * @Description:大端转换成小端
     * @Date: 2019/2/26
     * @param: n
     * @return: byte[]
     */
    public static byte[] toLH(int n) {
        byte[] b = new byte[4];
        b[0] = (byte) (n & 0xff);
        b[1] = (byte) (n >> 8 & 0xff);
        b[2] = (byte) (n >> 16 & 0xff);
        b[3] = (byte) (n >> 24 & 0xff);
        return b;
    }

    /**
     * @Author: Zhao Hong Ning
     * @Description:小端四字节数组转大端
     * @Date: 2019/2/26
     * @param: n
     * @return: byte[]
     */

    //public static int bytesToIntBig(byte[] bytes){
    //    int result = 0;
    //    if(bytes.length == 4){
    //        int a = (bytes[0] & 0xff) << 24;//说明二
    //        int b = (bytes[1] & 0xff) << 16;
    //        int c = (bytes[2] & 0xff) << 8;
    //        int d = (bytes[3] & 0xff);
    //        result = a | b | c | d;
    //    }
    //    return result;
    //}
    public static int bytesToIntBig(byte[] src) {
        int offset = 0;
        int value;
        value = (int) (((src[offset] & 0xFF))
                | ((src[offset + 1] & 0xFF) << 8)
                | ((src[offset + 2] & 0xFF) << 16)
                | (src[offset + 3] & 0xFF) << 24);
        return value;
    }


    /**
     * @Author: Zhao Hong Ning
     * @Description:图片到byte数组(二进制字节流)
     * @Date: 2019/2/25
     * @param: file
     * @return: byte[]
     */
    public static byte[] image2byte(File file) {
        byte[] data = null;
        FileImageInputStream input = null;
        try {
            input = new FileImageInputStream(file);
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int numBytesRead = 0;
            while ((numBytesRead = input.read(buf)) != -1) {
                output.write(buf, 0, numBytesRead);
            }
            data = output.toByteArray();
            output.close();
            input.close();
        } catch (FileNotFoundException ex1) {
            ex1.printStackTrace();
        } catch (IOException ex1) {
            ex1.printStackTrace();
        }
        return data;
    }

    public static void main(String[] args) {
        final File file = new File("F:\\aa\\20190223\\cc.pdf");
        final boolean b = OtherUtiis.checkingSucess1(file);
        System.out.println(b);

    }

}