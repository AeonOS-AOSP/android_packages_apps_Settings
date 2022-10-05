/*
 * SPDX-FileCopyrightText: AeonOS Project
 * SPDX-License-Identifier: Apache-2.0
 */

package com.android.settings.deviceinfo.firmwareversion;

import android.content.Context;
import android.os.SystemProperties;
import android.text.TextUtils;

import androidx.annotation.VisibleForTesting;

import com.android.settings.R;
import com.android.settings.Utils;
import com.android.settings.core.BasePreferenceController;

public class AeonOSVersionPreferenceController extends BasePreferenceController {

    @VisibleForTesting
    static final String AEONOS_VERSION_PROPERTY = "ro.aeon.display.version";

    public AeonOSVersionPreferenceController(Context context, String preferenceKey) {
        super(context, preferenceKey);
    }

    @Override
    public int getAvailabilityStatus() {
        return !TextUtils.isEmpty(SystemProperties.get(AEONOS_VERSION_PROPERTY)) ? AVAILABLE : UNSUPPORTED_ON_DEVICE;
    }

    @Override
    public CharSequence getSummary() {
        return SystemProperties.get(AEONOS_VERSION_PROPERTY,
                mContext.getString(R.string.aeonos_version_default));
    }
}
