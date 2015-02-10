package com.lw.fragment;

import java.util.ArrayList;
import java.util.List;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.lw.main.Method;
import com.lw.main.R;

public class BitmapListFragment extends ListFragment{


	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		setListAdapter(new MyBitmapAdpater(getActivity()));
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		Method m = (Method) l.getItemAtPosition(position);
		Fragment fragment = new BitmapHandleFragment();
		Bundle bundle = new Bundle();
		bundle.putInt("code", m.code);
		fragment.setArguments(bundle);
		FragmentTransaction ft = getFragmentManager().beginTransaction();
		ft.replace(R.id.fragment, fragment);
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);//���ö���Ч��
		ft.addToBackStack(null);
		ft.commit();
	}
	
	
	class MyBitmapAdpater extends BaseAdapter{
		private Context mContext;
		private List<Method> mData;
		public MyBitmapAdpater(Context context){
			mContext = context;
			mData = getItems();
		}

		@Override
		public int getCount() {
			return mData.size();
		}

		@Override
		public Method getItem(int position) {
			// TODO Auto-generated method stub
			return mData.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if(convertView == null){
				convertView = LayoutInflater.from(mContext).inflate(android.R.layout.simple_list_item_1, null);
			}
			TextView text = (TextView) convertView.findViewById(android.R.id.text1);
			Method method = getItem(position);
			text.setText(method.method);
			return convertView;
		}
		
		
		private List<Method> getItems(){
			List<Method>list = new ArrayList<Method>();
			list.add(new Method("Բ�Ǵ���", Method.ROUNDED_HANDLE));
			list.add(new Method("��ӰЧ��",Method.INVERTED_REFLECTION));
			return list;
		}
		
	}
}
