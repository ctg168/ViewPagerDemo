package com.terry.viewpagerdemo.Framework.net;

import android.content.Context;
import android.util.Log;
//import android.util.Log;

import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Type;
import java.util.UUID;


public class WebApiCaller<T> {
    public String ServiceUrl = "http://192.168.1.27:9600";
    //protected Class<T> entityClass;

    public WebApiCaller() {
        //entityClass = ReflectUtils.getClassGenricType(getClass());
    }

    public void InvokeMethod(Context context, String controllerName,
                             String methodName, final Object[] params, final Class<T> cl) {

        String url = this.ServiceUrl + "/xapi/" + controllerName + "/"
                + methodName + "?rd=" + UUID.randomUUID().toString();

        Log.i("jet2006", url);

        Response.Listener<String> listener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                T obj = gson.fromJson(response, cl);
                OnResponse(obj);
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String errmsg = error.getMessage() + "";
                Log.i("jet2006 ", errmsg);
            }
        };

        StringRequest request = new StringRequest(Request.Method.POST, url,
                listener, errorListener) {
            @Override
            protected Response<String> parseNetworkResponse(
                    NetworkResponse response) {
                // TODO Auto-generated method stub
                String str = null;
                try {
                    str = new String(response.data, "utf-8");
                } catch (UnsupportedEncodingException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                return Response.success(str,
                        HttpHeaderParser.parseCacheHeaders(response));
            }

            private JsonObject GetPostObject(final Object[] params)
                    throws Exception {
                JsonObject obj = new JsonObject();
                for (int i = 0; i < params.length; i++) {
                    Object param = params[i];
                    String key = String.format("Param%d", i);

                    if (param instanceof Integer) {
                        obj.addProperty(key, (Integer) param);
                    } else if (param instanceof Boolean) {
                        obj.addProperty(key, (Boolean) param);
                    } else if (param instanceof Character) {
                        obj.addProperty(key, (Character) param);
                    } else if (param instanceof Long) {
                        obj.addProperty(key, (Long) param);
                    } else if (param instanceof Short) {
                        obj.addProperty(key, (Short) param);
                    } else if (param != null) {
                        Gson gson = new Gson();
                        JsonElement ele = gson.toJsonTree(param);
                        obj.add(key, ele);
                    } else {
                        throw new Exception("参数类型无法识别!");
                    }
                }

                return obj;
            }

            @Override
            public byte[] getBody() {
                JsonObject obj = null;
                try {
                    obj = this.GetPostObject(params);
                } catch (Exception e) {
                    // TODO �Զ���ɵ� catch ��
                    e.printStackTrace();
                }

                if (obj != null) {
                    Gson gson = new Gson();
                    String str = gson.toJson(obj);

                    return str.getBytes();
                } else {
                    return null;
                }
            }
        };

        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(request);

        Log.i("jet2006", "queue.start");

        queue.start();
    }


    public void InvokeMethod(Context context, String controllerName,
                             String methodName, final Object[] params, final Type type) {

        String url = this.ServiceUrl + "/xapi/" + controllerName + "/"
                + methodName + "?rd=" + UUID.randomUUID().toString();

        Log.i("jet2006", url);

        Response.Listener<String> listener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("jet2006", "onResponse in webapi caller.");
                Gson gson = new Gson();
                T obj = gson.fromJson(response, type);
                OnResponse(obj);
            }
        };

        Response.ErrorListener errorListener = new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                String errmsg = error.getMessage();
                //Log.e("Error: ", errmsg);
            }
        };

        StringRequest request = new StringRequest(Request.Method.POST, url,
                listener, errorListener) {
            @Override
            protected Response<String> parseNetworkResponse(
                    NetworkResponse response) {
                // TODO Auto-generated method stub
                String str = null;
                try {
                    str = new String(response.data, "utf-8");
                } catch (UnsupportedEncodingException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                return Response.success(str,
                        HttpHeaderParser.parseCacheHeaders(response));
            }

            private JsonObject GetPostObject(final Object[] params)
                    throws Exception {
                JsonObject obj = new JsonObject();
                for (int i = 0; i < params.length; i++) {
                    Object param = params[i];
                    String key = String.format("Param%d", i);

                    if (param instanceof Integer) {
                        obj.addProperty(key, (Integer) param);
                    } else if (param instanceof Boolean) {
                        obj.addProperty(key, (Boolean) param);
                    } else if (param instanceof Character) {
                        obj.addProperty(key, (Character) param);
                    } else if (param instanceof Long) {
                        obj.addProperty(key, (Long) param);
                    } else if (param instanceof Short) {
                        obj.addProperty(key, (Short) param);
                    } else if (param != null) {
                        Gson gson = new Gson();
                        JsonElement ele = gson.toJsonTree(param);
                        obj.add(key, ele);
                    } else {
                        throw new Exception("无法识别的参数类型!");
                    }
                }

                return obj;
            }

            @Override
            public byte[] getBody() {
                JsonObject obj = null;
                try {
                    obj = this.GetPostObject(params);
                } catch (Exception e) {
                    // TODO �Զ���ɵ� catch ��
                    e.printStackTrace();
                }

                if (obj != null) {
                    Gson gson = new Gson();
                    String str = gson.toJson(obj);

                    return str.getBytes();
                } else {
                    return null;
                }
            }
        };

        RequestQueue queue = Volley.newRequestQueue(context);
        queue.add(request);
        queue.start();
    }

    public void OnResponse(T obj) {

    }
}