package com.sfkiller.net; 

import java.util.ArrayList;
import java.util.List;

import com.sfkiller.utils.Constants;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * FileName: NetworkStateReceiver
 * Description: Monitor network state
 * Date: 2015/10/24
 * @author SFKiller
 *
 */
public class NetworkStateReceiver extends BroadcastReceiver {

        public static List<NetworkStateHandler> handlerList = new ArrayList<NetworkStateHandler>();

        @Override
        public void onReceive(Context context, Intent intent) {
                for (NetworkStateHandler handler : handlerList) {
                        handler.onNetworkStateChange(networkState(context));
                }

        }

        private Constants.NetworkSate networkState(Context context) {
                Constants.NetworkSate state = Constants.NetworkSate.NO_NETWORK;
                ConnectivityManager cm = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo ni = cm.getActiveNetworkInfo();

                if (null != ni && ni.isConnectedOrConnecting()) {
                        switch(ni.getType()) {
                        case ConnectivityManager.TYPE_WIFI:
                                state = Constants.NetworkSate.WIFI;
                                break;
                        case ConnectivityManager.TYPE_MOBILE:
                                state = Constants.NetworkSate.CELLULAR;
                                break;
                        default:
                                state = Constants.NetworkSate.UNKNOW;
                                break;
                        }
                }
                return state;
        }

}
