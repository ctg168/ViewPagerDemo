package com.jet2006.LearnApp.Modules.ContactBook;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.jet2006.LearnApp.BaseFragment;
import com.jet2006.Framework.QuickAdapter.BaseAdapterHelper;
import com.jet2006.Framework.QuickAdapter.QuickAdapter;
import com.jet2006.LearnApp.R;

import java.util.ArrayList;
import java.util.List;

public class ContactBookFragment extends BaseFragment {
    List<ContactBookItem> dataList;
    ListView listView;
    Handler handler = null;
    QuickAdapter<ContactBookItem> contactBookItemQuickAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (dataList == null) LoadData();
        System.out.println("ContactBookFragment.onCreate===========================");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        System.out.println("ContactBookFragment.onCreateView==========================");

        View view = inflater.inflate(R.layout.fragment_contact_book, container, false);
        if (listView == null) {
            listView = ((ListView) view.findViewById(R.id.lvContactList));

            TextView emptyView = new TextView(getActivity());
            emptyView.setText("nothing!");

            listView.setEmptyView(emptyView);
        }


        return view;
    }

    private void LoadData3() {
        AsyncTask<String, Integer, Object> loadTask = new AsyncTask<String, Integer, Object>() {
            @Override
            protected Object doInBackground(String... params) {
                return null;
            }
        };


    }


    private void LoadData() {
        //开一条子线程加载网络数据
        Runnable runnable = new Runnable() {
            public void run() {
                //Thread.sleep(2000);
                dataList = getAllContacts();
                //发送消息，并把persons结合对象传递过去
                handler.sendMessage(handler.obtainMessage(0, dataList));
            }
        };

        new Thread(runnable).start();

        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                if (msg.what == 0) {
                    @SuppressWarnings("unchecked")
                    ArrayList<ContactBookItem> contactBookItems = (ArrayList<ContactBookItem>) msg.obj;

                    contactBookItemQuickAdapter = new QuickAdapter<ContactBookItem>(getActivity(), R.layout.layout_contactbook_item) {
                        @Override
                        protected void convert(BaseAdapterHelper helper, ContactBookItem item) {
                            helper.setImageResource(R.id.imgContactBookAvatar, item.getImgId())
                                    .setText(R.id.txtTitle, item.getObjectName())
                                    .setText(R.id.txtDesc, item.getPhoneNumber());
                        }
                    };

                    listView.setAdapter(contactBookItemQuickAdapter);
                    contactBookItemQuickAdapter.clear();
                    contactBookItemQuickAdapter.addAll(dataList);

                }
            }
        };
    }


    private List<ContactBookItem> getAllContacts() {

        List<ContactBookItem> contactBookItemList = new ArrayList<ContactBookItem>();

        ContentResolver cr = this.getActivity().getContentResolver();
        // 取得电话本中开始一项的光标,主要就是查询"contacts"表
        Cursor cursor = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        while (cursor.moveToNext()) {
            // 取得联系人名字 (显示出来的名字)，实际内容在 ContactsContract.Contacts中
            int nameIndex = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
            String name = cursor.getString(nameIndex);

            // 取得联系人ID
            String contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));

            // 根据联系人ID查询对应的电话号码
            Cursor phoneNumbers = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = "
                    + contactId, null, null);

            if (phoneNumbers.moveToFirst()) { //没电话的不加！
                ContactBookItem contactBookItem = new ContactBookItem();
                contactBookItem.setObjectName(name);
                contactBookItem.setImgId(R.drawable.cavater2);
                contactBookItem.setPhoneNumber(phoneNumbers.getString(phoneNumbers.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)));
                contactBookItemList.add(contactBookItem);
            }
            phoneNumbers.close();
        }
        cursor.close();
        return contactBookItemList;
    }


    private StringBuilder getContacts() {
        StringBuilder sbLog = new StringBuilder();
        // 得到ContentResolver对象
        ContentResolver cr = this.getActivity().getContentResolver();
        // 取得电话本中开始一项的光标,主要就是查询"contacts"表
        Cursor cursor = cr.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
        if (!cursor.moveToFirst()) {
            sbLog.append("获取内容为空！");
            return sbLog;
        }
        if (cursor.moveToFirst()) {


            // 取得联系人名字 (显示出来的名字)，实际内容在 ContactsContract.Contacts中
            int nameIndex = cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME);
            String name = cursor.getString(nameIndex);
            sbLog.append("name=" + name + ";");

            // 取得联系人ID
            String contactId = cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts._ID));

            // 根据联系人ID查询对应的电话号码
            Cursor phoneNumbers = cr.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = "
                    + contactId, null, null);
            // 取得电话号码(可能存在多个号码)
            while (phoneNumbers.moveToNext()) {
                String strPhoneNumber = phoneNumbers.getString(phoneNumbers.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                sbLog.append("Phone=" + strPhoneNumber + ";");
            }
            phoneNumbers.close();

            // 根据联系人ID查询对应的email
            Cursor emails = cr.query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, null, ContactsContract.CommonDataKinds.Email.CONTACT_ID + " = "
                    + contactId, null, null);
            // 取得email(可能存在多个email)
            while (emails.moveToNext()) {
                String strEmail = emails.getString(emails.getColumnIndex(ContactsContract.CommonDataKinds.Email.DATA));
                sbLog.append("Email=" + strEmail + ";");
            }
            emails.close();

        }
        cursor.close();
        //Log.e("-------------------", sbLog.toString());
        return sbLog;
    }

}
