package shenzhen.teamway.utils;

import org.slf4j.LoggerFactory;

import java.io.File;
import java.util.*;

/**
 * @program: FTPFolder
 * @description:
 * @author: Zhao Hong Ning
 * @create: 2019-02-22 17:07
 **/
public class FTPUtils {
    static org.slf4j.Logger log = LoggerFactory.getLogger(FTPUtils.class);

    public static List<File> getFiles(String path) {
        final ArrayList<File> list = new ArrayList<File>();
        File file = null;
        file = new File(path);
        final boolean b = file.exists();
        if (!b) {
            log.error("文件路径不存在");
            return null;
        } else {
            final File[] files = file.listFiles();
            if (files.length == 0) {
                log.error("文件夹是空的");
                return null;
            } else {
                final List<File> fileSortNames = getFolderSoft(Arrays.asList(files));
                //获取最新的文件夹下面的图片
                String newFolder = fileSortNames.get(fileSortNames.size() - 1).getName();
                file = new File(path + File.separator + newFolder);
                final File[] listFiles = file.listFiles();
                for (File f : listFiles) {
                    final boolean directory = f.isDirectory();
                    if (!directory) {
                        list.add(f);
                    }
                }
                return list;
            }
        }
    }

    /**
     * @Author: Zhao Hong Ning
     * @Description:排序之后的结果
     * @Date: 2019/2/23
     * @param: files
     * @return: java.util.List<java.lang.String>
     */
    public static List<File> getFileSort(List<File> files) {
        final ArrayList<File> list = new ArrayList<File>();
        if (files.size() == 0) {
            return list;
        }
        Collections.sort(files, new Comparator<File>() {
            public int compare(File o1, File o2) {
                if (o1.lastModified() < o2.lastModified()) {
                    return -1;
                } else if (o1.lastModified() == o2.lastModified()) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        while (true) {
            final boolean b = OtherUtiis.checkingSucess(files.get(files.size() - 1));
            if (b) {
                break;
            }
        }
        //移动文件
        for (File file : files) {
            final File mvimages = mvimages(file);
            list.add(mvimages);
        }
        return list;
    }

    //文件夹排序
    public static List<File> getFolderSoft(List<File> files) {
        final ArrayList<File> list = new ArrayList<File>();
        Collections.sort(files, new Comparator<File>() {
            public int compare(File o1, File o2) {
                if (o1.lastModified() < o2.lastModified()) {
                    return -1;
                } else if (o1.lastModified() == o2.lastModified()) {
                    return 0;
                } else {
                    return 1;
                }
            }
        });
        for (File file : files) {
            list.add(file);
        }
        return list;
    }

    /**
     * @Author: Zhao Hong Ning
     * @Description:移动文件并且创建文件,读取流的时候就去另外一个文件里面读取吧
     * @Date: 2019/2/23
     * @param: null
     * @return:
     */
    public static File mvimages(File file) {
        final ArrayList<File> files = new ArrayList<File>();
        String path = file.getParentFile().getPath();
        String folderName = file.getParentFile().getName();
        String newPath = path + File.separator + folderName;
        final File desc = new File(newPath);
        if (!desc.exists()) {
            final boolean mkdir = desc.mkdir();
        }
        final File newFile = new File(newPath + File.separator + file.getName());
        final boolean b = file.renameTo(newFile);
        if (b) {
            log.debug("移动文件成功");
            //todo:文件的新路径         newFile.getAbsolutePath());       //todo：插入数据库的图片路径

            return newFile;
        } else {
            log.error("移动文件失败");
        }


        return null;
    }

    public static void main(String[] args) {
        final List<File> files = FTPUtils.getFiles("F:\\aa");
        final List<File> fileSortName = FTPUtils.getFileSort(files);
        for (File file : fileSortName) {
            final String s = file.getAbsolutePath();
            System.out.println(s);
        }
    }
}