//package com.bignerdranch.android.weingcraft;
//
//import android.content.ContentValues;
//import android.os.StrictMode;
//
//import org.xmlpull.v1.XmlPullParser;
//import org.xmlpull.v1.XmlPullParserException;
//import org.xmlpull.v1.XmlPullParserFactory;
//
//import java.io.IOException;
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.util.ArrayList;
//
//public class ForeCastManager extends Thread {
//    String lon, lat;
//
//    ArrayList<ContentValues> mWeatehr;
//    MainActivity mContext;
//
//    public ArrayList<ContentValues> getmWeather() {
//        return mWeatehr;
//    }
//
//    public ForeCastManager(String lon, String lat, MainActivity mContext) {
//        this.lon = lon;
//        this.lat = lat;
//        this.mContext = mContext;
//    }
//
//
//    public ArrayList<ContentValues> GetOpenWeather(String lon, String lat) {
//
//        ArrayList<ContentValues> mTotalValue = new ArrayList<>();
//        String key = "16419d13b0e5809f2247ea9c44d255aa";
//        try {
//            URL url = new URL("http://api.openweathermap.org/data/2.5/weather?" +
//                    "lat=" +lat+
//                    "&lon=" +lon+
//                    "&mode=xml"+
//                    "&APPID=" + key );
//
//
//            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
//            // 위에서 생성된 URL을 통하여 서버에 요청하면 결과가 XML Resource로 전달됨
//            XmlPullParser parser = factory.newPullParser();
//            // XML Resource를 파싱할 parser를 factory로 생성
//            parser.setInput(url.openStream(), null);
//            // 파서를 통하여 각 요소들의 이벤트성 처리를 반복수행
//            int parserEvent = parser.getEventType();
//            while (parserEvent != XmlPullParser.END_DOCUMENT) {
//
//                if (parserEvent == XmlPullParser.START_TAG && parser.getName().equals("time")) {
//                    //시작태그의 이름을 알아냄
//
//                    int checkStartTag = parserEvent;
//                    ContentValues mContent = new ContentValues();
//
//                    for (; ; ) {
//                        if (checkStartTag == XmlPullParser.START_TAG && parser.getName().equals("time")) {
//                            mContent.put("day", parser.getAttributeValue(null, "day"));
//                        } else if (checkStartTag == XmlPullParser.START_TAG && parser.getName().equals("symbol")) {
//                            mContent.put("weather_Name", parser.getAttributeValue(null, "name"));
//                            mContent.put("weather_Number", parser.getAttributeValue(null, "number"));
//                        } else if (checkStartTag == XmlPullParser.START_TAG &&
//
//                                parser.getName().equals("precipitation")) {
//                            mContent.put("weather_Much", parser.getAttributeValue(null, "value"));
//                            mContent.put("weather_Type", parser.getAttributeValue(null, "type"));
//                        } else if (checkStartTag == XmlPullParser.START_TAG &&
//
//                                parser.getName().equals("windDirection")) {
//                            mContent.put("wind_Direction", parser.getAttributeValue(null, "name"));
//                            mContent.put("wind_SortNumber", parser.getAttributeValue(null, "deg"));
//                            mContent.put("wind_SortCode", parser.getAttributeValue(null, "code"));
//                        } else if (checkStartTag == XmlPullParser.START_TAG && parser.getName().equals("windSpeed")) {
//                            mContent.put("wind_Speed", parser.getAttributeValue(null, "mps"));
//                            mContent.put("wind_Name", parser.getAttributeValue(null, "name"));
//                        } else if (checkStartTag == XmlPullParser.START_TAG &&
//
//                                parser.getName().equals("temperature")) {
//                            mContent.put("temp_Min", parser.getAttributeValue(null, "min"));
//                            mContent.put("temp_Max", parser.getAttributeValue(null, "max"));
//                        } else if (checkStartTag == XmlPullParser.START_TAG && parser.getName().equals("humidity")) {
//                            mContent.put("humidity", parser.getAttributeValue(null, "value"));
//                            mContent.put("humidity_unit", parser.getAttributeValue(null, "unit"));
//                        } else if (checkStartTag == XmlPullParser.START_TAG && parser.getName().equals("clouds")) {
//                            mContent.put("Clouds_Sort", parser.getAttributeValue(null, "value"));
//                            mContent.put("Clouds_Value", parser.getAttributeValue(null, "all"));
//                            mContent.put("Clouds_Per", parser.getAttributeValue(null, "unit"));
//                            mTotalValue.add(mContent);
//                            break;
//                        }
//                        checkStartTag = parser.next();
//                    }
//
//                }
//                parserEvent = parser.next();
//            }
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (XmlPullParserException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        return mTotalValue;
//    }
//    @Override
//    public void run() {
//        super.run();
//        if (android.os.Build.VERSION.SDK_INT > 9) {
//            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
//            StrictMode.setThreadPolicy(policy);
//        }
//        mWeatehr = GetOpenWeather(lon, lat);
//        mContext.handler.sendEmptyMessage(mContext.THREAD_HANDLER_SUCCESS_INFO);
//        //Thread 작업 종료, UI 작업을 위해 MainHandler에 Message보냄    }
//    }
//
//
//}


