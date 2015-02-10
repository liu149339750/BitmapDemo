package com.lw.fragment;

import com.lw.main.Method;
import com.lw.main.R;
import com.lw.util.ImageUtil;

import android.app.Fragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

public class BitmapHandleFragment extends Fragment{


	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		ImageView image1 = (ImageView) view.findViewById(R.id.imageView1);
		ImageView image2 = (ImageView) view.findViewById(R.id.imageView2);
		Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.x);
		Bitmap bm = Bitmap.createBitmap(bitmap);
		image1.setImageBitmap(bitmap);
		
		Bundle b = getArguments();
		if(b != null){
			int type = b.getInt("code");
			switch (type) {
			case Method.ROUNDED_HANDLE:
				bm = ImageUtil.getRoundedCornerBitmap(bm, 10);
				break;
			case Method.INVERTED_REFLECTION:
				bm = ImageUtil.createReflectionImageWithOrigin(bm);
				break;
			default:
				break;
			}
			image2.setImageBitmap(bm);
		}
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.two_bitmap, null);
	}
	
	
}
