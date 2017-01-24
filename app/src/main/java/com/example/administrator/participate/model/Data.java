package com.example.administrator.participate.model;

import com.example.administrator.participate.R;
import com.example.administrator.participate.adapter.Adapter;

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

        for (int i = 0; i <8; i++) {
            ListItem item = new ListItem();
            item.setImageResId(icons[i % 3]);
            item.setTitles(titles[i % 3]);
            item.setLevel(level[i % 3]);
            item.setSign(sign[i % 3]);
            item.setRecord(record[i % 3]);
            data.add(item);


        }


        return data;
    }

    public static List<ListItem> add() {

        List<ListItem> newdata = new ArrayList<>();

        for (int i = 0; i <2; i++) {
            ListItem item = new ListItem();
            item.setImageResId(icons[i % 3]);
            item.setTitles(titles[i % 3]);
            item.setLevel(level[i % 3]);
            item.setSign(sign[i % 3]);
            item.setRecord(record[i % 3]);
            newdata.add(item);
        }
        return newdata;
    }
}