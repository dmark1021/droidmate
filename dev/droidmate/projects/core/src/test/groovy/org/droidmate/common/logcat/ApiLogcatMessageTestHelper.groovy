// Copyright (c) 2012-2016 Saarland University
// All rights reserved.
//
// Author: Konrad Jamrozik, jamrozik@st.cs.uni-saarland.de
//
// This file is part of the "DroidMate" project.
//
// www.droidmate.org

package org.droidmate.common.logcat

import org.droidmate.MonitorConstants
import org.droidmate.logcat.IApiLogcatMessage

import java.time.LocalDateTime

class ApiLogcatMessageTestHelper
{

  public static final String log_level_for_testing = "I"

  static IApiLogcatMessage newApiLogcatMessage(Map apiAttributes)
  {
    def time = apiAttributes.remove("time") as LocalDateTime
    apiAttributes["stackTrace"] = apiAttributes["stackTrace"] ?: "$Api.monitorRedirectionPrefix"

    def logcatMessage = TimeFormattedLogcatMessage.from(
      time ?: TimeFormattedLogcatMessage.assumedDate,
      log_level_for_testing,
      MonitorConstants.tag_api,
      "3993", // arbitrary process ID
      ApiLogcatMessage.toLogcatMessagePayload(new Api(apiAttributes))
    )

    return ApiLogcatMessage.from(logcatMessage)
  }


}
