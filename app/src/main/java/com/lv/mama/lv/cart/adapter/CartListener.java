package com.lv.mama.lv.cart.adapter;

/**
 * Created by 武晓瑞 on 2017/11/18.
 */

public interface CartListener {
    //切换编辑和展示状态
    void changeEditor(boolean isEditor,int groupId,int childId);
    //组CheckBox点击
    void onGroupClick(int groupId);
    //子CheckBox点击
    void onChildClick(int groupId,int childId);
    //数量加
    void onAddClick(int groupId,int childId);
    //数量减
    void onMinus(int groupId,int childId);
}
