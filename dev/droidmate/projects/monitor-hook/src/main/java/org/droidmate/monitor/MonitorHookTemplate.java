// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, jamrozik@st.cs.uni-saarland.de
//
// This file is part of the "DroidMate" project.
//
// www.droidmate.org

package org.droidmate.monitor;

import android.content.Context;

// !!!!! =================================================================
// !!!!! DO NOT EDIT THIS FILE !!!
// !!!!! =================================================================
// !!!!! Instead, run full gradle rebuild (see README.md) or do:
// !!!!! 
// !!!!!   cd repo/droidmate/dev/droidmate 
// !!!!!   ./gradlew :projects:monitor-hook:compileJava 
// !!!!! 
// !!!!! This will generate MonitorHook.java in the same directory as this class. Edit that file instead.

/**
 * <p>Please see {@link MonitorHookExample} for an example implementation. Please see comments marked with !!!!! in this file 
 * to understand how to use this class to implement your own {@link IMonitorHook}.</p> 
 */
// These warnings are suppressed because this class is only a stub of an actual implementation.
@SuppressWarnings({"unused", "Duplicates", "FieldCanBeLocal", "WeakerAccess"})
public class MonitorHookTemplate implements IMonitorHook
{

  public void init(Context context) 
  {
  }

  public void hookBeforeApiCall(String apiLogcatMessagePayload)
  {
  }

  public Object hookAfterApiCall(String apiLogcatMessagePayload, Object returnValue)
  {
    return returnValue;
  }

  public void finalizeMonitorHook()
  {
  }
}

