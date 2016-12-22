package com.sunjiajia.androidnewwidgetsdemo;

import java.io.File;
import java.util.Comparator;


/**
 * Created by lijing on 2016/12/22.
 */

public class FileComparator implements Comparator<File> {
    @Override
    public int compare(File lhs, File rhs) {
        if (lhs.lastModified() < rhs.lastModified()) {
            return 1;//最后修改的照片在前
        } else {
            return -1;
        }
    }




}
