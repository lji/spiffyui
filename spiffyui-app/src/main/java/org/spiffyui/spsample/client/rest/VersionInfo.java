/*
 * Copyright (c) 2010, 2011 Unpublished Work of Novell, Inc. All Rights Reserved.
 *
 * THIS WORK IS AN UNPUBLISHED WORK AND CONTAINS CONFIDENTIAL,
 * PROPRIETARY AND TRADE SECRET INFORMATION OF NOVELL, INC. ACCESS TO
 * THIS WORK IS RESTRICTED TO (I) NOVELL, INC. EMPLOYEES WHO HAVE A NEED
 * TO KNOW HOW TO PERFORM TASKS WITHIN THE SCOPE OF THEIR ASSIGNMENTS AND
 * (II) ENTITIES OTHER THAN NOVELL, INC. WHO HAVE ENTERED INTO
 * APPROPRIATE LICENSE AGREEMENTS. NO PART OF THIS WORK MAY BE USED,
 * PRACTICED, PERFORMED, COPIED, DISTRIBUTED, REVISED, MODIFIED,
 * TRANSLATED, ABRIDGED, CONDENSED, EXPANDED, COLLECTED, COMPILED,
 * LINKED, RECAST, TRANSFORMED OR ADAPTED WITHOUT THE PRIOR WRITTEN
 * CONSENT OF NOVELL, INC. ANY USE OR EXPLOITATION OF THIS WORK WITHOUT
 * AUTHORIZATION COULD SUBJECT THE PERPETRATOR TO CRIMINAL AND CIVIL
 * LIABILITY.
 *
 * ========================================================================
 */
package org.spiffyui.spsample.client.rest;

import org.spiffyui.client.JSONUtil;
import org.spiffyui.client.MessageUtil;
import org.spiffyui.client.rest.RESTCallback;
import org.spiffyui.client.rest.RESTException;
import org.spiffyui.client.rest.RESTObjectCallBack;
import org.spiffyui.client.rest.RESTility;

import com.google.gwt.json.client.JSONObject;
import com.google.gwt.json.client.JSONValue;


/**
 * A bean for holding version info
 */
public final class VersionInfo
{
    private static VersionInfo g_versionInfo;

    private String m_version;
    private String m_user;
    private String m_rev;
    private String m_date;

    private VersionInfo()
    {
        
    }

    /**
     * Gets the version
     *
     * @return the version
     */
    public String getVersion()
    {
        return m_version;
    }
    
    public String getUser()
    {
        return m_user;
    }
    
    public String getRevision()
    {
        return m_rev;
    }
    
    public String getDate()
    {
        return m_date;
    }

    private static void createVersionInfo(JSONValue val, RESTObjectCallBack<VersionInfo> callback)
    {
        JSONObject bi = val.isObject();
        if (bi == null) {
            MessageUtil.showError("An error occurred trying to get version info.");
            return;
        }
        g_versionInfo = new VersionInfo();
        
        g_versionInfo.m_version = JSONUtil.getStringValue(bi, "version");
        g_versionInfo.m_user = JSONUtil.getStringValue(bi, "user");
        g_versionInfo.m_rev = JSONUtil.getStringValue(bi, "rev");
        g_versionInfo.m_date = JSONUtil.getStringValue(bi, "date");
        
        callback.success(g_versionInfo);
    }

    /**
     * Gets the version info from the server
     *
     * @param callback the REST callback
     */
    public static void getVersionInfo(final RESTObjectCallBack<VersionInfo> callback)
    {
        if (g_versionInfo != null) {
            /*
             The version info doesn't change while the page is still running
             so we can cache it and save an HTTP call.
             */
            callback.success(g_versionInfo);
            return;
        }

        RESTility.callREST("version", new RESTCallback() {
                @Override
                public void onSuccess(JSONValue val)
                {
                    createVersionInfo(val, callback);
                }

                @Override
                public void onError(int statusCode, String errorResponse)
                {
                    callback.error(errorResponse);
                }

                @Override
                public void onError(RESTException e)
                {
                    callback.error(e);
                }
            });
    }
}