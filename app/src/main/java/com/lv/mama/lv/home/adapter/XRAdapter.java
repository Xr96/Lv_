package com.lv.mama.lv.home.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.lv.mama.lv.R;
import com.lv.mama.lv.client.GlideImageLoader;
import com.lv.mama.lv.home.bean.HomeBean;
import com.youth.banner.Banner;

import java.util.ArrayList;

import cn.iwgang.countdownview.CountdownView;

/**
 * Created by 武晓瑞 on 2017/11/9.
 */

public class XRAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    HomeBean.DataBean list;
    Context mcontext;
    ArrayList mlist;
    private  enum  Item_Type{
        Typeone,Typetwo,Typethree,Typefour,Typefive,Typesix,Typeseven;
    }
    //创建适配器有参构造
    public XRAdapter(Context context,HomeBean.DataBean data){
        this.mcontext=context;
        this.list=data;
    }
    /*
    * 点击事件
    * */
    public interface OnItemClickLitener
    {
        void onItemClick(View view, int position);
    }

    private OnItemClickLitener mOnItemClickLitener;

    public void setOnItemClickLitener(OnItemClickLitener mOnItemClickLitener)
    {
        this.mOnItemClickLitener = mOnItemClickLitener;
    }
    /*
    * 创建viewholder
    * */
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == Item_Type.Typeone.ordinal()) {
            View mView = LayoutInflater.from(mcontext).inflate(R.layout.recycle_item_a, null);
            ViewHolderA viewHolder = new ViewHolderA(mView);
            return viewHolder;

        } else if (viewType == Item_Type.Typetwo.ordinal()) {
            View mView = LayoutInflater.from(mcontext).inflate(R.layout.recycle_item_b, null);
            ViewHolderB viewHolder = new ViewHolderB(mView);
            return viewHolder;
        } else if (viewType == Item_Type.Typethree.ordinal()) {
            View mView = LayoutInflater.from(mcontext).inflate(R.layout.recycle_item_c, null);
            ViewHolderC viewHolder = new ViewHolderC(mView);
            return viewHolder;
        }else if (viewType == Item_Type.Typefour.ordinal()) {
            View mView = LayoutInflater.from(mcontext).inflate(R.layout.recycle_item_d, null);
            ViewHolderD viewHolder = new ViewHolderD(mView);
            return viewHolder;
        }else if(viewType==Item_Type.Typefive.ordinal()){
            View mView = LayoutInflater.from(mcontext).inflate(R.layout.recycle_item_e, null);
            ViewHolderE viewHolder = new ViewHolderE(mView);
            return viewHolder;
        }else if(viewType==Item_Type.Typesix.ordinal()){
            View mView = LayoutInflater.from(mcontext).inflate(R.layout.recycle_item_f, null);
            ViewHolderF viewHolder = new ViewHolderF(mView);
            return viewHolder;
        }else if(viewType==Item_Type.Typeseven.ordinal()){
            View mView = LayoutInflater.from(mcontext).inflate(R.layout.recycle_item_g, null);
            ViewHolderG viewHolder = new ViewHolderG(mView);
            return viewHolder;
        }
        return null;
    }
    /*
    * 绑定数据：可以直接拿到已经绑定的控件viewholder对象
    * */
    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolderA){
            mlist=new ArrayList();
            for (int i=0;i<list.getAd1().size();i++){
                mlist.add(list.getAd1().get(i).getImage());
            }

            //设置图片加载器
            ((ViewHolderA)holder).mbanner.setImageLoader(new GlideImageLoader());
            ((ViewHolderA)holder).mbanner.setImages(mlist);
            ((ViewHolderA)holder).mbanner.start();
        }else if(holder instanceof ViewHolderB){
            mlist=new ArrayList();
            for (int i=0;i<list.getAd5().size();i++){
                mlist.add(list.getAd5().get(i).getImage());
            }
            ((ViewHolderB)holder).re.setLayoutManager(new GridLayoutManager(mcontext,4));
            ((ViewHolderB)holder).re.setAdapter(new ViewHolderAa(list.getAd5(),mcontext));
            ((ViewHolderB)holder).cw.start(100000000);
        }else if(holder instanceof ViewHolderC){
            mlist=new ArrayList();
            for (int i=0;i<list.getActivityInfo().getActivityInfoList().size();i++){
                mlist.add(list.getActivityInfo().getActivityInfoList().get(i).getActivityImg());
            }
            //设置图片加载器
            ((ViewHolderC)holder).mbbanner.setImageLoader(new GlideImageLoader());
            ((ViewHolderC)holder).mbbanner.setImages(mlist);
            ((ViewHolderC)holder).mbbanner.start();
            com.nostra13.universalimageloader.core.ImageLoader instance = com.nostra13.universalimageloader.core.ImageLoader.getInstance();
            instance.displayImage(list.getSubjects().get(0).getImage(),((ViewHolderC)holder).img_c);
        }else if(holder instanceof ViewHolderD){
            mlist=new ArrayList();
            for (int i=0;i<list.getSubjects().get(0).getGoodsList().size();i++){
                mlist.add(list.getSubjects().get(0).getGoodsList().get(i).getGoods_img());
            }
            ((ViewHolderD)holder).rs.setLayoutManager(new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.HORIZONTAL));
            ((ViewHolderD)holder).rs.setAdapter(new ViewHolderDa(list.getSubjects().get(0).getGoodsList(),mcontext));
        }else if(holder instanceof ViewHolderE){
            mlist=new ArrayList();
            for (int i=0;i<list.getDefaultGoodsList().size();i++){
                mlist.add(list.getDefaultGoodsList().get(i).getGoods_img());
            }
            ((ViewHolderE)holder).rd.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
            ((ViewHolderE)holder).rd.setAdapter(new ViewHolderEa(list.getDefaultGoodsList(),mcontext));
//            if (mOnItemClickLitener != null) {
//                ((ViewHolderE) holder).rd.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//
//                        int pos = holder.getLayoutPosition();
//                        mOnItemClickLitener.onItemClick(((ViewHolderE) holder).rd, pos);
//                    }
//                });
//            }
        }

    }

    @Override
    public int getItemCount() {
        return 7;
    }

    @Override
    public int getItemViewType(int position) {
        if (position==0){
            return Item_Type.Typeone.ordinal();
        }else if(position==1){
            return Item_Type.Typetwo.ordinal();
        }else if(position==2){
            return Item_Type.Typethree.ordinal();
        }else if(position==3){
            return  Item_Type.Typefour.ordinal();
        }else if(position==4){
            return  Item_Type.Typefive.ordinal();
        }else if(position==5){
            return  Item_Type.Typesix.ordinal();
        }else if(position==6){
            return  Item_Type.Typeseven.ordinal();
        }
        return -1;
    }
    class ViewHolderA extends RecyclerView.ViewHolder{
        private Banner mbanner;
        public ViewHolderA(View itemView) {
            super(itemView);
            mbanner=(Banner)itemView.findViewById(R.id.mybanner);
        }
    }
    class ViewHolderB extends RecyclerView.ViewHolder{
        private RecyclerView re;
        private CountdownView cw;
        public ViewHolderB(View itemView) {
            super(itemView);
            re = (RecyclerView) itemView.findViewById(R.id.id_recyclerview);
            cw=(CountdownView) itemView.findViewById(R.id.countdownView);
        }
    }
    class ViewHolderC extends RecyclerView.ViewHolder{
        private Banner mbbanner;
        private ImageView img_c;
        public ViewHolderC(View itemView) {
            super(itemView);
            mbbanner=(Banner)itemView.findViewById(R.id.mybbanner);
            img_c=(ImageView) itemView.findViewById(R.id.img_b2);
        }
    }
    class ViewHolderD extends RecyclerView.ViewHolder{
        private RecyclerView rs;

        public ViewHolderD(View itemView) {
            super(itemView);
            rs = (RecyclerView) itemView.findViewById(R.id.id_recyclerviews);
        }
    }
    class ViewHolderE extends RecyclerView.ViewHolder{
        private RecyclerView rd;

        public ViewHolderE(View itemView) {
            super(itemView);
            rd = (RecyclerView) itemView.findViewById(R.id.id_recyclerviewd);

        }
    }
    class ViewHolderF extends RecyclerView.ViewHolder{
        public TextView text;

        public ViewHolderF(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.tvf);
        }
    }
    class ViewHolderG extends RecyclerView.ViewHolder{
        public TextView text;

        public ViewHolderG(View itemView) {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.tvg);
        }
    }
}
