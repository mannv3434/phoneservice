package com.iii.phonservice.adapter;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.iii.phoneservice.R;
import com.iii.phonservice.model.Message;

public class MaketAdapter extends BaseAdapter {

	ArrayList<Message> lstMessage;
	Activity context;
	
	public MaketAdapter(ArrayList<Message> lstMessage, Activity context) {
		super();
		this.lstMessage = lstMessage;
		this.context = context;
	}

	@Override
	public int getCount() {
		return lstMessage.size();
	}

	@Override
	public Object getItem(int i) {
		return lstMessage.get(i);
	}

	@Override
	public long getItemId(int i) {
		return 0;
	}

	@Override
	public View getView(int i, View view, ViewGroup arg2) {
		ViewHolder holder = null;
		if(view == null){
			holder = new ViewHolder();
			view = context.getLayoutInflater().inflate(R.layout.row_view_market, null);
			
			holder.imgMessIcon = (ImageView)view.findViewById(R.id.imgMessIcon);
			holder.tvMessName = (TextView)view.findViewById(R.id.tvMessName);
			holder.tvMessContent = (TextView)view.findViewById(R.id.tvMessContent);
			holder.tvMessTime = (TextView)view.findViewById(R.id.tvMessTime);
			
			view.setTag(holder);
		}else{
			holder = (ViewHolder)view.getTag();
		}
		Bitmap bm;
		try{
			bm = BitmapFactory.decodeFile(lstMessage.get(i).getImage());
		}catch (Exception e) {
			bm = BitmapFactory.decodeResource(context.getResources(), R.drawable.phoneprofile);//decodeFile(String.valueOf(R.drawable.phoneprofile));
			holder.imgMessIcon.setImageBitmap(bm);
		}
		holder.tvMessName.setText(lstMessage.get(i).getName());
		holder.tvMessContent.setText(lstMessage.get(i).getContent());
		holder.tvMessTime.setText(lstMessage.get(i).getTime());
		
		return view;
	}

	class ViewHolder{
		ImageView imgMessIcon;
		TextView tvMessName, tvMessContent, tvMessTime;
	}
	
}
