package com.sfkiller.net;

import com.sfkiller.utils.Constants;

/**
 * FileName: NetworkStatenotify
 * Description: Interface for monitor network change
 * Date: 2015/10/24
 * @author SFKiller
 *
 */

public interface NetworkStateHandler {

        /**
         * @param: networkstateCode State of network
         */
        public abstract void onNetworkStateChange(Constants.NetworkSate networkstateCode);
}
