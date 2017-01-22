package com.example.administrator.participate.model;

import com.example.administrator.participate.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/1/9.
 */

public class Data {
    private static final String[] titles = {"第一", "第二", "第三"};
    private static final String[] level = {"酱油", "中坚", "主力"};
    private static final String[] record = {"今日被赞3次 |  5张图片", "今日被赞6次 | 7张图片", "今日被赞6次 | 5张图片"};
    private static final String[] sign = {"从前有座山", "山上有座庙", "庙里有个老和尚"};
    private static final int[] icons = {R.drawable.beiqu, R.drawable.beiyule, R.drawable.bugaoxing};

    public static List<ListItem> getListData() {
        List<ListItem> data = new ArrayList<>();

        for ( int i = 0; i <titles.length&& i<icons.length; i++){
            ListItem item = new ListItem();
            item.setImageResId(icons[i]);
            item.setTitles(titles[i]);
            item.setLevel(level[i]);
            item.setSign(sign[i]);
            item.setRecord(record[i]);
            data.add(item);


        }


        return data;
    }
}
